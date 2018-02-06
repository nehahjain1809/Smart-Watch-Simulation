/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Person;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Helper.VacationHelper;
import Business.Hospital.AppointmentDirectory;
import Business.Hospital.DoctorDirectory;
import Business.Hospital.HeartRecord;
import Business.Hospital.VitalSignsDirectoryy;
import Business.Hospital.sumRecords;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Recommendations.RecommendationDirectory;
import Business.Routine.FoodConsumptionTrackerDirectory;
import Business.Routine.SleepDirectory;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkPlace.HolidayList;
import Business.WorkPlace.LeaveRequestHistory;
import Business.WorkPlace.MyVaccationHistory;
import Business.WorkPlace.SupervisorDirectory;
import Business.WorkQueue.WorkRequestPersonDoc;
import java.awt.CardLayout;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nehah
 */
public class MyHealthTrackerJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MyHealthTrackerJPanel
     */
    
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
        VacationHelper vh;
        
        EcoSystem system;
        UserAccount userAccount;
        
        List<LocalDate> getBestStartDates;
    MyHealthTrackerJPanel(JPanel userProcessContainer, Person p, DoctorDirectory doctorList, UserAccountDirectory uad, PersonDirectory personList, SupervisorDirectory supervisorList, MyVaccationHistory leaveList, HolidayList holidayList, AppointmentDirectory appointmentDirectory, SleepDirectory sleepDirectory, FoodConsumptionTrackerDirectory foodTracker, VitalSignsDirectoryy vitalSignList, LeaveRequestHistory leaveRequestDirectory, RecommendationDirectory recommmendationDirectory, EcoSystem system, UserAccount userAccount) {
         initComponents();
         this.userProcessContainer=userProcessContainer;
            this.p=p;
            this.doctorList=doctorList;
            this.uad=uad;
            this.personList=personList;
            this.supervisorList=supervisorList;
            this.leaveList=leaveList;
            this.holidayList=holidayList;
           // this.vaccationHelper=vaccationHelper;
            this.appointmentDirectory=appointmentDirectory;
            this.sleepDirectory=sleepDirectory;
            this.foodTracker=foodTracker;
            this.vitalSignList=vitalSignList;
            this.leaveRequestDirectory=leaveRequestDirectory;
            this.recommmendationDirectory=recommmendationDirectory;
            this.system = system;
            this.userAccount = userAccount;
            System.out.println("ua: "+userAccount.getP().getMyDoctor().getUserAccount());
            populateRequestTable();
            populateTestTable();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequestTable = new javax.swing.JTable();
        btnRequest = new javax.swing.JButton();
        reasonTxtField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnViewMsg = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        taMsg = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetails = new javax.swing.JTable();
        btnDetails = new javax.swing.JButton();
        btnCapVitalSigns = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTest = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("My Health Tracker");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        tblRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Date", "Doctor", "Reason", "Apt Date", "Doc Feedback"
            }
        ));
        jScrollPane1.setViewportView(tblRequestTable);

        btnRequest.setText("Request for appointment>>");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reason");

        btnViewMsg.setText("View Doctor Message");
        btnViewMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewMsgActionPerformed(evt);
            }
        });

        taMsg.setColumns(20);
        taMsg.setRows(5);
        jScrollPane4.setViewportView(taMsg);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Message:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(reasonTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnViewMsg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(reasonTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnRequest)
                        .addGap(189, 189, 189))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnViewMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("View Appointments", jPanel1);

        tblDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date/Time", "Heart Rate", "Blood Pressure"
            }
        ));
        jScrollPane2.setViewportView(tblDetails);
        if (tblDetails.getColumnModel().getColumnCount() > 0) {
            tblDetails.getColumnModel().getColumn(0).setMinWidth(30);
            tblDetails.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        btnDetails.setText("View Details>>");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        btnCapVitalSigns.setText("Capture My Vital Signs>>");
        btnCapVitalSigns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapVitalSignsActionPerformed(evt);
            }
        });

        tblTest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Data"
            }
        ));
        jScrollPane3.setViewportView(tblTest);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(183, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCapVitalSigns, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(btnDetails)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCapVitalSigns)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(306, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("View Vital Signs", jPanel3);

        btnBack.setText("<<back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(408, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(277, 277, 277)
                .addComponent(btnBack)
                .addGap(127, 127, 127))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1011, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(34, 34, 34)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    public void populateRequestTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblRequestTable.getModel();
        dtm.setRowCount(0);
        
        for(WorkRequestPersonDoc request : userAccount.getWorkQueuePersonDoc().getWorkRequestListPersonDoc()){
            Object row[] = new Object[5];
            //row[0] = request.getId();
            row[0] = request.getReqDate();
            row[1] = request.getDoctor();
            row[2] = request;
            row[3] = request.getAppappointmentDate();
            row[4] = request.getDoctorReply();
            dtm.addRow(row);
        }
    }
    
    public void populateTestTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblTest.getModel();
        dtm.setRowCount(0);
        sumRecords personHashmap = userAccount.getP().getSumRecords();
        Map<Date, HeartRecord> sortedData = new TreeMap<>(personHashmap.getSumRecords());
        for(Map.Entry<Date, HeartRecord> pair : sortedData.entrySet()){
            Object row[] = new Object[2];
            row[0] = pair.getKey();
            row[1] = pair.getValue();
            dtm.addRow(row);
        }
    }
    
    public void populateDetailTable(HeartRecord hr){
        DefaultTableModel dtm = (DefaultTableModel) tblDetails.getModel();
        dtm.setRowCount(0);
        Map<Date, Integer> sortedData = new TreeMap<>(hr.getHeartRecords());
        for(Map.Entry<Date, Integer> pair : sortedData.entrySet()){
            Object row[] = new Object[2];
            row[0] = pair.getKey();
            row[1] = pair.getValue();
            dtm.addRow(row);
        }
    }
    
    
    private void btnCapVitalSignsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapVitalSignsActionPerformed
        // TODO add your handling code here:
        CaptureVitalSignsJPanel panel = new CaptureVitalSignsJPanel(userProcessContainer, userAccount, system);
        userProcessContainer.add("CaptureVitalSignsJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnCapVitalSignsActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        // TODO add your handling code here:
        String reason = reasonTxtField.getText();
        
        HospitalEnterprise hospitalEnterprise = null;
        for(Network network : system.getNetworkList()){
            for(Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()){
               if(e.getEnterpriseType().equals(Enterprise.EnterpriseType.Hospital)){
                    hospitalEnterprise = (HospitalEnterprise)e;
                    System.out.println("Found Hospital Enterprise");
               }
            }
        }
        
        WorkRequestPersonDoc workRequestPersonDoc = new WorkRequestPersonDoc();
        workRequestPersonDoc.setReasonMsg(reason);
        workRequestPersonDoc.setDoctor(userAccount.getP().getMyDoctor());
        workRequestPersonDoc.setReqDate(new Date());
        workRequestPersonDoc.setPerson(userAccount.getP());
        
        Organization org = null;
        if(hospitalEnterprise != null){
            for(Organization organization : hospitalEnterprise.getOrganizationDirectory().getOrganizationList()){
                System.out.println("organization name: "+organization.getName());
                if(organization instanceof DoctorOrganization){
                    org = organization;
                    break;
                }
            }
        }
        else{
            JOptionPane.showConfirmDialog(null, "No Hospital found");
        }
        if(org != null){
            org.getWorkQueuePersonDoc().getWorkRequestListPersonDoc().add(workRequestPersonDoc);
            userAccount.getWorkQueuePersonDoc().getWorkRequestListPersonDoc().add(workRequestPersonDoc);
            JOptionPane.showMessageDialog(null, "Request sent");
            System.out.println("work request added");
        }
        
        populateRequestTable();
    }//GEN-LAST:event_btnRequestActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblTest.getSelectedRow();
        
        if(selectedRow >= 0){
            HeartRecord hr = (HeartRecord) tblTest.getValueAt(selectedRow, 1);
            populateDetailTable(hr);
        }
        else{
            JOptionPane.showMessageDialog(null, "Choose a request to process.");
            return; 
        }
    }//GEN-LAST:event_btnDetailsActionPerformed

    private void btnViewMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewMsgActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblRequestTable.getSelectedRow();
        if(selectedRow >= 0){
            WorkRequestPersonDoc request = (WorkRequestPersonDoc) tblRequestTable.getValueAt(selectedRow, 2);
            String output = "";
            output = output + "Requested on: "+request.getReqDate()+"\n";
            output = output + "Reason: "+request.getReasonMsg()+"\n";
            output = output + "Message: \n";
            output = output + request.getDoctorReply();
            taMsg.setText(output);
        }
        else{
            JOptionPane.showMessageDialog(null, "Choose a request to show the message.");
            return;
        }
    }//GEN-LAST:event_btnViewMsgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCapVitalSigns;
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnRequest;
    private javax.swing.JButton btnViewMsg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField reasonTxtField;
    private javax.swing.JTextArea taMsg;
    private javax.swing.JTable tblDetails;
    private javax.swing.JTable tblRequestTable;
    private javax.swing.JTable tblTest;
    // End of variables declaration//GEN-END:variables
}