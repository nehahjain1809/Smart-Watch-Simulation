/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkPlace;

import Business.Person.Person;
import java.util.ArrayList;

/**
 *
 * @author nehah
 */
public class SupervisorDirectory {
    
     private ArrayList<Supervisor> supervisorList;
    
    public SupervisorDirectory(){
        supervisorList=new ArrayList<Supervisor>();
    }

    public ArrayList<Supervisor> getSupervisorList() {
        return supervisorList;
    }

    public void setSupervisorList(ArrayList<Supervisor> supervisorList) {
        this.supervisorList = supervisorList;
    }
    
    public Supervisor findPSupervisorByUserName(String username){
        for(Supervisor s: supervisorList){
            if(s.getUseraccount().getUsername().equals(username)){
              
            return s;
            }
        }
        return null;
    }
    
    public Supervisor addSupervisor()
    {
        Supervisor p = new Supervisor();
        supervisorList.add(p);
        return p;
    }
    
    
    
}
