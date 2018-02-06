/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import Business.Person.Person;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author nehah
 */
public class Doctor {
    
    private int doctorID;
    private String doctorName;
    //private ArrayList<Appointment> appointmentList;
    private AppointmentDirectory appointmentList;
    private static int count;
    private UserAccount userAccount;
    private ArrayList<Person> personList;
    
    public Doctor(){
        count++;  
        doctorID=count;
        personList=new ArrayList<Person>();
        //appointmentList=new ArrayList<Appointment>();
        appointmentList = new AppointmentDirectory();
    }

    public AppointmentDirectory getAppointmentList() {
        return appointmentList;
    }

//    public void setAppointmentList(AppointmentDirectory appointmentList) {
//        this.appointmentList = appointmentList;
//    }

    
    
    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    
    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    
    

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

//    public ArrayList<Appointment> getAppointmentList() {
//        return appointmentList;
//    }
//
//    public void setAppointmentList(ArrayList<Appointment> appointmentList) {
//        this.appointmentList = appointmentList;
//    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Doctor.count = count;
    }
    
    public String toString(){
        return doctorName;
    }
    
    
    
    
}
