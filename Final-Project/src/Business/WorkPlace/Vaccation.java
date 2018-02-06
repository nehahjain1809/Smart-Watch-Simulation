/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkPlace;

import java.util.Date;

/**
 *
 * @author nehah
 */
public class Vaccation {
    
    private static int count;
    private int vaccationId;
    private int startDate;
    private int endDate;
    private int startMonth;
    private int endMonth;
    private int startYear;
    private int endYear;
    private Date vaccstartDate;
    private Date vaccendDate;
    private int totalNumberOfDays;
    private int weightage;
    
    public Vaccation(){
       count++;
       vaccationId=count;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Vaccation.count = count;
    }

    public int getVaccationId() {
        return vaccationId;
    }

    public void setVaccationId(int vaccationId) {
        this.vaccationId = vaccationId;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public Date getVaccstartDate() {
        return vaccstartDate;
    }

    public void setVaccstartDate(Date vaccstartDate) {
        this.vaccstartDate = vaccstartDate;
    }

    public Date getVaccendDate() {
        return vaccendDate;
    }

    public void setVaccendDate(Date vaccendDate) {
        this.vaccendDate = vaccendDate;
    }

    public int getTotalNumberOfDays() {
        return totalNumberOfDays;
    }

    public void setTotalNumberOfDays(int totalNumberOfDays) {
        this.totalNumberOfDays = totalNumberOfDays;
    }

    public int getWeightage() {
        return weightage;
    }

    public void setWeightage(int weightage) {
        this.weightage = weightage;
    }
    
    
    
    
}
