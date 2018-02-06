/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Person;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Hospital.AppointmentDirectory;
import Business.Hospital.Doctor;
import Business.Hospital.DoctorDirectory;
import Business.Hospital.VitalSignsDirectoryy;
import Business.Network.Network;
import Business.Organization.CustomerOrganization;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Recommendations.RecommendationDirectory;
import Business.Routine.FoodConsumptionTrackerDirectory;
import Business.Routine.SleepDirectory;
import Business.Routine.WorkOutDirectory;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkPlace.HolidayList;
import Business.WorkPlace.MyVaccationHistory;
import Business.WorkPlace.SupervisorDirectory;
import Business.WorkPlace.*;
import java.awt.CardLayout;
import java.awt.Menu;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nehah
 */
public class MyWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MyWorkAreaJPanel
     */
//    public MyWorkAreaJPanel() {
     //   initComponents();
    //}

        JPanel userProcessContainer;
        Person p;
        DoctorDirectory	doctorList;
        UserAccountDirectory	uad;
        PersonDirectory	personList;
        SupervisorDirectory	supervisorList;
        MyVaccationHistory	leaveList;
        HolidayList	holidayList;
       // VaccationHelper1	vaccationHelper;
        AppointmentDirectory	appointmentDirectory;
        SleepDirectory	sleepDirectory;
        FoodConsumptionTrackerDirectory	foodTracker;
        VitalSignsDirectoryy	vitalSignList;
         LeaveRequestHistory leaveRequestDirectory;
         RecommendationDirectory recommmendationDirectory;
         WorkOutDirectory workoutDirectory;
 
     UserAccount userAccount;
     CustomerOrganization customerOrganization;
     Enterprise inEnterprise;
     EcoSystem system;
     Network n;
     PersonDirectory personDirectory;
    public MyWorkAreaJPanel(JPanel userProcessContainer, UserAccount userAccount, CustomerOrganization customerOrganization, Enterprise inEnterprise, EcoSystem system, Network n) {
       initComponents();
        this.userProcessContainer=userProcessContainer;
        this.userAccount=userAccount;
        this.customerOrganization=customerOrganization;
        this.n=n;
        this.system=system;
        this.inEnterprise=inEnterprise;
        personDirectory=customerOrganization.getPersonDirectory();
        p=personDirectory.findPersonByUserName(userAccount.getUsername());
        imageLbl.setIcon(p.getProfileImge());
        loginLbl.setText(p.getAccount().getUsername());
        nameLbl.setText(p.getPersonName());
        ageLbl.setText(String.valueOf(p.getPersonAge()) );
        weightLbl.setText(String.valueOf(p.getWeight()));
        heightLbl.setText(String.valueOf(p.getHeight()));
        bmiLbl.setText(String.valueOf(p.getBmi()));
        workThresholdLbl.setText(String.valueOf(p.getTotalWorkHoursThreshold()));
        breakHoursThresholdTxt.setText(String.valueOf(p.getLunchBreakThreshold()+p.getTeaBreakThreshold()));
        progressTxt.setText(String.valueOf(p.getWorkProgress()));
        statsPersmission.setText(String.valueOf(p.isStatsPermission()));
        
        //String loc=p.getLocation().toString();
        Network loc = p.getLocation();
        if(loc != null){
        locationTxt.setText(p.getLocation().toString());
        }
//        if(!loc.equals(null)){
//        locationTxt.setText(p.getLocation().toString());
//        }
        else{
            locationTxt.setText("");
        }
        TeamLeader t=p.getMyTeamLeader();
        if(t!=null){
        teamLeaderLbl.setText(p.getMyTeamLeader().getTeamleaderName());
        }
        else{
            teamLeaderLbl.setText(" ");
        }
        Supervisor s=p.getMySupervisor();
        if(s!=null){
        supervisorLbl.setText(p.getMySupervisor().getSupervisorName());
        }
        else{
            supervisorLbl.setText(" ");}
        Doctor d=p.getMyDoctor();
        if(d!=null){
         doctorLbl.setText(p.getMyDoctor().getDoctorName());
        }
        else{
            doctorLbl.setText(" ");}
       
        this.appointmentDirectory=customerOrganization.getAppointmentDirectory();
        this.sleepDirectory=customerOrganization.getSleepDirectory();
        this.foodTracker=customerOrganization.getFoodConsumptionTrackerDirectory();
        this.vitalSignList=customerOrganization.getVitalsignDirectory();
        //this.leaveRequestDirectory=leaveRequestDirectory;
        //
        this.workoutDirectory=customerOrganization.getWorkoutDirectory();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnGoToHealthTracker = new javax.swing.JButton();
        btnGoToRoutineTracker = new javax.swing.JButton();
        btnGoToWorkPlaceTracker = new javax.swing.JButton();
        imageLbl = new javax.swing.JLabel();
        btnMydetail = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        loginLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ageLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        weightLbl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        heightLbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bmiLbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        supervisorLbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        doctorLbl = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        workThresholdLbl = new javax.swing.JTextField();
        breakHoursThresholdTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        teamLeaderLbl = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        progressTxt = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        locationTxt = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        statsPersmission = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("My Personal Tracker");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        btnGoToHealthTracker.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGoToHealthTracker.setText("View My Health Tracker>>");
        btnGoToHealthTracker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToHealthTrackerActionPerformed(evt);
            }
        });
        add(btnGoToHealthTracker, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 660, 310, -1));

        btnGoToRoutineTracker.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGoToRoutineTracker.setText("Go To My Routine Tracker>>");
        btnGoToRoutineTracker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToRoutineTrackerActionPerformed(evt);
            }
        });
        add(btnGoToRoutineTracker, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 250, -1));

        btnGoToWorkPlaceTracker.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGoToWorkPlaceTracker.setText("View My Work Tracker>>");
        btnGoToWorkPlaceTracker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToWorkPlaceTrackerActionPerformed(evt);
            }
        });
        add(btnGoToWorkPlaceTracker, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 660, 300, -1));

        imageLbl.setBackground(new java.awt.Color(255, 255, 255));
        add(imageLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 100, 100));

        btnMydetail.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMydetail.setText("Update my Profile>>");
        btnMydetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMydetailActionPerformed(evt);
            }
        });
        add(btnMydetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 230, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        loginLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        loginLbl.setText("jLabel9");
        jPanel1.add(loginLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 180, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        nameLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nameLbl.setText("jLabel9");
        jPanel1.add(nameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 180, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Age:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        ageLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ageLbl.setText("jLabel9");
        jPanel1.add(ageLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 140, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Weight:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        weightLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        weightLbl.setText("jLabel9");
        jPanel1.add(weightLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 80, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Height:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        heightLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        heightLbl.setText("jLabel9");
        jPanel1.add(heightLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 120, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("bmi");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 60, -1));

        bmiLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bmiLbl.setText("jLabel10");
        jPanel1.add(bmiLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Supervisor");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        supervisorLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        supervisorLbl.setText("jLabel9");
        jPanel1.add(supervisorLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 100, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Doctor");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        doctorLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        doctorLbl.setText("jLabel9");
        jPanel1.add(doctorLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 150, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Work hours threshold");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Break Threshold");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, -1));
        jPanel1.add(workThresholdLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 50, -1));
        jPanel1.add(breakHoursThresholdTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 50, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Team Leader");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        teamLeaderLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        teamLeaderLbl.setText("jLabel13");
        jPanel1.add(teamLeaderLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("My Week Progress");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, -1, -1));

        progressTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        progressTxt.setText("jLabel14");
        jPanel1.add(progressTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("location");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        locationTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        locationTxt.setText("jLabel15");
        jPanel1.add(locationTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Statistics Permission");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, -1, -1));

        statsPersmission.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        statsPersmission.setText("jLabel16");
        jPanel1.add(statsPersmission, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 230, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 940, 280));
    }// </editor-fold>//GEN-END:initComponents

    public void setBackgroundImage() {
       
        
    }
    private void btnGoToWorkPlaceTrackerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToWorkPlaceTrackerActionPerformed
        // TODO add your handling code here:
        MyWorkPlaceJPanel1 panel= new MyWorkPlaceJPanel1(userProcessContainer,
         userAccount, 
         customerOrganization, 
         inEnterprise,
         system,
          n,
          p
                
        );
        //untManageWorkJPanel(UserProcessContainer, accountDirectory);
        userProcessContainer.add("MyWorkPlacePanel", panel);
        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
        
    }//GEN-LAST:event_btnGoToWorkPlaceTrackerActionPerformed

    private void btnGoToRoutineTrackerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToRoutineTrackerActionPerformed
        // TODO add your handling code here:

        MyRoutineJPanel1 panel= new MyRoutineJPanel1(userProcessContainer,
         userAccount, 
         customerOrganization, 
         inEnterprise,
         system,
          n,
          p);
        //untManageWorkJPanel(UserProcessContainer, accountDirectory);
        userProcessContainer.add("MyRoutineJPanel1", panel);
        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnGoToRoutineTrackerActionPerformed

    private void btnGoToHealthTrackerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToHealthTrackerActionPerformed
            // TODO add your handling code here:
           MyHealthTrackerJPanel panel= new MyHealthTrackerJPanel(userProcessContainer,
         
                                                        p,
                                                        doctorList,
                                                        uad,
                                                        personList,
                                                        supervisorList,
                                                        leaveList,
                                                        holidayList,
                                                       // vaccationHelper,
                                                        appointmentDirectory,
                                                        sleepDirectory,
                                                        foodTracker,
                                                        vitalSignList,
                                                        leaveRequestDirectory,
                    recommmendationDirectory,
                 system,
                 userAccount);
        //untManageWorkJPanel(UserProcessContainer, accountDirectory);
        userProcessContainer.add("MyHealthTrackerJPanel", panel);
        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnGoToHealthTrackerActionPerformed

    private void btnMydetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMydetailActionPerformed
        // TODO add your handling code here:
        FillMyDetailsJPanel panel= new FillMyDetailsJPanel( userProcessContainer,
                userAccount, 
                customerOrganization, 
                inEnterprise,
                system,
                n
            );
        //untManageWorkJPanel(UserProcessContainer, accountDirectory);
        userProcessContainer.add("FillMyDetailsJPanel", panel);
        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnMydetailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ageLbl;
    private javax.swing.JLabel bmiLbl;
    private javax.swing.JTextField breakHoursThresholdTxt;
    private javax.swing.JButton btnGoToHealthTracker;
    private javax.swing.JButton btnGoToRoutineTracker;
    private javax.swing.JButton btnGoToWorkPlaceTracker;
    private javax.swing.JButton btnMydetail;
    private javax.swing.JLabel doctorLbl;
    private javax.swing.JLabel heightLbl;
    private javax.swing.JLabel imageLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel locationTxt;
    private javax.swing.JLabel loginLbl;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel progressTxt;
    private javax.swing.JLabel statsPersmission;
    private javax.swing.JLabel supervisorLbl;
    private javax.swing.JLabel teamLeaderLbl;
    private javax.swing.JLabel weightLbl;
    private javax.swing.JTextField workThresholdLbl;
    // End of variables declaration//GEN-END:variables
}
