/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkPlace;

import Business.Person.Person;
import java.util.ArrayList;

/**
 *
 * @author nehah
 */
public class LeaveRequestHistory {
    
    
    private ArrayList<LeaveRequest> leaveRequestList;    
   
   
    public LeaveRequestHistory(){
        leaveRequestList=new ArrayList<LeaveRequest>();
    }

    

    
    public LeaveRequest addLeavRequest()
    {
        LeaveRequest l = new LeaveRequest();
        leaveRequestList.add(l);
        return l;
    }
    
     public ArrayList<LeaveRequest> findbyPerson(Person p){
         ArrayList<LeaveRequest> leaveRequests=new ArrayList<LeaveRequest>();
         for(LeaveRequest l: leaveRequestList){
             if(l.getP().equals(p)){
                  leaveRequests.add(l);
             }
             return leaveRequests;
         }
         return null;
     }
     
     
        public ArrayList<LeaveRequest> findbySupervisor(Supervisor s){
         ArrayList<LeaveRequest> leaveRequests=new ArrayList<LeaveRequest>();
         for(LeaveRequest l: leaveRequestList){
             if(l.getS().equals(s)){
                  leaveRequests.add(l);
             }
             return leaveRequests;
         }
         return null;
     }

    public LeaveRequest findbyID(int id){
         //ArrayList<LeaveRequest> leaveRequests=new ArrayList<LeaveRequest>();
         for(LeaveRequest l: leaveRequestList){
             if(l.getRequestId()==id){
              return l;
         }
        
     }
          return null;
    }
             
    public ArrayList<LeaveRequest> getLeaveRequestList() {
        return leaveRequestList;
    }

    public void setLeaveRequestList(ArrayList<LeaveRequest> leaveRequestList) {
        this.leaveRequestList = leaveRequestList;
    }
    
   
        
        
}
