/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Routine;

import Business.Person.Person;
import java.util.ArrayList;

/**
 *
 * @author nehah
 */
public class SleepDirectory {

   private ArrayList<Sleep> sleepDirectory;    
   
   
   public SleepDirectory(){
       sleepDirectory=new ArrayList<Sleep>();
   }

    public ArrayList<Sleep> getSleepDirectory() {
        return sleepDirectory;
    }

    public void setSleepDirectory(ArrayList<Sleep> sleepDirectory) {
        this.sleepDirectory = sleepDirectory;
    }
   
        public Sleep addSleepTracker()
    {
        Sleep s = new Sleep();
        sleepDirectory.add(s);
        return s;
    }
    
     public ArrayList<Sleep> findSleepDirectoryByPerson(Person p){
         ArrayList<Sleep> sList=new ArrayList<Sleep>();
         for(Sleep s: sleepDirectory){
             if(s.getP().equals(p)){
                  sList.add(s);
             }
             return sList;
         }
         return null;
     }
     
    public float calculateAverageSleep(Person p){
         //ArrayList<Sleep> sList=new ArrayList<Sleep>();
            float avgSleephrs=0;
            float totalSleepHrs=0;
            int numberOfDays=0;
            for(Sleep s:p.getSleepTracker()){
                numberOfDays=numberOfDays+1;
                totalSleepHrs=totalSleepHrs+s.getSleepHours();
            }
           avgSleephrs=totalSleepHrs/numberOfDays;
           return avgSleephrs;
     }
}
