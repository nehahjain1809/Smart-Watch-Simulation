/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Helper;

import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Recommendations.RecommendationDirectory;
import Business.Recommendations.Recommendations;
import Business.Routine.Sleep;
import Business.Routine.SleepDirectory;
import Business.WorkPlace.Holiday;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nehah
 */
public class SleepHelper {
 
private float averageSleepHoursForInfants=0;
private float averageSleepHoursForAdults=0;
private float averageSleepHoursForOldies=0;
private ArrayList<Person>personList;
private SleepDirectory sleepTracker;
private RecommendationDirectory recommendationList;
private int thresholdAgeforChildren=18;
private int thresholdAgeforAdults=50;
private int thresholdAgeforOldies=100;
private float bufferSleepGaap=2;


private final  Map<Person, Float> ChildrentList = new HashMap<>();
private final  Map<Person, Float> AdultList = new HashMap<>();
private final  Map<Person, Float> OldiesList = new HashMap<>();

public SleepHelper(ArrayList<Person> personList, SleepDirectory sleepTracker, RecommendationDirectory recommendationList) {
     this.personList=personList;  
     this.sleepTracker=sleepTracker;
     this.recommendationList=recommendationList;
     cleanRecommendations();
     calculateAverageSleepHours();
     averageSleepHoursForInfants=calculateAverageSleepHoursPerAgeGroup(thresholdAgeforChildren);
     averageSleepHoursForAdults=calculateAverageSleepHoursPerAgeGroup(thresholdAgeforAdults);
     averageSleepHoursForOldies=calculateAverageSleepHoursPerAgeGroup(thresholdAgeforOldies);
     
     runSleepRecommender();
    
}
    public void cleanRecommendations(){
        for(Person p: personList){
            for(Recommendations r: recommendationList.getRecommendationsList()){
                if(r.getPerson().getPersonName().equals(p.getPersonName())){
                p.getMyRecommendationsList().remove(r);
                }
            }
        }
    }
        
        private float calculateAverageSleepHours(Person p){
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
        
        private float calculateAverageSleepHoursforAgeGroup(List<Float> list){
            float avgSleephrs=0;
            float totalSleepHrs=0;
            int numberOfDays=0;
            for(Float f:list){
                numberOfDays=numberOfDays+1;
                totalSleepHrs=totalSleepHrs+f;
            }
           avgSleephrs=totalSleepHrs/numberOfDays;
           return avgSleephrs;
        }
                
        private void calculateAverageSleepHours(){
          for(Person p:personList){
            if(p.getPersonAge()<=thresholdAgeforChildren)   {
               float averageSleepHours=calculateAverageSleepHours(p); 
               ChildrentList.put(p,averageSleepHours );
            }
            else if(p.getPersonAge()<=thresholdAgeforAdults){
               float averageSleepHours=calculateAverageSleepHours(p); 
               AdultList.put(p,averageSleepHours );
            }
            else{
               float averageSleepHours=calculateAverageSleepHours(p); 
               OldiesList.put(p,averageSleepHours );
            }

            }
         }  
        
        private float calculateAverageSleepHoursPerAgeGroup(int threshold){
          float average=0; 
          if(threshold<=thresholdAgeforChildren){
              List<Float> list = new ArrayList<Float>(ChildrentList.values());
              average=calculateAverageSleepHoursforAgeGroup(list);
          }
          else if(threshold<=thresholdAgeforAdults){
              List<Float> list = new ArrayList<Float>(AdultList.values());
                average=calculateAverageSleepHoursforAgeGroup(list);
          }
          else{
                List<Float> list = new ArrayList<Float>(OldiesList.values());
                average=calculateAverageSleepHoursforAgeGroup(list);
          }
          
          return average;
        }
        
        private void runSleepRecommender(){
            for(Person p:personList){
                float averageSleephrs = sleepTracker.calculateAverageSleep(p);
                if(p.getPersonAge()<=thresholdAgeforChildren && averageSleephrs<averageSleepHoursForInfants-bufferSleepGaap){
                    Float gap=averageSleepHoursForInfants-bufferSleepGaap-averageSleephrs;
                    Recommendations r=recommendationList.addrecommendation();
                    r.setPerson(p);
                    r.setRecommendationDescription("Your Average Sleep Hours are "+ gap+" hours less than average in your age group");
                    p.getMyRecommendationsList().add(r);
                    
                }
                if(p.getPersonAge()<=thresholdAgeforChildren && averageSleephrs>averageSleepHoursForInfants+bufferSleepGaap){
                    Float gap=averageSleephrs-averageSleepHoursForInfants+bufferSleepGaap;
                    Recommendations r=recommendationList.addrecommendation();
                    r.setPerson(p);
                    r.setRecommendationDescription("Your Average Sleep Hours are "+ gap+" hours more than average in your age group");
                    p.getMyRecommendationsList().add(r);
                }
                if(p.getPersonAge()<=thresholdAgeforAdults && averageSleephrs<averageSleepHoursForAdults-bufferSleepGaap){
                    Float gap=averageSleepHoursForAdults-bufferSleepGaap-averageSleephrs;
                    Recommendations r=recommendationList.addrecommendation();
                    r.setPerson(p);
                    r.setRecommendationDescription("Your Average Sleep Hours are "+ gap+" hours less than average in your age group");
                    p.getMyRecommendationsList().add(r);
                }
                 if(p.getPersonAge()<=thresholdAgeforAdults && averageSleephrs>averageSleepHoursForAdults+bufferSleepGaap){
                    Float gap=averageSleephrs-averageSleepHoursForAdults+bufferSleepGaap;
                    Recommendations r=recommendationList.addrecommendation();
                    r.setPerson(p);
                    r.setRecommendationDescription("Your Average Sleep Hours are "+ gap+" hours more than average in your age group");
                    p.getMyRecommendationsList().add(r);
                }
                 if(p.getPersonAge()<=thresholdAgeforOldies && averageSleephrs<averageSleepHoursForOldies-bufferSleepGaap){
                    Float gap=averageSleepHoursForOldies-bufferSleepGaap-averageSleephrs;
                    Recommendations r=recommendationList.addrecommendation();
                    r.setPerson(p);
                    r.setRecommendationDescription("Your Average Sleep Hours are "+ gap+" hours less than average in your age group");
                    p.getMyRecommendationsList().add(r);
                }
                 if(p.getPersonAge()<=thresholdAgeforOldies && averageSleephrs>averageSleepHoursForOldies+bufferSleepGaap){
                    Float gap=averageSleephrs-averageSleepHoursForOldies+bufferSleepGaap;
                    Recommendations r=recommendationList.addrecommendation();
                    r.setPerson(p);
                    r.setRecommendationDescription("Your Average Sleep Hours are "+ gap+" hours more than average in your age group");
                    p.getMyRecommendationsList().add(r);
                }
            }
        }
        
}
