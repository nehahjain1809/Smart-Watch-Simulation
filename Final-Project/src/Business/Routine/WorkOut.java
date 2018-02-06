/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Routine;

import Business.Hospital.VitalSigns;
import Business.Person.Person;
import java.util.Date;

/**
 *
 * @author nehah
 */
public class WorkOut {
    
    private Person p;
    private int Id;
    private static int count;
    private float total_calories_burnt;
    private float walking_calories;
    private float running_calories;
    private float gyming_calories;
    private float sweat;
    private Date date;
    private String workouttype;
    private VitalSigns vitalSigns;

    public WorkOut(){
        count++;
        Id=count;
    }
    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        WorkOut.count = count;
    }

    public float getTotal_calories_burnt() {
        return total_calories_burnt;
    }

    public void setTotal_calories_burnt(float total_calories_burnt) {
        this.total_calories_burnt = total_calories_burnt;
    }

    public float getWalking_calories() {
        return walking_calories;
    }

    public void setWalking_calories(float walking_calories) {
        this.walking_calories = walking_calories;
    }

    public float getRunning_calories() {
        return running_calories;
    }

    public void setRunning_calories(float running_calories) {
        this.running_calories = running_calories;
    }

    public float getGyming_calories() {
        return gyming_calories;
    }

    public void setGyming_calories(float gyming_calories) {
        this.gyming_calories = gyming_calories;
    }

    

    public float getSweat() {
        return sweat;
    }

    public void setSweat(float sweat) {
        this.sweat = sweat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWorkouttype() {
        return workouttype;
    }

    public void setWorkouttype(String workouttype) {
        this.workouttype = workouttype;
    }

    public VitalSigns getVitalSigns() {
        return vitalSigns;
    }

    public void setVitalSigns(VitalSigns vitalSigns) {
        this.vitalSigns = vitalSigns;
    }
    
    
    
    
}
