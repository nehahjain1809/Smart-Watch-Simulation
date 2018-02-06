/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Helper;

import Business.Person.Person;
import Business.Recommendations.RecommendationDirectory;
import Business.Recommendations.Recommendations;
import Business.WorkPlace.WorkProgress;
import Business.WorkPlace.WorkProgressHistory;
import Business.WorkPlace.WorkSchedule;
import Business.WorkPlace.WorkScheduleHistory;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author nehah
 */
public class ScheduleRecommender {
    
    Person p;
    WorkProgress wp;
    ArrayList<WorkProgress> progressList;
    WorkSchedule wks;
    int progresthreshold=80;
    ArrayList<WorkSchedule> workHistory;
    Map<Date, WorkProgress> workprogressMapforLastWeek;
    Map<Date,WorkSchedule> workscheduleMapforLastWeek;
    Map<Date, WorkProgress> workprogressMapforCurrentWeek;
    Map<Date,WorkSchedule> workscheduleMapforCurrentWeek;
    Calendar cal = Calendar.getInstance();
    //ArrayList<String>  recommendationlist;
    RecommendationDirectory recommendationsList;
    
    public ScheduleRecommender(Person p, RecommendationDirectory recommendationDirectory){
     this.p=p;
     this.workHistory=p.getMyworkSchedules();
     this.progressList=p.getMyWorkProgress();
    recommendationsList=recommendationDirectory;
    workprogressMapforLastWeek=new HashMap<Date, WorkProgress>();
    workscheduleMapforLastWeek=new HashMap<Date,WorkSchedule>() ;
    workprogressMapforCurrentWeek=new HashMap<Date, WorkProgress>();
    workscheduleMapforCurrentWeek=new HashMap<Date,WorkSchedule>();
    }
    
    public String getRecommendations(Person p){
    Date today=cal.getTime();
    int getweekday=cal.getTime().getDay();
    cal.add(Calendar.DAY_OF_MONTH, -7-getweekday+1);
    Date startDateOfLastWeek=cal.getTime();
    cal.add(Calendar.DAY_OF_MONTH, +7-1);
    Date lastDateofLastWeek=cal.getTime();
    for(WorkSchedule w:p.getMyworkSchedules()){
         if(w.getDate().compareTo(startDateOfLastWeek)>=0 && w.getDate().compareTo(lastDateofLastWeek)<=0 ){
             workscheduleMapforLastWeek.put(w.getDate(),w);
          }
     }
     
    for(WorkProgress wp:p.getMyWorkProgress()){
         if(wp.getDate().compareTo(startDateOfLastWeek)>0 && wp.getDate().before(lastDateofLastWeek) ){
             workprogressMapforLastWeek.put(wp.getDate(),wp);
            
         }
     }
     
    for(WorkSchedule w:p.getMyworkSchedules()){
         if(w.getDate().compareTo(lastDateofLastWeek)>0 && w.getDate().compareTo(today)<=0 ){
             workscheduleMapforCurrentWeek.put(w.getDate(),w);
             
         }
     }
     
     for(WorkProgress wp:p.getMyWorkProgress()){
         if(wp.getDate().compareTo(lastDateofLastWeek)>=0 && wp.getDate().compareTo(today)<=0 ){
             workprogressMapforCurrentWeek.put(wp.getDate(),wp);
             
         }
     }
     
     float averageWorkHoursLastWeek=0;
     float averageWorkHoursCurrentWeek=0;
     
     float averageProgressPerDayLastWeek=0;
     float averageProgressPerDayCurrentWeek=0;
     
     float totalWorkHours=0;
     float totalBreakHours=0;
     float totalWorkHoursforCurrent=0;
     float totalBreakHoursforCurrent=0;
     
     float totalprogress=0;
     float totalprogresscurrentWeek=0;
     
     for(WorkSchedule f:workscheduleMapforLastWeek.values()){
          totalWorkHours=totalWorkHours+f.getTotalWorkTime();
          totalBreakHours=totalBreakHours+f.getTotalBreakTime();
     }
     //averageWorkHoursLastWeek=(totalWorkHours+totalBreakHours)/(5);
     
     //float averageWorkHrs=totalWorkHours/(5);
     //float averageBreakHrs=totalBreakHours/(5);
     
     for(WorkProgress pr:workprogressMapforLastWeek.values()){
          totalprogress=totalprogress+pr.getProgress();
        }
     //averageProgressPerDayLastWeek=(totalprogress)/(5);
     
     for(WorkSchedule f:workscheduleMapforCurrentWeek.values()){
          totalWorkHoursforCurrent=totalWorkHoursforCurrent+f.getTotalWorkTime();
          totalBreakHoursforCurrent=totalBreakHoursforCurrent+f.getTotalBreakTime();
     }
     //averageWorkHoursCurrentWeek=(totalWorkHoursforCurrent+totalBreakHoursforCurrent)/(getweekday);
     
     for(WorkProgress pr:workprogressMapforCurrentWeek.values()){
          totalprogresscurrentWeek=totalprogresscurrentWeek+pr.getProgress();
          
        }
     //averageProgressPerDayCurrentWeek=(totalprogresscurrentWeek)/(getweekday);
     
     
     System.out.println("today "+today);
     System.out.println("Weekday "+getweekday);
     System.out.println("Total Break Hours Last week "+totalBreakHours);
     System.out.println("Total Break Hours current week "+totalBreakHoursforCurrent);
     System.out.println("Total work Hours Last week "+totalWorkHours);
     System.out.println("Total Break Hours current week "+totalWorkHoursforCurrent);
     System.out.println("Total Progress last week: "+totalprogress);
     System.out.println("Total Progress current week: "+totalprogresscurrentWeek);
     System.out.println("Efficiency : "+totalprogress/totalWorkHours);
     System.out.println("Threshold: "+progresthreshold);
     
     
    float efficiency=totalprogress/totalWorkHours; 
    float totalhoursrequired=(progresthreshold-totalprogresscurrentWeek)/efficiency;
    float hoursperday=(totalhoursrequired-totalWorkHoursforCurrent)/(5-getweekday);
    
    String rec="As per your efficieny in last week, you need to work for " +hoursperday+" per day to get you 80% progress";
    Recommendations r=recommendationsList.addrecommendation();
    r.setPerson(p);
    r.setRecommendationDescription(rec);
    p.getMyRecommendationsList().add(r);
    //System.out.println(rec);
    return rec;
    }
    
}
