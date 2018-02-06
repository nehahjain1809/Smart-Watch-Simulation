/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Supervisor;

import Business.EcoSystem;
import Business.Enterprise.CustomerEnterprise;
import Business.Enterprise.Enterprise;
import Business.Helper.LeaveApprovalHelper;
import Business.Hospital.AppointmentDirectory;
import Business.Hospital.DoctorDirectory;
import Business.Hospital.VitalSignsDirectoryy;
import Business.Network.Network;
import Business.Organization.CustomerOrganization;
import Business.Organization.Organization;
import Business.Organization.SupervisorOrganization;
import Business.Organization.TeamLeaderOrganization;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Recommendations.RecommendationDirectory;
import Business.Routine.FoodConsumptionTrackerDirectory;
import Business.Routine.SleepDirectory;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkPlace.HolidayList;
import Business.WorkPlace.LeaveRequest;
import Business.WorkPlace.LeaveRequestHistory;
import Business.WorkPlace.Message;
import Business.WorkPlace.MyVacation;
import Business.WorkPlace.MyVaccationHistory;
import Business.WorkPlace.Supervisor;
import Business.WorkPlace.SupervisorDirectory;
import Business.WorkPlace.TeamLeader;
import Business.WorkPlace.WorkProgress;
import Business.WorkPlace.WorkProgressHistory;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nehah
 */
