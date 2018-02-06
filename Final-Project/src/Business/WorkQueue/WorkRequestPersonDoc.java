/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Hospital.Doctor;
import Business.Person.Person;
import java.util.Date;

/**
 *
 * @author ankushdeora
 */
public class WorkRequestPersonDoc {
    private String reasonMsg;
    private int id;
    private Date reqDate;
    private Date appappointmentDate;
    private Doctor doctor;
    private Person person;
    private String forwardAssistant;
    private static int counter = 1;
    private String doctorReply;
    
    public WorkRequestPersonDoc() {
        id = counter;
        counter++;
    }

    public String getDoctorReply() {
        return doctorReply;
    }

    public void setDoctorReply(String doctorReply) {
        this.doctorReply = doctorReply;
    }

    
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getForwardAssistant() {
        return forwardAssistant;
    }

    public void setForwardAssistant(String forwardAssistant) {
        this.forwardAssistant = forwardAssistant;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        WorkRequestPersonDoc.counter = counter;
    }

    
    public int getId() {
        return id;
    }

    public String getReasonMsg() {
        return reasonMsg;
    }

    public void setReasonMsg(String reasonMsg) {
        this.reasonMsg = reasonMsg;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public Date getAppappointmentDate() {
        return appappointmentDate;
    }

    public void setAppappointmentDate(Date appappointmentDate) {
        this.appappointmentDate = appappointmentDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public String toString()
    {
        return reasonMsg;
    }
    
    
    
    
}
