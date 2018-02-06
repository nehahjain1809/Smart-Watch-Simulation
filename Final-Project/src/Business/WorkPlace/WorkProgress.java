/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkPlace;

import Business.Person.Person;
import java.util.Date;

/**
 *
 * @author nehah
 */
public class WorkProgress {
   private Person p;
   private String projectName;
   private Date date;
   private Supervisor supervisor;
   private int progress;
   private int id;
   private static int count;
   public WorkProgress(){
       count++;
       id=count;
   }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        WorkProgress.count = count;
    }
   
   
   
   
}
