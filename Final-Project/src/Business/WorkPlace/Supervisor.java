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
public class Supervisor {
 
    private static int count;
    private int supervisorId;
    private String supervisorName;
    private ArrayList<Person> personList;
    private ArrayList<LeaveRequest> leaveList;
    private ArrayList<WorkProgress> progressReport;
    private UserAccount useraccount;
    private String emailId;
    private String pwd;
    public Supervisor(){
        count++;
        supervisorId=count;
        personList=new ArrayList<Person>();
        //useraccount=new ArrayList<UserAccount>();
        leaveList=new ArrayList<LeaveRequest>();
        progressReport=new ArrayList<>();
        
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
    

    public UserAccount getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(UserAccount useraccount) {
        this.useraccount = useraccount;
    }
    

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Supervisor.count = count;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    public ArrayList<LeaveRequest> getLeaveList() {
        return leaveList;
    }

    public void setLeaveList(ArrayList<LeaveRequest> leaveList) {
        this.leaveList = leaveList;
    }

    public ArrayList<WorkProgress> getProgressReport() {
        return progressReport;
    }

    public void setProgressReport(ArrayList<WorkProgress> progressReport) {
        this.progressReport = progressReport;
    }
    
    public String toString(){
        return supervisorName;
    }

    
    
    
}
