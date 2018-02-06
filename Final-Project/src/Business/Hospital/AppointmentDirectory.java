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
public class AppointmentDirectory {

    private ArrayList<Appointment> appointmentList;
     
    public AppointmentDirectory(){
        appointmentList=new ArrayList<Appointment>();
        
        
    }

    public ArrayList<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(ArrayList<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }
    
    
    public Appointment addAppointment()
    {
    Appointment a = new Appointment();
    appointmentList.add(a);
    return a;
    }
    
    public void deleteAppointment(Appointment a){
        appointmentList.remove(a);
        
    }
    
    public Appointment searchAppointment(int appointmentId){
        for(Appointment a: appointmentList){
            if(a.getAppointmentId()== appointmentId){
                return a;
            }
       
    }
         return null;
    }
    
}
