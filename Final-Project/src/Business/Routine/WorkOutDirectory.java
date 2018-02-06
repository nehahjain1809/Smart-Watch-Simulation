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
public class WorkOutDirectory {
 
    private ArrayList<WorkOut> workOutList;    
   
   
    public WorkOutDirectory(){
        workOutList=new ArrayList<WorkOut>();
    }

    public ArrayList<WorkOut> getWorkOutList() {
        return workOutList;
    }

    public void setWorkOutList(ArrayList<WorkOut> workOutList) {
        this.workOutList = workOutList;
    }

   
 
        public WorkOut addWorkOut()
    {
        WorkOut w = new WorkOut();
        workOutList.add(w);
        return w;
    }
    
     public ArrayList<WorkOut> findWorkOutyByPerson(Person p){
         ArrayList<WorkOut> wList=new ArrayList<WorkOut>();
         for(WorkOut w: workOutList){
             if(w.getP().equals(p)){
                  workOutList.add(w);
             }
             return workOutList;
         }
         return null;
     }
}
