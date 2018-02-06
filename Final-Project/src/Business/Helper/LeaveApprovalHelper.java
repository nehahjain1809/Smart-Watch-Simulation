/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Helper;

import Business.Person.Person;
import Business.WorkPlace.LeaveRequest;
import Business.WorkPlace.Supervisor;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author nehah
 */
public class LeaveApprovalHelper {
    Supervisor s;
    Person p;
    LeaveRequest l;
    Date startDate;
    Date endDate;
    int leaveBal;
    int buffer=2;
    public LeaveApprovalHelper(Supervisor s,Person p, LeaveRequest l){
       this.p=p;
       this.s=s;
       this.l=l;
       this. startDate=l.getVaccStartDate();
       this.endDate=l.getVaccEndDate();
       this.leaveBal=p.getMyVaccationBalance();
    }
    
    public String getApprovalHelp(){
        int vacBal=0;
        String help="";
        for(Person per:s.getPersonList()){
            if(!p.getPersonName().equals(per.getPersonName())){
                for(LeaveRequest lr:per.getLeaveRequestTracker()){
                   if(lr.getStatus().equals("Pending") 
                           && 
                     (lr.getVaccStartDate().compareTo(startDate)==0)
                           &&
                      ((per.getMyVaccationBalance()>=leaveBal)||(per.getWorkProgress()>p.getWorkProgress()))
                      ) {
                        help= "The system suggests you to approve the leave request of "+ per.getPersonName()+" because of more leave balance or more work progress than "+p.getPersonName()+ ".";
                        break;
                    }
            }
        }
            
    }
        return help;
        
}
}
 
