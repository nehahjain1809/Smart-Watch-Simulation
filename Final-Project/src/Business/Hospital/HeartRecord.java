/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author ankushdeora
 */
public class HeartRecord {
    private HashMap<Date, Integer> heartRecords;
    private int highBPM ;
    private int lowBPM;
    public HashMap<Date, Integer> getHeartRecords() {
        return heartRecords;
    }

    public void setHeartRecords(HashMap<Date, Integer> heartRecords) {
        this.heartRecords = heartRecords;
    }
    
    public void calculateHighLow(HashMap<Date, Integer> calHeart){
        //HashMap<Date, Integer> getRecords = calHeart.getHeartRecords();
        Object[] dataSet = calHeart.keySet().toArray();
        highBPM = calHeart.get(dataSet[1]);
        lowBPM = calHeart.get(dataSet[1]);
        
        //System.out.println("highBPM:"+highBPM+" lowBPM:"+lowBPM);
        for(Date d: calHeart.keySet()){
            if(calHeart.get(d) > highBPM){
                //System.out.println("high found");
                highBPM = calHeart.get(d);
            }
            if(calHeart.get(d) < lowBPM){
                //System.out.println("low found");
                lowBPM = calHeart.get(d);
            }
        }
        //System.out.println("highBPM:"+highBPM+" lowBPM:"+lowBPM);
    }
    
    public String toString(){
        calculateHighLow(heartRecords);
        return "High: "+highBPM+" low: "+lowBPM;
    }
    
}
