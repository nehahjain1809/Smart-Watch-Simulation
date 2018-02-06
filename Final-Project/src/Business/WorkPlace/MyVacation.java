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
public class MyVacation {
    
    private Person p;
    private Date startDate;
    private Date endDate;
    private int totalNumberofDays;
    private String status;
    private static int count;
    private int myVaccId;
    private String type;
    
    
    public MyVacation(){
        count++;
        myVaccId=count;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getTotalNumberofDays() {
        return totalNumberofDays;
    }

    public void setTotalNumberofDays(int totalNumberofDays) {
        this.totalNumberofDays = totalNumberofDays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        MyVacation.count = count;
    }

    public int getMyVaccId() {
        return myVaccId;
    }

    public void setMyVaccId(int myVaccId) {
        this.myVaccId = myVaccId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
    
}
