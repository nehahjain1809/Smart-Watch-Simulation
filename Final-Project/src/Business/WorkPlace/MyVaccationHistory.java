/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkPlace;

import Business.Person.Person;
import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nehah
 */
public class MyVaccationHistory {

     private ArrayList<MyVacation> vacationList;
    
    public MyVaccationHistory(){
        vacationList=new ArrayList<MyVacation>();
    }

    public ArrayList<MyVacation> getVacationList() {
        return vacationList;
    }

    public void setVacationList(ArrayList<MyVacation> vacationList) {
        this.vacationList = vacationList;
    }
    

    
   
    
    public MyVacation findVacationByPersonAndStarttDate(Person p, Date startDate){
        for(MyVacation v: vacationList){
            if(v.getP().equals(p)&& v.getStartDate().compareTo(startDate)==0){
              
            return v;
            }
        }
        return null;
    }
    
    public MyVacation addMyVacation()
    {
        MyVacation myVacc = new MyVacation();
        vacationList.add(myVacc);
        return myVacc;
    }
    
    public Map<Integer, Integer> calculateVacationPerMonth(Person p){
     Map<Integer, Integer> leaveMap=new HashMap<Integer, Integer>();
     Calendar c = Calendar.getInstance();

     for(MyVacation myVac:p.getLeaveTracker()){
         int daysCount=0;
         Date startdate=myVac.getStartDate();
         Date endDate=myVac.getEndDate();
         Date date=startdate;
         while(date.compareTo(endDate)<=0){
             if (!leaveMap.containsKey(date.getMonth()+1)) {
                leaveMap.put(date.getMonth()+1, daysCount+1);
                
             }
             else{
               for (Map.Entry<Integer, Integer> entry : leaveMap.entrySet()) {
                 if(entry.getKey()==(date.getMonth()+1)){  
                 entry.setValue(entry.getValue()+1);
                 }
}
             }
             c.setTime(date);
             c.add(Calendar.DATE, 1);
             date=c.getTime();
            
         }
     }
    return leaveMap;
}
    
}
