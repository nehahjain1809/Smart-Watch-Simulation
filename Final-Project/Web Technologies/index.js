var http = require("http");
var fs = require("fs");
var gravatar = require('gravatar');
var cors = require('cors');

// We are considering local JSON file, for backup we can also store it on the remote server
const fileName = "contacts.json"

//Check if file exists and if not create a new file and initialize the default json structure
function checkForFile(fileName, callback) {
	fs.exists(fileName, function (exists) {
        if(exists)
        {
            callback();
        }else
        {
            fs.writeFile(fileName, '{"contacts":[]}',{flag: 'wx'}, function (err, data) 
            { 
                callback();
            })
        }
    });
}

// Add the new contact to the JSON file and sorts it by lastname while adding it
// We can optimize the sorting by using different data structures like tree where insertion in balanced BST would be log n
function addContact(newContact,callback) {
    fs.readFile(fileName, 'utf8', function (err, data) {
        let listOfContacts = JSON.parse(data);
        listOfContacts.contacts.push(JSON.parse(newContact));
        listOfContacts.contacts.sort(function(a, b) {
            if(a.lastname > b.lastname) return -1;
            else if (a.lastname < b.lastname) return 1;
            return 0;
        });
        
        fs.writeFile(fileName, JSON.stringify(listOfContacts),'utf8');
        callback();
    });
}

// Delete the asked contact from the JSON file.
function deleteContact(id,callback) {
    fs.readFile(fileName, 'utf8', function (err, data) {
        let listOfContacts = JSON.parse(data);
        listOfContacts.contacts.splice(id,1);
        
        fs.writeFile(fileName, JSON.stringify(listOfContacts),'utf8');
        callback();
    });
}
// Helper function to get string format of a JSON structure
function getStringJson(text) {
    var json = {}, text = text.split("&");
    for (let i in text){
        let box = text[i].split("=");
        box[1] = box[1].replace(/%2C/g, ',').replace(/%2F/g, '/').replace(/%40/g,'@').replace(/\+/g,' ').replace(/%2B/g, '+');
        json[box[0]] = box[1];
    }
    return JSON.stringify(json);
}

//We will send them a 404 response if page doesn't exist
function send404Response(response){
    response.writeHead(404, {"Content-Type": "text/plain"});
    response.write("Error 404 - Page not found");
    response.end();
}

//Handles different kinds of request
function onRequest(request, response) {
    
    // Request method to load the initial homepage
    if( request.method == 'GET' && request.url == '/' ){
        response.writeHead(200, {"Content-Type": "text/html"});
        //Open file as readable stream, pipe stream to response object
        fs.createReadStream("./homepage.html").pipe(response);
    }
    // Request method to load the list of contacts on the homepage
    // The contacts are loaded from JSON file asynchronously
    else if( request.method == 'GET' && request.url == '/loadData' ){
    	checkForFile(fileName, function() {
    		fs.readFile(fileName, 'utf8', function (err, data) {
				response.writeHead(200, {"Content-Type": "text/html"});
		        response.write(data);
				response.end();
			});
    	});
    }
    // Request to add new contact to our JSON file
    else if( request.method == 'POST' && request.url == '/addContact' ){
        var jsonString = '';

        request.on('data', function (data) {
            jsonString += data;
        });

        request.on('end', function () {
            newContact = getStringJson(jsonString);
            addContact(newContact, function() {
                fs.readFile(fileName, 'utf8', function (err, data) {
                    response.writeHead(200, {"Content-Type": "text/html"});
                    response.write(data);
                    response.end();
                });
            });

        });
    }
    // Request to extract the contact details of a specific person
    else if( request.method == 'POST' && request.url == '/viewContact' ){
        var jsonString = '';
        request.on('data', function (data) {
            jsonString += data;
        });

        request.on('end', function () {
            let id = parseInt(jsonString.split("=")[1]);
            checkForFile(fileName, function() {
                fs.readFile(fileName, 'utf8', function (err, data) {
                    response.writeHead(200, {"Content-Type": "text/html"});
                    data = JSON.parse(data);
                    data = data.contacts[id]
                    var profile = gravatar.profile_url(data.email, {protocol: 'https'});
                    data["profile_pic"] = profile;
                    response.write(JSON.stringify(data));
                    response.end();
                });
            });
        });
    }
    // Request to extract the contact details of a specific person
    else if( request.method == 'POST' && request.url == '/deleteContact' ){
        var jsonString = '';
        request.on('data', function (data) {
            jsonString += data;
        });

        request.on('end', function () {
            let id = parseInt(jsonString.split("=")[1]);
            deleteContact(id,function(){
                response.writeHead(200, {"Content-Type": "text/html"});
                //Open file as readable stream, pipe stream to response object
                fs.createReadStream("./homepage.html").pipe(response);
            });
        });
    }
    // Request if page not found
    else{
        send404Response(response);
    }
}

// Creates server
http.createServer(onRequest).listen(8080);
console.log("Server is now running...");