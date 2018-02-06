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
public class FoodConsumptionTrackerDirectory {
    private ArrayList<FoodConsumptionTracker> foodconsumptionList;
    
    
    public FoodConsumptionTrackerDirectory(){
        foodconsumptionList=new ArrayList<FoodConsumptionTracker>();
    }

    public ArrayList<FoodConsumptionTracker> getFoodconsumptionList() {
        return foodconsumptionList;
    }

    public void setFoodconsumptionList(ArrayList<FoodConsumptionTracker> foodconsumptionList) {
        this.foodconsumptionList = foodconsumptionList;
    }

   
    
     public FoodConsumptionTracker addFoodConsumptionTracker()
    {
        FoodConsumptionTracker ft = new FoodConsumptionTracker();
        foodconsumptionList.add(ft);
        return ft;
    }
    
     public ArrayList<FoodConsumptionTracker> findFooodConsumptionByPerson(Person p){
         ArrayList<FoodConsumptionTracker> fct=new ArrayList<FoodConsumptionTracker>();
         for(FoodConsumptionTracker ft: foodconsumptionList){
             if(ft.getP().equals(p)){
                  fct.add(ft);
             }
             return fct;
         }
         return null;
     }
     
    
}
