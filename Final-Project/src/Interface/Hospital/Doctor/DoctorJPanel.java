/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Hospital.Doctor;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Hospital.Appointment;
import Business.Hospital.Doctor;
import Business.Hospital.HeartRecord;
import Business.Hospital.sumRecords;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequestPersonDoc;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author KRISH PRAVIN JAIN
 */
public class DoctorJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorJPanel
     */
    
    JPanel userProcessContainer;
    UserAccount userAccount;
    DoctorOrganization doctorOrganization;
    Enterprise inEnterprise;
    EcoSystem system;
    Network n;
    
    ArrayList<TableColumn> tempColumn ;
    Person selectedPerson;
    Date selectedDate;
    Doctor doc;      
    public DoctorJPanel(JPanel userProcessContainer, UserAccount userAccount, DoctorOrganization doctorOrganization, Enterprise inEnterprise, EcoSystem system, Network n) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    initComponents();
    this.userProcessContainer=userProcessContainer;
    this.userAccount=userAccount;
    this.system=system;
    this.n=n;
    this.inEnterprise=inEnterprise;
    this.doctorOrganization=doctorOrganization;
    
    lblUser.setVisible(false);
    populateRequestTable();
    if(doc!=null){
        populateAppointmentTable();
    }
    }

    public void populateRequestTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblRequest.getModel();
        dtm.setRowCount(0);
        
        for(WorkRequestPersonDoc request : doctorOrganization.getWorkQueuePersonDoc().getWorkRequestListPersonDoc()){
            if(request.getDoctor().getUserAccount().equals(userAccount)){
//                System.out.println("doctor username: "+request.getDoctor().getUserAccount());
                doc = request.getDoctor();
                Object row[] = new Object[6];
                row[0] = request.getPerson();
                row[1] = request.getReqDate();
                row[2] = request;
                row[3] = request.getDoctor();
                row[4] = request.getAppappointmentDate();
                row[5] = request.getForwardAssistant();
                dtm.addRow(row);
            }
        }
    }
    
    public void populateAppointmentTable(){
        DefaultTableModel dtm = (DefaultTableModel) tbAppointment.getModel();
        dtm.setRowCount(0);
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        for(Appointment a : doc.getAppointmentList().getAppointmentList()){
            String date = sdf1.format(a.getAppointmentDate());
            String time = sdf2.format(a.getAppointmentDate());
            Object row[] = new Object[3];
                row[0] = a.getPatientName();
                row[1] = date;
                row[2] = time;
                dtm.addRow(row);
        }
    }
    
    private void populateDetailsTable(Person person, Date date) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DefaultTableModel dtm = (DefaultTableModel) tblDetails.getModel();
        dtm.setRowCount(0);
        sumRecords records = person.getSumRecords();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String passedDate = sdf.format(date);
        Map<Date, HeartRecord> sortedData = new TreeMap<>(records.getSumRecords());
        for(Map.Entry<Date, HeartRecord> pair : sortedData.entrySet()){
            String pairDate = sdf.format(pair.getKey());
            System.out.println("date: "+pairDate);
            System.out.println("actual date: "+passedDate);
            if(passedDate.equals(pairDate)){
                System.out.println("if cond");
                Object row[] = new Object[2];
                row[0] = pair.getKey();
                row[1] = pair.getValue();
                dtm.addRow(row);
            }
        }
    }
    
    public void populateDetailTableWithDetails(HeartRecord hr){
        JTableHeader header = tblDetails.getTableHeader();
        TableColumnModel columnModel = header.getColumnModel();
        tempColumn = new ArrayList<TableColumn>();
        System.out.println("column model count:"+columnModel.getColumnCount());
        TableColumn column;
        for(int i =0; i<columnModel.getColumnCount(); i++){
            tempColumn.add(columnModel.getColumn(i));
            System.out.println("added to tempColumn:"+columnModel.getColumn(i).getHeaderValue());
            System.out.println("tempColumn"+tempColumn.size());
        }
        for(int i =0; i<columnModel.getColumnCount(); i++){
            column = columnModel.getColumn(i);
            columnModel.removeColumn(column);
        }
        
        DefaultTableModel dtm = (DefaultTableModel)tblDetails.getModel();
        dtm.setRowCount(0);
        dtm.setColumnCount(3);
        column = columnModel.getColumn(0);
        column.setHeaderValue("Date");
        column = columnModel.getColumn(1);
        column.setHeaderValue("BPM");
        column = columnModel.getColumn(2);
        column.setHeaderValue("Blood Pressure");
        header.repaint();
        
        Map<Date, Integer> sortedData = new TreeMap<>(hr.getHeartRecords());
        for(Map.Entry<Date, Integer> pair : sortedData.entrySet()){
            Object row[] = new Object[2];
            row[0] = pair.getKey();
            row[1] = pair.getValue();
            dtm.addRow(row);
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

        jLabel1 = new javax.swing.JLabel();
        btnViewReports = new javax.swing.JButton();
        btnSend = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAppointment = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDetails = new javax.swing.JTable();
        lblUser = new javax.swing.JLabel();
        btnTblBack = new javax.swing.JButton();
        btnTblDetails = new javax.swing.JButton();
        btnFeedback = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Doctor-work Area");

        btnViewReports.setText("View Reports");
        btnViewReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewReportsActionPerformed(evt);
            }
        });

        btnSend.setText("Flag for appointment");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        tblRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person", "Request Date", "Reason", "Doctor", "Appointment Date", "To assistant "
            }
        ));
        jScrollPane1.setViewportView(tblRequest);

        tbAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person", "Date", "Time"
            }
        ));
        jScrollPane2.setViewportView(tbAppointment);

        tblDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Data"
            }
        ));
        jScrollPane3.setViewportView(tblDetails);

        lblUser.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("lblUser");

        btnTblBack.setText("<<");
        btnTblBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTblBackActionPerformed(evt);
            }
        });

        btnTblDetails.setText("Details>>");
        btnTblDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTblDetailsActionPerformed(evt);
            }
        });

        btnFeedback.setText("Feedback");
        btnFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeedbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(443, 443, 443)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnViewReports, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(174, 174, 174)
                                .addComponent(btnFeedback)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSend))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
                            .addComponent(lblUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(383, 383, 383)
                                .addComponent(btnTblBack)
                                .addGap(88, 88, 88)
                                .addComponent(btnTblDetails))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnViewReports, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFeedback)))
                .addGap(10, 10, 10)
                .addComponent(lblUser)
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTblDetails)
                    .addComponent(btnTblBack))
                .addGap(90, 90, 90)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewReportsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblRequest.getSelectedRow();
        if(selectedRow >= 0){
            Person person = (Person) tblRequest.getValueAt(selectedRow, 0);
            Date date = (Date) tblRequest.getValueAt(selectedRow, 1);
            System.out.println("username: "+person.getAccount());
            selectedPerson = person;
            selectedDate = date;
            lblUser.setVisible(true);
            lblUser.setText("Reports of "+person.toString());
            populateDetailsTable(person, date);
        }
        else{
            JOptionPane.showMessageDialog(null, "Choose a request to process.");
            return; 
        }
    }//GEN-LAST:event_btnViewReportsActionPerformed

    private void btnTblDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTblDetailsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDetails.getSelectedRow();
        if(selectedRow >= 0){
            HeartRecord hr = (HeartRecord) tblDetails.getValueAt(selectedRow, 1);
            
            populateDetailTableWithDetails(hr);
        }
        else{
            JOptionPane.showMessageDialog(null, "Choose a request to process.");
            return; 
        }
    }//GEN-LAST:event_btnTblDetailsActionPerformed

    private void btnTblBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTblBackActionPerformed
        // TODO add your handling code here:
        
        JTableHeader header = tblDetails.getTableHeader();
        TableColumnModel columnModel = header.getColumnModel();
        TableColumn column;
        
        DefaultTableModel dtm = (DefaultTableModel)tblDetails.getModel();
        dtm.setColumnCount(tempColumn.size());
        
        for(int i = 0; i<tempColumn.size(); i++){
            column = columnModel.getColumn(i);
            System.out.println(tempColumn.get(i).getHeaderValue());
            column.setHeaderValue(tempColumn.get(i).getHeaderValue());
        }
        header.repaint();
        dtm.setRowCount(0);
        populateDetailsTable(selectedPerson, selectedDate);
    }//GEN-LAST:event_btnTblBackActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblRequest.getSelectedRow();
        if(selectedRow >= 0){
            WorkRequestPersonDoc wrpc = (WorkRequestPersonDoc) tblRequest.getValueAt(selectedRow, 2);
            wrpc.setForwardAssistant("sent");
            HospitalEnterprise hospitalEnterprise = null;
            for(Network network : system.getNetworkList()){
                for(Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()){
                   if(e.getEnterpriseType().equals(Enterprise.EnterpriseType.Hospital)){
                        hospitalEnterprise = (HospitalEnterprise)e;
                        System.out.println("Found Hospital Enterprise");
                   }
                }
            }
            Organization org = null;
            if(hospitalEnterprise != null){
                for(Organization organization : hospitalEnterprise.getOrganizationDirectory().getOrganizationList()){
                    System.out.println("organization name: "+organization.getName());
                    if(organization instanceof LabOrganization){
                        org = organization;
                        break;
                    }
                }
            }
            else{
                JOptionPane.showConfirmDialog(null, "No Hospital found");
            }
            
            if(org != null){
                org.getWorkQueuePersonDoc().getWorkRequestListPersonDoc().add(wrpc);
                //userAccount.getWorkQueuePersonDoc().getWorkRequestListPersonDoc().add(wrpc);
                JOptionPane.showMessageDialog(null, "sent");
                System.out.println("work request added");
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Choose a request to send.");
            return; 
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeedbackActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblRequest.getSelectedRow();
        if(selectedRow >= 0){
            WorkRequestPersonDoc wrpc = (WorkRequestPersonDoc) tblRequest.getValueAt(selectedRow, 2);
            DoctorFeedback panel = new DoctorFeedback(userProcessContainer, wrpc);
            userProcessContainer.add("DoctorFeedback",panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Choose a request.");
            return;
        }
    }//GEN-LAST:event_btnFeedbackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFeedback;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnTblBack;
    private javax.swing.JButton btnTblDetails;
    private javax.swing.JButton btnViewReports;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTable tbAppointment;
    private javax.swing.JTable tblDetails;
    private javax.swing.JTable tblRequest;
    // End of variables declaration//GEN-END:variables

    
}
