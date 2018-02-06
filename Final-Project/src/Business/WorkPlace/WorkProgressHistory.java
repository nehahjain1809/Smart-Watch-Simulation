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
public class WorkProgressHistory {
    
     private ArrayList<WorkProgress> progressList;
    
    public WorkProgressHistory(){
        progressList=new ArrayList<WorkProgress>();
    }

    
    
    public ArrayList<WorkProgress> findProgressByPerson(Person p){
        ArrayList<WorkProgress> wpList=new ArrayList<WorkProgress>();
        for(WorkProgress s: progressList){
            if(s.getP().equals(p)){
              wpList.add(s);
            
            }
            return wpList;
        }
        return null;
    }
    
        public ArrayList<WorkProgress> findProgressBySupervisor(Supervisor p){
        ArrayList<WorkProgress> wpList=new ArrayList<WorkProgress>();
        for(WorkProgress s: progressList){
            if(s.getSupervisor().equals(p)){
              wpList.add(s);
            
            }
            return wpList;
        }
        return null;
    }
        
        public WorkProgress findWorkProgressbyDateAndPerson(Date date, Person p){
           for(WorkProgress s: progressList){
            if((s.getP().equals(p)) && (s.getDate().compareTo(date)==0)){
              
            return s;
            }
            
        }
        return null; 
        }
    
        
    public WorkProgress addWorkProgress()
    {
        WorkProgress p = new WorkProgress();
        progressList.add(p);
        return p;
    }
    
    
}
