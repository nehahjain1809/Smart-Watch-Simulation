/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import Business.Person.Person;
import java.util.Date;

/**
 *
 * @author nehah
 */
public class VitalSigns {
    
    private int id;
    private Person p;
    private int heartRate;
    private int bloodPressure;
    private float sugarLevel;
    private float waterLevel;
    private Date date;
    
    private static int count;
    
    public VitalSigns(){
        count++;
        id=count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public float getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(float sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

 

    public void setSugarLevel(int sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public float getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(float waterLevel) {
        this.waterLevel = waterLevel;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        VitalSigns.count = count;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
