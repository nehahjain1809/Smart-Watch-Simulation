/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.Hospital.Appointment;
import Business.Hospital.Doctor;
import Business.Hospital.HealthReport;
import Business.Hospital.VitalSigns;
import Business.Hospital.sumRecords;
import Business.Network.Network;
import Business.Recommendations.Recommendations;
import Business.Routine.FoodConsumptionTracker;
import Business.Routine.Sleep;
import Business.Routine.WorkOut;
import Business.UserAccount.UserAccount;
import Business.WorkPlace.*;
import Business.WorkPlace.MyVacation;
import Business.WorkPlace.Supervisor;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author nehah
 */
public class Person {
  
    private int personId;
    private String personName;
    private int personAge;
    private String personType;
    private Doctor myDoctor;
    private Supervisor mySupervisor;
    private UserAccount account;
    private String gender;
    private String status;
    private float height;
    private float weight;
    private float bmi;
    private float calories;
    private float caloriesburnThreshold;
    private float caloriesConsumptionThreshold;
    private int workProgress;
    private String emailId;
    //private String pwd;
    private ArrayList<Appointment> appointmentList;
    private ArrayList<VitalSigns> vitalSignHistory;
    private ArrayList<HealthReport> healthReportHistory;
    private ArrayList<FoodConsumptionTracker>foodConsumptionTrackerList;
    private ArrayList<Sleep> sleepTracker;
    private ArrayList<WorkOut> workOutList;
    private ArrayList<MyVacation> leaveTracker;
    private ArrayList<LeaveRequest> leaveRequestTracker;
    private ArrayList<Recommendations> myRecommendationsList;
    private ArrayList<WorkProgress> myWorkProgress;
    private ArrayList<WorkSchedule> myworkSchedules;
    private static int count;
    private int myVaccationBalance;
    private int totalWorkHoursThreshold;
    private int atStretchWorkThreshold;
    private int teaBreakThreshold;
    private int lunchBreakThreshold;
    private ImageIcon profileImge;
    private TeamLeader myTeamLeader; 
    private HashMap<Date, HashMap<Date, Integer>> capturedVitalSigns;
    private sumRecords sumRecords;
    private Network location;
    private boolean statsPermission;
    
    
    public Person(){
        count++;
        personId=count;
        appointmentList=new ArrayList<Appointment>();
        vitalSignHistory=new ArrayList<VitalSigns>(); 
        healthReportHistory=new ArrayList<HealthReport>();
        foodConsumptionTrackerList=new ArrayList<FoodConsumptionTracker>();
        sleepTracker=new ArrayList<Sleep>();
        workOutList=new ArrayList<WorkOut>();
        leaveTracker=new ArrayList<MyVacation>();
        myRecommendationsList=new ArrayList<Recommendations>();
        leaveRequestTracker=new ArrayList<LeaveRequest>();
        myWorkProgress=new ArrayList<WorkProgress>();
        myworkSchedules=new ArrayList<WorkSchedule>();
        capturedVitalSigns = new HashMap<>();
        sumRecords = new sumRecords();
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    
    public boolean isStatsPermission() {
        return statsPermission;
    }

    public void setStatsPermission(boolean statsPermission) {
        this.statsPermission = statsPermission;
    }

    
    public TeamLeader getMyTeamLeader() {
        return myTeamLeader;
    }

    public void setMyTeamLeader(TeamLeader myTeamLeader) {
        this.myTeamLeader = myTeamLeader;
    }

    
    public ImageIcon getProfileImge() {
        return profileImge;
    }

    public void setProfileImge(ImageIcon profileImge) {
        this.profileImge = profileImge;
    }

    public Network getLocation() {
        return location;
    }

    public void setLocation(Network location) {
        this.location = location;
    }

    
    
    public ArrayList<WorkSchedule> getMyworkSchedules() {
        return myworkSchedules;
    }

    public void setMyworkSchedules(ArrayList<WorkSchedule> myworkSchedules) {
        this.myworkSchedules = myworkSchedules;
    }

    public int getMyVaccationBalance() {
        return myVaccationBalance;
    }

    public void setMyVaccationBalance(int myVaccationBalance) {
        this.myVaccationBalance = myVaccationBalance;
    }

    public HashMap<Date, HashMap<Date, Integer>> getCapturedVitalSigns() {
        return capturedVitalSigns;
    }

    public void setCapturedVitalSigns(HashMap<Date, HashMap<Date, Integer>> capturedVitalSigns) {
        this.capturedVitalSigns = capturedVitalSigns;
    }

    public sumRecords getSumRecords() {
        return sumRecords;
    }

    public void setSumRecords(sumRecords sumRecords) {
        this.sumRecords = sumRecords;
    }
    
    
    public int getPersonId() {
        return personId;
        
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public Doctor getMyDoctor() {
        return myDoctor;
    }

    public void setMyDoctor(Doctor myDoctor) {
        this.myDoctor = myDoctor;
    }

    public Supervisor getMySupervisor() {
        return mySupervisor;
    }

    public void setMySupervisor(Supervisor mySupervisor) {
        this.mySupervisor = mySupervisor;
    }

    public UserAccount getAccount() {
        return account;
    }

    public void setAccount(UserAccount account) {
        this.account = account;
    }

    public ArrayList<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(ArrayList<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public ArrayList<VitalSigns> getVitalSignHistory() {
        return vitalSignHistory;
    }

    public void setVitalSignHistory(ArrayList<VitalSigns> vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }

    public ArrayList<HealthReport> getHealthReportHistory() {
        return healthReportHistory;
    }

    public void setHealthReportHistory(ArrayList<HealthReport> healthReportHistory) {
        this.healthReportHistory = healthReportHistory;
    }

    public ArrayList<FoodConsumptionTracker> getFoodConsumptionTrackerList() {
        return foodConsumptionTrackerList;
    }

    public void setFoodConsumptionTrackerList(ArrayList<FoodConsumptionTracker> foodConsumptionTrackerList) {
        this.foodConsumptionTrackerList = foodConsumptionTrackerList;
    }

    public ArrayList<Sleep> getSleepTracker() {
        return sleepTracker;
    }

    public void setSleepTracker(ArrayList<Sleep> sleepTracker) {
        this.sleepTracker = sleepTracker;
    }

    public ArrayList<WorkOut> getWorkOutList() {
        return workOutList;
    }

    public void setWorkOutList(ArrayList<WorkOut> workOutList) {
        this.workOutList = workOutList;
    }

    public ArrayList<MyVacation> getLeaveTracker() {
        return leaveTracker;
    }

    public void setLeaveTracker(ArrayList<MyVacation> leaveTracker) {
        this.leaveTracker = leaveTracker;
    }

    

    public ArrayList<Recommendations> getMyRecommendationsList() {
        return myRecommendationsList;
    }

    public void setMyRecommendationsList(ArrayList<Recommendations> myRecommendationsList) {
        this.myRecommendationsList = myRecommendationsList;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getTotalWorkHoursThreshold() {
        return totalWorkHoursThreshold;
    }

    public void setTotalWorkHoursThreshold(int totalWorkHoursThreshold) {
        this.totalWorkHoursThreshold = totalWorkHoursThreshold;
    }

    public int getAtStretchWorkThreshold() {
        return atStretchWorkThreshold;
    }

    public void setAtStretchWorkThreshold(int atStretchWorkThreshold) {
        this.atStretchWorkThreshold = atStretchWorkThreshold;
    }

    public int getTeaBreakThreshold() {
        return teaBreakThreshold;
    }

    public void setTeaBreakThreshold(int teaBreakThreshold) {
        this.teaBreakThreshold = teaBreakThreshold;
    }

    public int getLunchBreakThreshold() {
        return lunchBreakThreshold;
    }

    public void setLunchBreakThreshold(int lunchBreakThreshold) {
        this.lunchBreakThreshold = lunchBreakThreshold;
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public static int getCount() {
        return count;
    }

    public float getBmi() {
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }
    
    

    public static void setCount(int count) {
        Person.count = count;
    }

    public ArrayList<LeaveRequest> getLeaveRequestTracker() {
        return leaveRequestTracker;
    }

    public void setLeaveRequestTracker(ArrayList<LeaveRequest> leaveRequestTracker) {
        this.leaveRequestTracker = leaveRequestTracker;
    }
    
    public String toString(){
        return personName;
    }

    public ArrayList<WorkProgress> getMyWorkProgress() {
        return myWorkProgress;
    }

    public void setMyWorkProgress(ArrayList<WorkProgress> myWorkProgress) {
        this.myWorkProgress = myWorkProgress;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getCaloriesburnThreshold() {
        return caloriesburnThreshold;
    }

    public void setCaloriesburnThreshold(float caloriesburnThreshold) {
        this.caloriesburnThreshold = caloriesburnThreshold;
    }

    public float getCaloriesConsumptionThreshold() {
        return caloriesConsumptionThreshold;
    }

    public void setCaloriesConsumptionThreshold(float caloriesConsumptionThreshold) {
        this.caloriesConsumptionThreshold = caloriesConsumptionThreshold;
    }

    public int getWorkProgress() {
        return workProgress;
    }

    public void setWorkProgress(int workProgress) {
        this.workProgress = workProgress;
    }
    
    public  LeaveRequest UpdateLeaveRequestbyPersonAndID(int id, Person p, String status){
    
        for(LeaveRequest lr:p.getLeaveRequestTracker()){
            if(lr.getRequestId()==id){
               lr.setStatus(status);
            }
        }
        return null;
    }
    
    
    
    
}
