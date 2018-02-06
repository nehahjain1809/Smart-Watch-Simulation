/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Helper;

import Business.Person.Person;
import Business.Recommendations.RecommendationDirectory;
import Business.Recommendations.Recommendations;
import Business.Routine.FoodConsumptionTracker;
import Business.Routine.SleepDirectory;
import Business.Routine.WorkOutDirectory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nehah
 */
public class RoutineHelper {
    
    ArrayList<Person> personList;
   // FoodConsumptionTracker foodTracker; 
   // WorkOutDirectory workOutDirectory;
    RecommendationDirectory recommendationsList;
    
    private float bmi_buffer_women=2;
    private float bmi_buffer_men=3;
    private float average_underweight_bmi=18;
    private float average_healthy_bmi=21;
    private float average_overweight_bmi=27;
    private float average_obese_bmi=30;
    
    private final  Map<Person, Float> FemaleList = new HashMap<>();
    private final  Map<Person, Float> MaleList = new HashMap<>();
    private final  Map<Person, Float> underWeightFemaleList = new HashMap<>();
    private final  Map<Person, Float> underWeightMaleList = new HashMap<>();
    private final  Map<Person, Float> overWeightFemaleList = new HashMap<>();
    private final  Map<Person, Float> overWeightMaleList = new HashMap<>();
    private final  Map<Person, Float> ObseseFemaleList = new HashMap<>();
    private final  Map<Person, Float> ObseseMaleList = new HashMap<>();
    
    
    public RoutineHelper(ArrayList<Person> personList, 
                        //FoodConsumptionTracker foodTracker, 
                        //WorkOutDirectory workOutDirectory, 
                        RecommendationDirectory recommendationsList){
        
        this.personList=personList;
      //  this.foodTracker=foodTracker;
        //this.workOutDirectory=workOutDirectory;
        this.recommendationsList=recommendationsList;
        calculatebmi();
        categoriseAccToGender();
        categorizeAccordingtoBMI();
        //cleanRecommendations();
        runRecommender();
    }
    
    public void cleanRecommendations(){
        for(Person p: personList){
            for(Recommendations r: recommendationsList.getRecommendationsList()){
                if(r.getPerson().getPersonName().equals(p.getPersonName())){
                p.getMyRecommendationsList().remove(r);
                }
            }
        }
    }
    private void calculatebmi(){
        for(Person p:personList){
        float height=p.getHeight();
        float weight=p.getWeight();
        float heightinmeter = (float) (height/3.28);
        float heightmetersquare = heightinmeter*heightinmeter;
        float bmi = weight/heightmetersquare;
        p.setBmi(bmi);
        //return bmi;
     
        }
    }
    
    public void categoriseAccToGender()
    {
        for(Person p : personList)
        {
            if(p.getGender().equals("Female")){
               FemaleList.put(p, p.getBmi());
            }
            else{
                MaleList.put(p, p.getBmi());
            }
            
        }
    }
    
    public void categorizeAccordingtoBMI(){
        for(Person p: FemaleList.keySet()){
            if(p.getBmi()<average_healthy_bmi){
                underWeightFemaleList.put(p, average_healthy_bmi-p.getBmi());
            }
            else if(p.getBmi()>average_healthy_bmi && p.getBmi()<=average_overweight_bmi){
                overWeightFemaleList.put(p, p.getBmi()-average_healthy_bmi);
            }
            else {
                ObseseFemaleList.put(p, p.getBmi()-average_healthy_bmi);
            }
        }
        
         for(Person p: MaleList.keySet()){
            if(p.getBmi()<average_healthy_bmi){
                underWeightMaleList.put(p, average_healthy_bmi-p.getBmi());
            }
            else if(p.getBmi()>average_healthy_bmi && p.getBmi()<=average_overweight_bmi){
                overWeightMaleList.put(p, p.getBmi()-average_healthy_bmi);
            }
            else {
                ObseseMaleList.put(p, p.getBmi()-average_healthy_bmi);
            }
        }
    }
    
