/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Helper;

/**
 *
 * @author nehah
 */

import Business.Person.Person;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONValue;

public class JsonConvertor {
    Person p;
    
    public JsonConvertor(Person p){
      this.p=p; 
      //converttoJson();
    }


    public void converttoJson(Person p){
        //HashMap<Integer, ArrayList<Person>> person = new HashMap<Integer, ArrayList<Person>>();
        String jsonText = JSONValue.toJSONString(p);
        System.out.println(jsonText);
        // convert from JSON string to Java Object
        //HashMap<Integer, ArrayList<Person>> persons = (HashMap<Integer, ArrayList<Person>>) JSONValue.parse(jsonText);
        System.out.println(JSONValue.parse(jsonText));
    }
    

}
