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
import java.util.*;
public class Appointment {
    private int appointmentId;
    private Date appointmentDate;
    private String patientName;
    private String patientUserName;
    private String DoctorName;
    private String doctorUserName;
    private Doctor doctor;
    private LabAssistant labAssistant;
    private String appointmentReason;
    private String labAssistantName;
    private String labAssistantUserName;
    private static int count;
    
    public Appointment(){
        count++;
        appointmentId=count;
        
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientUserName() {
        return patientUserName;
    }

    public void setPatientUserName(String patientUserName) {
        this.patientUserName = patientUserName;
    }

    public String getDoctorUserName() {
        return doctorUserName;
    }

    public void setDoctorUserName(String doctorUserName) {
        this.doctorUserName = doctorUserName;
    }



    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String DoctorName) {
        this.DoctorName = DoctorName;
    }



    public String getAppointmentReason() {
        return appointmentReason;
    }

    public void setAppointmentReason(String appointmentReason) {
        this.appointmentReason = appointmentReason;
    }

    public String getLabAssistantName() {
        return labAssistantName;
    }

    public void setLabAssistantName(String labAssistantName) {
        this.labAssistantName = labAssistantName;
    }

    public String getLabAssistantUserName() {
        return labAssistantUserName;
    }

    public void setLabAssistantUserName(String labAssistantUserName) {
        this.labAssistantUserName = labAssistantUserName;
    }

 

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LabAssistant getLabAssistant() {
        return labAssistant;
    }

    public void setLabAssistant(LabAssistant labAssistant) {
        this.labAssistant = labAssistant;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Appointment.count = count;
    }
    
    
    
}
