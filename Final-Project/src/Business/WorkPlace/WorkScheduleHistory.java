/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkPlace;

import Business.Person.Person;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author nehah
 */
public class WorkScheduleHistory {
    
     private ArrayList<WorkSchedule> workScheduleList;
    
    public WorkScheduleHistory(){
        workScheduleList=new ArrayList<WorkSchedule>();
    }

    
    
    public ArrayList<WorkSchedule> findScheduleByPerson(Person p){
        ArrayList<WorkSchedule> wpList=new ArrayList<WorkSchedule>();
        for(WorkSchedule s: workScheduleList){
            if(s.getP().equals(p)){
              wpList.add(s);
            
            }
            return wpList;
        }
        return null;
    }
    
              
        public ArrayList<WorkSchedule> findWorkSchedulebyDateAndPerson(Date todaysDate,Person p){
           ArrayList<WorkSchedule> wpList=new ArrayList<WorkSchedule>();
           for(WorkSchedule s: workScheduleList){
            if((s.getP().equals(p)) && (s.getDate().compareTo(todaysDate)==0)){
             wpList.add(s);  
                        }
            return wpList;
           }
         return null; 
        }
    
        
    public WorkSchedule addWorkSchedule()
    {
        WorkSchedule p = new WorkSchedule();
        workScheduleList.add(p);
        return p;
    }
    
//    public int calculateTotalWorkHours (Person p,Date date){
//        int totalHours=0;
//         for(WorkSchedule s: workScheduleList){
//             if(s.getP().equals(p)&& (s.getTodaysDate().compareTo(date)==0) && s.getAction().equals("Work")){
//              totalHours   =totalHours+s.getEndtime().compareTo(s.getStarttime());
//             }
//         }
//        return totalHours;
//    }
//    
//        public int calculateTotalBreakHours (Person p,Date date){
//        int totalBreakHours=0;
//         for(WorkSchedule s: workScheduleList){
//             if(s.getP().equals(p)&& (s.getTodaysDate().compareTo(date)==0) && s.getAction().equals("Break")){
//              totalBreakHours   =totalBreakHours+s.getEndtime().compareTo(s.getStarttime());
//             }
//         }
//        return totalBreakHours;
//    }
    
}
