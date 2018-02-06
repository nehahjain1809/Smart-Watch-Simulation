/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Hospital.Appointment;
import Business.Hospital.AppointmentDirectory;
import Business.Hospital.DoctorDirectory;
import Business.Hospital.LabAssistantDirectory;
import Business.Hospital.VitalSignsDirectoryy;
import Business.Person.PersonDirectory;
import Business.Recommendations.RecommendationDirectory;
import Business.Role.Role;
import Business.Routine.FoodConsumptionTrackerDirectory;
import Business.Routine.SleepDirectory;
import Business.Routine.WorkOutDirectory;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkPlace.LeaveRequestHistory;
import Business.WorkPlace.MyVaccationHistory;
import Business.WorkPlace.SupervisorDirectory;
import Business.WorkPlace.TeamLeaderDirectory;
import Business.WorkPlace.WorkProgressHistory;
import Business.WorkPlace.WorkScheduleHistory;
import Business.WorkQueue.WorkQueuePersonDoc;
//import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author KRISH PRAVIN JAIN
 */
public abstract class Organization {

    private String name;
    //private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private PersonDirectory personDirectory;
    private DoctorDirectory doctorDirectory;
    private LabAssistantDirectory labAssistantDirectory;
    private SupervisorDirectory supervisorDirectory;
    private TeamLeaderDirectory teamLeaderDirectory;
    private UserAccountDirectory userAccountDirectory;
    private SleepDirectory sleepDirectory;
    private FoodConsumptionTrackerDirectory foodConsumptionTrackerDirectory;
    private WorkOutDirectory workoutDirectory;
    private VitalSignsDirectoryy vitalsignDirectory;
    private MyVaccationHistory vacationHistory;
    private AppointmentDirectory appointmentDirectory;
    private RecommendationDirectory recommmendationDirectory;
    private LeaveRequestHistory leaverequestDirectory;
    private WorkScheduleHistory wksHistory;
    private WorkProgressHistory progressHistory;
     private WorkQueuePersonDoc workQueuePersonDoc;
    private int organizationID;
    private static int counter;
    
    public enum Type{
        Admin("Admin Organization"),
        Doctor("Doctor Organization"),
        Lab("Lab Organization"),
        Supervisor("Supervisor Organization")
        , TeamLeader("TeamLeader Organization"),
        Customer("Customer Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public WorkQueuePersonDoc getWorkQueuePersonDoc() {
        return workQueuePersonDoc;
    }

    public void setWorkQueuePersonDoc(WorkQueuePersonDoc workQueuePersonDoc) {
        this.workQueuePersonDoc = workQueuePersonDoc;
    }

    public Organization(String name) {
        this.name = name;
        //workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        personDirectory=new PersonDirectory();
        supervisorDirectory=new SupervisorDirectory();
        teamLeaderDirectory=new TeamLeaderDirectory();
        doctorDirectory=new DoctorDirectory();
        labAssistantDirectory=new LabAssistantDirectory();
        vacationHistory=new MyVaccationHistory();
        appointmentDirectory=new AppointmentDirectory();
        sleepDirectory=new SleepDirectory();
        foodConsumptionTrackerDirectory=new FoodConsumptionTrackerDirectory();
        workoutDirectory=new WorkOutDirectory();
        vitalsignDirectory=new VitalSignsDirectoryy();
        recommmendationDirectory=new RecommendationDirectory();
        leaverequestDirectory=new LeaveRequestHistory();
        wksHistory=new WorkScheduleHistory();
        progressHistory=new WorkProgressHistory();
         workQueuePersonDoc = new WorkQueuePersonDoc();
        
        organizationID = counter;
        ++counter;
    }

    public WorkScheduleHistory getWksHistory() {
        return wksHistory;
    }

    public void setWksHistory(WorkScheduleHistory wksHistory) {
        this.wksHistory = wksHistory;
    }

    
    public LeaveRequestHistory getLeaverequestDirectory() {
        return leaverequestDirectory;
    }

    public void setLeaverequestDirectory(LeaveRequestHistory leaverequestDirectory) {
        this.leaverequestDirectory = leaverequestDirectory;
    }

    
    public RecommendationDirectory getRecommmendationDirectory() {
        return recommmendationDirectory;
    }

    public void setRecommmendationDirectory(RecommendationDirectory recommmendationDirectory) {
        this.recommmendationDirectory = recommmendationDirectory;
    }
    
    

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public DoctorDirectory getDoctorDirectory() {
        return doctorDirectory;
    }

    public void setDoctorDirectory(DoctorDirectory doctorDirectory) {
        this.doctorDirectory = doctorDirectory;
    }

    public LabAssistantDirectory getLabAssistantDirectory() {
        return labAssistantDirectory;
    }

    public void setLabAssistantDirectory(LabAssistantDirectory labAssistantDirectory) {
        this.labAssistantDirectory = labAssistantDirectory;
    }

    public SupervisorDirectory getSupervisorDirectory() {
        return supervisorDirectory;
    }

    public void setSupervisorDirectory(SupervisorDirectory supervisorDirectory) {
        this.supervisorDirectory = supervisorDirectory;
    }

    public TeamLeaderDirectory getTeamLeaderDirectory() {
        return teamLeaderDirectory;
    }

    public void setTeamLeaderDirectory(TeamLeaderDirectory teamLeaderDirectory) {
        this.teamLeaderDirectory = teamLeaderDirectory;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Organization.counter = counter;
    }

    
    public SleepDirectory getSleepDirectory() {
        return sleepDirectory;
    }

    public void setSleepDirectory(SleepDirectory sleepDirectory) {
        this.sleepDirectory = sleepDirectory;
    }

    public FoodConsumptionTrackerDirectory getFoodConsumptionTrackerDirectory() {
        return foodConsumptionTrackerDirectory;
    }

    public void setFoodConsumptionTrackerDirectory(FoodConsumptionTrackerDirectory foodConsumptionTrackerDirectory) {
        this.foodConsumptionTrackerDirectory = foodConsumptionTrackerDirectory;
    }

    public WorkOutDirectory getWorkoutDirectory() {
        return workoutDirectory;
    }

    public void setWorkoutDirectory(WorkOutDirectory workoutDirectory) {
        this.workoutDirectory = workoutDirectory;
    }

    public VitalSignsDirectoryy getVitalsignDirectory() {
        return vitalsignDirectory;
    }

    public void setVitalsignDirectory(VitalSignsDirectoryy vitalsignDirectory) {
        this.vitalsignDirectory = vitalsignDirectory;
    }

    public MyVaccationHistory getVacationHistory() {
        return vacationHistory;
    }

    public void setVacationHistory(MyVaccationHistory vacationHistory) {
        this.vacationHistory = vacationHistory;
    }

    public AppointmentDirectory getAppointmentDirectory() {
        return appointmentDirectory;
    }

    public WorkProgressHistory getProgressHistory() {
        return progressHistory;
    }

    public void setProgressHistory(WorkProgressHistory progressHistory) {
        this.progressHistory = progressHistory;
    }
    
    

//    public WorkQueue getWorkQueue() {
//        return workQueue;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setWorkQueue(WorkQueue workQueue) {
//        this.workQueue = workQueue;
//    }
    public void setAppointmentDirectory(AppointmentDirectory appointmentDirectory) {
        this.appointmentDirectory = appointmentDirectory;
    }

    @Override
    public String toString() {
        return name;
    }
    
}