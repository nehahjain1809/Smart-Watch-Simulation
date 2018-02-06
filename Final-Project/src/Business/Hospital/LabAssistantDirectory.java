/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import java.util.ArrayList;

/**
 *
 * @author nehah
 */
public class LabAssistantDirectory {
   
    private ArrayList<LabAssistant> labAssistantList;
     
    public LabAssistantDirectory(){
        labAssistantList=new ArrayList<LabAssistant>();
        
        
    }

    public ArrayList<LabAssistant> getAssistantList() {
        return labAssistantList;
    }

    public void setAssistantList(ArrayList<LabAssistant> labAssistants) {
        this.labAssistantList = labAssistantList;
    }
    
    
    public LabAssistant addLabAssistant()
    {
    LabAssistant la = new LabAssistant();
    labAssistantList.add(la);
    return la;
    }
    
    public void deleteDoctor(Doctor d){
        labAssistantList.remove(d);
        
    }
    
    public LabAssistant searchAssistant(int assistantId){
        for(LabAssistant la: labAssistantList){
            if(la.getAssistantID()==assistantId){
                return la;
            }
       
    }
         return null;
    }
    
    public LabAssistant searchAssistantbyName(String assistantname){
        for(LabAssistant l : labAssistantList){
            if(l.getAssistantName().equals(assistantname)){
                return l;
            }
       
    }
         return null;
    }
    
    public LabAssistant searchAssistantbyUserName(String userName){
        for(LabAssistant l : labAssistantList){
            if(l.getUa().getUsername().equals(userName)){
                return l;
            }
       
    }
         return null;
    }
}
