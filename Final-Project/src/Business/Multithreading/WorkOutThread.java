/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Multithreading;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nehah
 */
public class WorkOutThread  extends Thread{
    String action;
    private static float i=0;
    private static float incr=(float) 0.5;
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    Date date;

    public WorkOutThread(String action) {
       this.action=action;
       date=new Date();
    }
    public void run() {
       
        String strDate = sdf.format(date);
//        float i=0;
//        float incr=(float) 0.5;
        while(i<=9){
         i=(float)i+incr;
         calendar.add(Calendar.SECOND, 15);  
         date=calendar.getTime();
         strDate = sdf.format(date);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(WorkOutThread.class.getName()).log(Level.SEVERE, null, ex);
            }
         if(i==3.0 && action.equals("Work")){
             JOptionPane.showMessageDialog(null,"You are working from last 3 hours. Recommended to take a Break");
         }
         if(i==9.0 && action.equals("Work")){
             JOptionPane.showMessageDialog(null,"You are working from last 9 hours. Looks like you are done for the day :)");
         }
            System.out.println("At " + strDate+' '+ action);
           
        }
        
          
    }
    
    
}
