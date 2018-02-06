/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Routine;

import Business.Person.Person;
import java.util.Date;

/**
 *
 * @author nehah
 */
public class Sleep {
    
    private int id;
    private static int count;
    private Person p;
    private float sleepHours;
    private Date date;

    public Sleep() {
        count++;
        id=count;
        date=new Date();
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
        Sleep.count = count;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public float getSleepHours() {
        return sleepHours;
    }

    public void setSleepHours(float sleepHours) {
        this.sleepHours = sleepHours;
    }
    
    
    
        
    
//    public String toString(){
//        return String.valueOf(date);
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
