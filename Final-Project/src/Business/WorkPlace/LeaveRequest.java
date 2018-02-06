/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkPlace;

import Business.Person.Person;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author nehah
 */
public class LeaveRequest {
    private Person p;
    private Supervisor s;
    private Date vaccStartDate;
    private Date vaccEndDate;
    private static int count;
    private int requestId;
    private String status;
    private int totalNumberofDays;
    
    
    public LeaveRequest(){
        count++;
        requestId=count;
    }
    public Person getP() {
        return p;
    }

    public int getTotalNumberofDays() {
        return totalNumberofDays;
    }

    public void setTotalNumberofDays(int totalNumberofDays) {
        this.totalNumberofDays = totalNumberofDays;
    }
    
    public void setP(Person p) {
        this.p = p;
    }

    public Supervisor getS() {
        return s;
    }

    public void setS(Supervisor s) {
        this.s = s;
    }

//    public LocalDate getVaccStartDate() {
//        return vaccStartDate;
//    }
//
//    public void setVaccStartDate(LocalDate vaccStartDate) {
//        this.vaccStartDate = vaccStartDate;
//    }
//
//    public LocalDate getVaccEndDate() {
//        return vaccEndDate;
//    }
//
//    public void setVaccEndDate(LocalDate vaccEndDate) {
//        this.vaccEndDate = vaccEndDate;
//    }

    public Date getVaccStartDate() {
        return vaccStartDate;
    }

    public void setVaccStartDate(Date vaccStartDate) {
        this.vaccStartDate = vaccStartDate;
    }

    public Date getVaccEndDate() {
        return vaccEndDate;
    }

    public void setVaccEndDate(Date vaccEndDate) {
        this.vaccEndDate = vaccEndDate;
    }

   

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        LeaveRequest.count = count;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
