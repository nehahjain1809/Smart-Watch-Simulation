/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Recommendations;

import Business.Person.Person;
import Business.Routine.FoodConsumptionTracker;
import java.util.ArrayList;

/**
 *
 * @author nehah
 */
public class RecommendationDirectory {
     private ArrayList<Recommendations> recommendationsList;
    
    
    public RecommendationDirectory(){
        recommendationsList=new ArrayList<Recommendations>();
    }

    public ArrayList<Recommendations> getRecommendationsList() {
        return recommendationsList;
    }

    public void setRecommendationsList(ArrayList<Recommendations> recommendationsList) {
        this.recommendationsList = recommendationsList;
    }

    

   
    
    public Recommendations addrecommendation()
    {
        Recommendations r = new Recommendations();
        recommendationsList.add(r);
        return r;
    }
    
     public ArrayList<Recommendations> findRecommendationsByPerson(Person p){
         ArrayList<Recommendations> fct=new ArrayList<Recommendations>();
         for(Recommendations r: recommendationsList){
             if(r.getPerson().equals(p)){
                  fct.add(r);
             }
             return fct;
         }
         return null;
     }
}
