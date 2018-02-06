/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

/**
 *
 * @author nehah
 */
import Business.Person.Person;
import java.util.*;
public class VitalSignsDirectoryy {

    private Date date;
    private ArrayList<VitalSigns> vitalSignsList;
    
    
       public VitalSignsDirectoryy(){
           vitalSignsList=new ArrayList<VitalSigns>();
       }     
         
    public VitalSigns addVitalSigns()
    {
    VitalSigns vs = new VitalSigns();
    vitalSignsList.add(vs);
    return vs;
    }
    
    public void deleteVitalSigns(VitalSigns vs){
        vitalSignsList.remove(vs);
        
    }
     public ArrayList<VitalSigns> searchVitalSigns(Person p){
        ArrayList<VitalSigns> vsl=new ArrayList<VitalSigns>();
        for(VitalSigns vs: vitalSignsList){
            if(vs.getP().equals(p)){
                vsl.add(vs);
            }
            return vsl ;
       
    }
         return null;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<VitalSigns> getVitalSignsList() {
        return vitalSignsList;
    }

    public void setVitalSignsList(ArrayList<VitalSigns> vitalSignsList) {
        this.vitalSignsList = vitalSignsList;
    }
     
     
}