    public void runRecommender(){
        for(Person p:underWeightFemaleList.keySet()){
            float Wg_to_gain= (float)((p.getHeight()*p.getHeight())/(3.28*3.28))*(average_healthy_bmi-p.getBmi());
            Recommendations r=recommendationsList.addrecommendation();
            r.setPerson(p);
            r.setRecommendationDescription("You need to gain "+Wg_to_gain+ "kg to have a healthy BMI. Recommended to consume "+ Wg_to_gain/30+ " extra calories for 30 days");
            p.getMyRecommendationsList().add(r);
        }
        
        for(Person p:overWeightFemaleList.keySet()){
            float Wg_to_lose= (float)((p.getHeight()*p.getHeight())/(3.28*3.28))*(p.getBmi()-average_healthy_bmi);
            float Wg_to_lose_per_day=Wg_to_lose/30;
            String action;
            if(Wg_to_lose_per_day<0.2){ action="Walk";}
            else if(Wg_to_lose_per_day>=0.2 && Wg_to_lose_per_day<0.5){action="Run";}
            else {action="Gym";}
            Recommendations r=recommendationsList.addrecommendation();
            r.setPerson(p);
            r.setRecommendationDescription("You need to lose "+Wg_to_lose+ "kg to have a healthy BMI. Recommended to burn out "+ Wg_to_lose/30+ " extra calories for 30 days. Need to "+ action+" for one hour for 30 days");
            p.getMyRecommendationsList().add(r);
        }
        
        for(Person p:ObseseFemaleList.keySet()){
            float Wg_to_lose= (float)((p.getHeight()*p.getHeight())/(3.28*3.28))*(p.getBmi()-average_healthy_bmi);
            float Wg_to_lose_per_day=Wg_to_lose/30;
            String action;
            if(Wg_to_lose_per_day<0.2){ action="Walk";}
            else if(Wg_to_lose_per_day>=0.2 && Wg_to_lose_per_day<0.5){action="Run";}
            else {action="Gym";}
            Recommendations r=recommendationsList.addrecommendation();
            r.setPerson(p);
            r.setRecommendationDescription("You need to lose "+Wg_to_lose+ "kg to have a healthy BMI. Recommended to burn out "+ Wg_to_lose/30+ " extra calories for 30 days. Need to "+ action+" for one hour for 30 days");
            p.getMyRecommendationsList().add(r);
        }
        
        
        for(Person p:underWeightMaleList.keySet()){
            float Wg_to_gain= (float)((p.getHeight()*p.getHeight())/(3.28*3.28))*(average_healthy_bmi-p.getBmi());
            float wg_to_gain_per_day=Wg_to_gain/30;
            
            Recommendations r=recommendationsList.addrecommendation();
            r.setPerson(p);
            r.setRecommendationDescription("You need to gain "+Wg_to_gain+ "kg to have a healthy BMI. Recommended to consume "+ Wg_to_gain/30+ " extra calories for 30 days");
            p.getMyRecommendationsList().add(r);
        }
        
        for(Person p:overWeightMaleList.keySet()){
            float Wg_to_lose= (float)((p.getHeight()*p.getHeight())/(3.28*3.28))*(p.getBmi()-average_healthy_bmi);
            float Wg_to_lose_per_day=Wg_to_lose/30;
            String action;
            if(Wg_to_lose_per_day<0.2){ action="Walk";}
            else if(Wg_to_lose_per_day>=0.2 && Wg_to_lose_per_day<0.5){action="Run";}
            else {action="Gym";}
            Recommendations r=recommendationsList.addrecommendation();
            r.setPerson(p);
            r.setRecommendationDescription("You need to lose "+Wg_to_lose+ "kg to have a healthy BMI. Recommended to burn out "+ Wg_to_lose/30+ " extra calories for 30 days. Need to "+ action+" for one hour for 30 days");
            p.getMyRecommendationsList().add(r);
        }
        
        for(Person p:ObseseMaleList.keySet()){
            float Wg_to_lose= (float)((p.getHeight()*p.getHeight())/(3.28*3.28))*(p.getBmi()-average_healthy_bmi);
            float Wg_to_lose_per_day=Wg_to_lose/30;
            String action;
            if(Wg_to_lose_per_day<0.2){ action="Walk";}
            else if(Wg_to_lose_per_day>=0.2 && Wg_to_lose_per_day<0.5){action="Run";}
            else {action="Gym";}
            Recommendations r=recommendationsList.addrecommendation();
            r.setPerson(p);
            r.setRecommendationDescription("You need to lose "+Wg_to_lose+ "kg to have a healthy BMI. Recommended to burn out "+ Wg_to_lose/30+ " extra calories for 30 days. Need to "+ action+" for one hour for 30 days");
            p.getMyRecommendationsList().add(r);
        }
    }
    
    
    
    
    
      
}
