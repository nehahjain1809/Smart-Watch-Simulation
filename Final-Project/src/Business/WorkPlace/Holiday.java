/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkPlace;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author nehah
 */
public class Holiday {
    
    private String country;
    private String state;
    private int date;
    private int month;
    private int year;
    private boolean  isHoliday;
    private String holidayDescription;
    private int holidayId;
    private static int count;
    private Date datetime;

    SimpleDateFormat sdf=new SimpleDateFormat("mm:dd:yyyy");
    
    public Holiday(){
        count++;
        holidayId=holidayId;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
    
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isIsHoliday() {
        return isHoliday;
    }

    public void setIsHoliday(boolean isHoliday) {
        this.isHoliday = isHoliday;
    }

    public String getHolidayDescription() {
        return holidayDescription;
    }

    public void setHolidayDescription(String holidayDescription) {
        this.holidayDescription = holidayDescription;
    }

    public int getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(int holidayId) {
        this.holidayId = holidayId;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Holiday.count = count;
    }
    
   // public Date getDate(){
    public Date getDate(int month, int date, int year) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    try {
       // JOptionPane.showMessageDialog(null, dateFormat.parse(month+"-"+date+"-"+year));
        return dateFormat.parse(month+"/"+date+"/"+year);
        
    }
    catch(Exception e){
    }
    return null;
}
}