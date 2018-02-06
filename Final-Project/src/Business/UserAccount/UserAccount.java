/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Hospital.Doctor;
import Business.Hospital.LabAssistant;
import static Business.Organization.Organization.Type.Doctor;
import static Business.Organization.Organization.Type.TeamLeader;
import Business.Person.Person;
import Business.Role.Role;
import Business.WorkPlace.Supervisor;
import Business.WorkPlace.TeamLeader;
import Business.WorkQueue.WorkQueuePersonDoc;

/**
 *
 * @author KRISH PRAVIN JAIN
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private Person p;
    private Doctor d;
    private LabAssistant l;
    private Supervisor s;
    private TeamLeader t;
   // private WorkQueue workQueue;
    private WorkQueuePersonDoc workQueuePersonDoc;

    public UserAccount() {
        workQueuePersonDoc = new WorkQueuePersonDoc();
    }

    public void setWorkQueuePersonDoc(WorkQueuePersonDoc workQueuePersonDoc) {
        this.workQueuePersonDoc = workQueuePersonDoc;
    }

    public WorkQueuePersonDoc getWorkQueuePersonDoc() {
        return workQueuePersonDoc;
    }

   
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

//    public WorkQueue getWorkQueue() {
//        return workQueue;
//    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public Doctor getD() {
        return d;
    }

    public void setD(Doctor d) {
        this.d = d;
    }

    public LabAssistant getL() {
        return l;
    }

    public void setL(LabAssistant l) {
        this.l = l;
    }

    public Supervisor getS() {
        return s;
    }

    public void setS(Supervisor s) {
        this.s = s;
    }

    public TeamLeader getT() {
        return t;
    }

    public void setT(TeamLeader t) {
        this.t = t;
    }

    
    
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}