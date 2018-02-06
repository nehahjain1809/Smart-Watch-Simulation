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
public class WorkSchedule {
    private Person p;
    private Date date;
//    private Date starttime;
//    private Date endtime;
 //   private String action;
    private int id;
    private static int count;
    private float totalWorkTime;
    private float totalBreakTime;
    private float totalworkingHours;
    
    public WorkSchedule(){
        count++;
        id=count;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

//    public Date getStarttime() {
//        return starttime;
//    }
//
//    public void setStarttime(Date starttime) {
//        this.starttime = starttime;
//    }

//    public Date getEndtime() {
//        return endtime;
//    }
//
//    public void setEndtime(Date endtime) {
//        this.endtime = endtime;
//    }
//
//    public String getAction() {
//        return action;
//    }
//
//    public void setAction(String action) {
//        this.action = action;
//    }

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
        WorkSchedule.count = count;
    }

//    public Date getTodaysDate() {
//        return todaysDate;
//    }
//
//    public void setTodaysDate(Date todaysDate) {
//        this.todaysDate = todaysDate;
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTotalWorkTime() {
        return totalWorkTime;
    }

    public void setTotalWorkTime(float totalWorkTime) {
        this.totalWorkTime = totalWorkTime;
    }

    public float getTotalBreakTime() {
        return totalBreakTime;
    }

    public void setTotalBreakTime(float totalBreakTime) {
        this.totalBreakTime = totalBreakTime;
    }

    public float getTotalworkingHours() {
        return totalworkingHours;
    }

    public void setTotalworkingHours(float totalworkingHours) {
        this.totalworkingHours = totalworkingHours;
    }

    
 
    
    
}
