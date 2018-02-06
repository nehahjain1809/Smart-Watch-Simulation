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
public class DoctorDirectory {
   
    private ArrayList<Doctor> doctorList;
     
    public DoctorDirectory(){
        doctorList=new ArrayList<Doctor>();
        
        
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(ArrayList<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
    
    
    public Doctor addDoctor()
    {
    Doctor d = new Doctor();
    doctorList.add(d);
    return d;
    }
    
    public void deleteDoctor(Doctor d){
        doctorList.remove(d);
        
    }
    
    public Doctor searchDoctor(int doctorId){
        for(Doctor d: doctorList){
            if(d.getDoctorID()==doctorId){
                return d;
            }
       
    }
         return null;
    }
    
    public Doctor searchDoctorbyName(String doctorname){
        for(Doctor d: doctorList){
            if(d.getDoctorName().equals(doctorname)){
                return d;
            }
       
    }
         return null;
    }
    
    public Doctor searchDoctorbyUserName(String userName){
        for(Doctor d: doctorList){
            if(d.getUserAccount().getUsername().equals(userName)){
                return d;
            }
       
    }
         return null;
    }

}
