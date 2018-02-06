/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkPlace;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author nehah
 */
public class HolidayList {
    
    private ArrayList<Holiday> holidayList;    
   
   
    public HolidayList(){
        holidayList=new ArrayList<Holiday>();
    }

    public ArrayList<Holiday> getHolidayList() {
        return holidayList;
    }

    public void setHolidayList(ArrayList<Holiday> holidayList) {
        this.holidayList = holidayList;
    }

    
    public Holiday addHoliday()
    {
        Holiday w = new Holiday();
        holidayList.add(w);
        return w;
    }
    
     public ArrayList<Holiday> findHolidayByMonth(int month){
         ArrayList<Holiday> holidayList=new ArrayList<Holiday>();
         for(Holiday w: holidayList){
             if(w.getMonth()==(month)){
                  holidayList.add(w);
             }
             return holidayList;
         }
         return null;
     }
}