public class SupervisorWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form SupervisorWorkArea
     */
        JPanel userProcessContainer;
        Person p;
        Supervisor s;
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
         WorkProgressHistory workProgress;
         UserAccount userAccount;
         SupervisorOrganization supervisorOrganization;
         Enterprise inEnterprise;
         EcoSystem system;
         Network n;


    public SupervisorWorkArea(JPanel userProcessContainer, 
            UserAccount userAccount, SupervisorOrganization supervisorOrganization, 
            Enterprise inEnterprise, EcoSystem system, Network n) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.userAccount=userAccount;
        this.supervisorOrganization=supervisorOrganization;
        this.n=n;
        this.system=system;
        this.inEnterprise=inEnterprise;
        this.supervisorList=supervisorOrganization.getSupervisorDirectory();
        s=supervisorList.findPSupervisorByUserName(userAccount.getUsername());
        populatePersonCombo();
        populateTeamLeaderCombo();
        populateLeaveRequests();
        populateTable();
        
    }

    public void populateTeamLeaderCombo(){
        for(Organization org:inEnterprise.getOrganizationDirectory().getOrganizationList()){
            if(org instanceof TeamLeaderOrganization){
                for(TeamLeader t:org.getTeamLeaderDirectory().getTeamleaderList()){
                teamLeadCombo.addItem(t);
                
                }
            }
        }
    }
    public void populatePersonCombo(){
        for(Person per:s.getPersonList()){
            personCombo.addItem(per);
            personCombo1.addItem(per);
        }
    }
    public void populateLeaveRequests(){
        DefaultTableModel dtm =(DefaultTableModel)tblLeaveRequests1.getModel();
        dtm.setRowCount(0);
        for(Person p: s.getPersonList()){
        for (LeaveRequest lr:p.getLeaveRequestTracker())
        if(lr.getStatus().equals("Pending")){
          
        {
            Object row[]= new Object [6];
            row[0]=lr.getRequestId();
            row[1]=lr.getP();
            row[2]=lr.getVaccStartDate();
            row[3]=lr.getVaccEndDate();
            row[4]=lr.getP().getMySupervisor();
            row[5]=lr.getStatus();
            dtm.addRow(row);
        } 
        }
        }
    }
    public void populateTable(){
        DefaultTableModel dtm =(DefaultTableModel)jTable1.getModel();
        dtm.setRowCount(0);
        //for(Person p:s.getPersonList()){
        for (WorkProgress wp:s.getProgressReport())
        //for(int i=0;i<(getBestStartDates.size());i++)    
        {
            Object row[]= new Object [4];
            row[0]=wp.getP().toString();
            row[1]=wp.getProgress();
            row[2]=wp.getSupervisor().getSupervisorName();
            row[3]=wp.getDate();
            dtm.addRow(row);
        }
      //  }
    }
    
       public void sendEmail(Person p) throws MessagingException {
        String from = supervisorOrganization.getSupervisorDirectory().findPSupervisorByUserName(userAccount.getUsername()).getEmailId().toString();
        String password = supervisorOrganization.getSupervisorDirectory().findPSupervisorByUserName(userAccount.getUsername()).getPwd();
        String[] to =     {p.getEmailId()};
        String subject = "Lead Approval Email"+" "+p.getPersonName();
        String body = "Hi "+p.getPersonName()+","+ "/n This email is to inform you that your leave request has been approved. "
                + "Please let us know in case of any changes required. /n Thanking you, /n"+userAccount.getUsername();

        sendFromGMail(from, password, to, subject, body);
    }
    
    private void sendFromGMail(String from, String pass, String[] to, String subject, String body) throws MessagingException, MessagingException {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

       Session session;
        session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, pass);
            }
        });
       MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(javax.mail.Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblLeaveRequests = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLeaveRequests1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        statusCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        personCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        teamLeadCombo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        personCombo1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        totalWorkThresholdTxt = new javax.swing.JTextField();
        teaBrekThreshold = new javax.swing.JTextField();
        luncBreakThreshold = new javax.swing.JTextField();
        workatStretchThreoldTxt = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();

        tblLeaveRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person", "StartDate", "End Date", "Supervisor", "Status"
            }
        ));
        jScrollPane2.setViewportView(tblLeaveRequests);

        setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Supervisor Work Area");

        tblLeaveRequests1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request id", "Person", "StartDate", "End Date", "Supervisor", "Status"
            }
        ));
        jScrollPane3.setViewportView(tblLeaveRequests1);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        statusCombo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        statusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Approve", "Reject" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Request for Progress Reports");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Request for Progress Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("View Progress Report");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person", "Progress", "Supervisor", "Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Person Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Leave Requests");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Team Lead Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Set Work Thresholds for My Employees");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Person Name");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total work Threshold");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tea Break threshold");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Lunch Break Threshold");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Work at Stretch Threshold");

        teaBrekThreshold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teaBrekThresholdActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(personCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(totalWorkThresholdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(workatStretchThreoldTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(luncBreakThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(18, 18, 18)
                                                .addComponent(teaBrekThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(teamLeadCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(personCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(jLabel1)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(personCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(teamLeadCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(personCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(totalWorkThresholdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(teaBrekThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(luncBreakThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(workatStretchThreoldTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String message="Requested progress report for"+personCombo.getSelectedItem().toString()+ " .";
        Message mes=new Message();
        mes.setFrom(s.getSupervisorName());
        mes.setMessage(message);
        mes.setTo(teamLeadCombo.getSelectedItem().toString());
        TeamLeader t=(TeamLeader)teamLeadCombo.getSelectedItem();
        t.getMsgList().add(mes);
        JOptionPane.showMessageDialog(null, "Requet sent to team leader.");
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow=tblLeaveRequests1.getSelectedRow();
        
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
        else {
        LeaveRequestHistory lr=supervisorOrganization.getLeaverequestDirectory();
        LeaveRequest l=lr.findbyID(Integer.parseInt(tblLeaveRequests1.getValueAt(selectedRow, 0).toString()));
        
        Person p=(Person)tblLeaveRequests1.getValueAt(selectedRow, 1);
        
        String status=statusCombo.getSelectedItem().toString();
//        l.setStatus("Approved");
        
        if(statusCombo.getSelectedItem().toString().equals("Approve")){
        
        LeaveApprovalHelper helper=new LeaveApprovalHelper(s,p,l);
        String validate=helper.getApprovalHelp();
       // if(validate.equals(null)){
        l.setStatus("Approved");
        p.UpdateLeaveRequestbyPersonAndID(l.getRequestId(), p, "Approved");
        for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
            if(e instanceof CustomerEnterprise){
                for(Organization org: e.getOrganizationDirectory().getOrganizationList()){
                    if(org instanceof CustomerOrganization){
                       LeaveRequest lrc=org.getLeaverequestDirectory().findbyID(Integer.parseInt(tblLeaveRequests1.getValueAt(selectedRow, 0).toString()));
                       lrc.setStatus("Approved");
                       MyVacation myVacRequest=org.getVacationHistory().addMyVacation();
                       myVacRequest.setP(p);
                       myVacRequest.setStartDate((Date)tblLeaveRequests1.getValueAt(selectedRow, 2));
                       myVacRequest.setEndDate((Date)tblLeaveRequests1.getValueAt(selectedRow, 3));
                       myVacRequest.setStatus("Approved");
                       myVacRequest.setType("Vacation");
                       myVacRequest.setTotalNumberofDays(myVacRequest.getEndDate().compareTo(myVacRequest.getStartDate())+1);
                       p.setMyVaccationBalance(p.getMyVaccationBalance()-myVacRequest.getTotalNumberofDays());
                       p.getLeaveTracker().add(myVacRequest);
                       
                       
                    }
                }
            }
        }
        
        
        JOptionPane.showMessageDialog(null, "Leave approved successfully. Vacation Balance left "+ p.getMyVaccationBalance());
            try {
                sendEmail(p);
            } catch (MessagingException ex) {
                Logger.getLogger(SupervisorWorkArea.class.getName()).log(Level.SEVERE, null, ex);
            }
        populateLeaveRequests();
//        }
//        else{
//            JOptionPane.showMessageDialog(null, validate);
//        }
        
        }
        else{
            l.setStatus("Rejected");
            p.UpdateLeaveRequestbyPersonAndID(l.getRequestId(), p, "Rejected");
            JOptionPane.showMessageDialog(null, "Leave rejected. Vacation Balance left "+ p.getMyVaccationBalance());
            populateLeaveRequests();
        }
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void teaBrekThresholdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teaBrekThresholdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teaBrekThresholdActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        try{
        if(Integer.parseInt(totalWorkThresholdTxt.getText())<0
                ||
           Integer.parseInt(teaBrekThreshold.getText())<0
                ||
            Integer.parseInt(luncBreakThreshold.getText())<0
                ||
            Integer.parseInt(workatStretchThreoldTxt.getText())<0
         ){
            JOptionPane.showMessageDialog(null, "Please enter positive integer Values");
        }
        else{
        Person p= (Person)personCombo.getSelectedItem();
        p.setTotalWorkHoursThreshold(Integer.parseInt(totalWorkThresholdTxt.getText()));
        p.setTeaBreakThreshold(Integer.parseInt(teaBrekThreshold.getText()));
        p.setLunchBreakThreshold(Integer.parseInt(luncBreakThreshold.getText()));
        p.setAtStretchWorkThreshold(Integer.parseInt(workatStretchThreoldTxt.getText()));
        JOptionPane.showMessageDialog(null, "Details saved successfully");
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please enter integer Values");
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField luncBreakThreshold;
    private javax.swing.JComboBox personCombo;
    private javax.swing.JComboBox personCombo1;
    private javax.swing.JComboBox<String> statusCombo;
    private javax.swing.JTable tblLeaveRequests;
    private javax.swing.JTable tblLeaveRequests1;
    private javax.swing.JTextField teaBrekThreshold;
    private javax.swing.JComboBox teamLeadCombo;
    private javax.swing.JTextField totalWorkThresholdTxt;
    private javax.swing.JTextField workatStretchThreoldTxt;
    // End of variables declaration//GEN-END:variables
}
