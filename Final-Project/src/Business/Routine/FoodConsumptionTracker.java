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
public class FoodConsumptionTracker {
    
    private Person p;
    private float fats;
    private float carbs;
    private float vitamins;
    private float proteins;
    private float watercontent;
    private float totalcalories;
    private Date date;
    private int id;
    private static int count;
    
    public FoodConsumptionTracker(){
        count++;
        id=count;
        //date=new Date();
    }
    
    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public float getFats() {
        return fats;
    }

    public void setFats(float fats) {
        this.fats = fats;
    }

    public float getCarbs() {
        return carbs;
    }

    public void setCarbs(float carbs) {
        this.carbs = carbs;
    }

    public float getVitamins() {
        return vitamins;
    }

    public void setVitamins(float vitamins) {
        this.vitamins = vitamins;
    }

    public float getProteins() {
        return proteins;
    }

    public void setProteins(float proteins) {
        this.proteins = proteins;
    }

    public float getWatercontent() {
        return watercontent;
    }

    public void setWatercontent(float watercontent) {
        this.watercontent = watercontent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        FoodConsumptionTracker.count = count;
    }

    public float getTotalcalories() {
        return totalcalories;
    }

    public void setTotalcalories(float totalcalories) {
        this.totalcalories = totalcalories;
    }
    
    
    
}
