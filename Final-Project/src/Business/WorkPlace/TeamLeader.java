/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkPlace;

import Business.Person.Person;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author nehah
 */
public class TeamLeader {
    private static int count;
    private int teamleaderId;
    private String teamleaderName;
    
    private ArrayList<Person> personList;
    private ArrayList<Message> msgList;
    
   
    private UserAccount useraccount;
    
    public TeamLeader(){
        count++;
        teamleaderId=count;
        personList=new ArrayList<Person>();
        msgList=new ArrayList<>();
       
        
    }

    public ArrayList<Message> getMsgList() {
        return msgList;
    }

    public void setMsgList(ArrayList<Message> msgList) {
        this.msgList = msgList;
    }

    
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        TeamLeader.count = count;
    }

    public int getTeamleaderId() {
        return teamleaderId;
    }

    public void setTeamleaderId(int teamleaderId) {
        this.teamleaderId = teamleaderId;
    }

    public String getTeamleaderName() {
        return teamleaderName;
    }

    public void setTeamleaderName(String teamleaderName) {
        this.teamleaderName = teamleaderName;
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    public UserAccount getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(UserAccount useraccount) {
        this.useraccount = useraccount;
    }
    
    public String toString(){
        return teamleaderName;
    }
    
}
