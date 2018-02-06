/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author nehah
 */
public class LabAssistant {
    
    private int assistantID;
    private String assistantName;
    //private ArrayList<Appointment> appointmentList;
    private static int count;
    private UserAccount ua;
    private String emailId;
    private String pwd;
    
    public LabAssistant(){
        count++;  
        assistantID=count;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    
    public int getAssistantID() {
        return assistantID;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    

    public void setAssistantID(int assistantID) {
        this.assistantID = assistantID;
    }

    public UserAccount getUa() {
        return ua;
    }

    public void setUa(UserAccount ua) {
        this.ua = ua;
    }

    
    public String getAssistantName() {
        return assistantName;
    }

    public void setAssistantName(String assistantName) {
        this.assistantName = assistantName;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        LabAssistant.count = count;
    }

    public String toString(){
        return assistantName;
    }
  
}
