/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Person;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Hospital.HeartRecord;
import Business.Hospital.sumRecords;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequestPersonDoc;
import Interface.Hospital.Doctor.DoctorJPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ankushdeora
 */
public class CaptureVitalSignsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CaptureVitalSignsJPanel
     */
    Timer timer;
    
    private Date date = new Date();
    private Calendar cal;
    private SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
    private String output = "";
    private HeartRecord heartRecords = new HeartRecord();
    private HashMap<Date, Integer> bpm = new HashMap<>();
    private HashMap<Date, HeartRecord> personCapturedVital;
    private UserAccount userAccount;
    private JPanel userProcessContainer;

    private EcoSystem system;
    private int highestBPMRecorded = 0;
    private float trigger = 1;
    
    public CaptureVitalSignsJPanel(JPanel userProcessContainer, UserAccount userAccount, EcoSystem system) {
        initComponents();
        this.userAccount = userAccount;
        this.userProcessContainer = userProcessContainer;
        personCapturedVital = this.userAccount.getP().getSumRecords().getSumRecords();
        this.system = system;
        initTime();
    }

    public void initTime(){
        String d = sdf.format(date);
        
        Date d1;
        try {
            d1 = sdf.parse(d);
            cal = Calendar.getInstance();
            cal.setTime(d1);
            System.out.println("date in string:"+d);
        } catch (ParseException ex) {
            Logger.getLogger(CaptureVitalSignsJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    
    public DefaultCategoryDataset createCategoryDataset(){
        DefaultCategoryDataset ds1 = new DefaultCategoryDataset();
        Map<Date, Integer> sortedMap = new TreeMap<>(bpm);
        for(Date d: sortedMap.keySet()){
            double h = bpm.get(d);
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

            ds1.setValue(h, "", sdf.format(d));
            
        }
        return ds1;
    }
    
    public void refreshGraph(DefaultCategoryDataset dataSet){
        DefaultCategoryDataset ds = dataSet;
        //System.out.println("ds"+ds.getColumnKeys().get(1));
        JFreeChart chart = ChartFactory.createLineChart("", "x", "y", ds, PlotOrientation.VERTICAL, true, true, true);
        CategoryPlot catPlot = chart.getCategoryPlot();
        catPlot.setRangeGridlinePaint(Color.BLACK);
        
        ChartPanel cp = new ChartPanel(chart);
        cp.setDomainZoomable(true);
        cp.setRangeZoomable(true);
        cp.setAutoscrolls(true);
        CategoryPlot plot = chart.getCategoryPlot();
        System.out.println();
        
        //cp.setau
        graphPanel.removeAll();
        graphPanel.add(cp, BorderLayout.CENTER);
        graphPanel.validate();
        
    }
    
    public void sendAutomatedRequest(){
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
        workRequestPersonDoc.setReasonMsg("Abnormal Heart Rate (Automated)");
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
            JOptionPane.showMessageDialog(null, "Abnormal Heart rate detected. Report sent to Doctor");
            System.out.println("work request added");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        taLog = new javax.swing.JTextArea();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        lblBPM = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lblDateTime = new javax.swing.JLabel();
        chkbTrigger = new javax.swing.JCheckBox();
        graphPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(102, 102, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Capture Vital Signs");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 20, 942, 30));

        taLog.setColumns(20);
        taLog.setRows(5);
        jScrollPane1.setViewportView(taLog);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 1270, 250));

        btnStart.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnStart.setForeground(new java.awt.Color(51, 51, 51));
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        btnStop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });
        add(btnStop, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        lblBPM.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        lblBPM.setForeground(new java.awt.Color(255, 255, 255));
        lblBPM.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBPM.setText("-");
        add(lblBPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 53, 54));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BPM");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Heart Beats:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 790, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Date Time:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        lblDateTime.setForeground(new java.awt.Color(255, 255, 255));
        lblDateTime.setText("jLabel14");
        add(lblDateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 279, -1));

        chkbTrigger.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        chkbTrigger.setText("Trigger");
        add(chkbTrigger, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        graphPanel.setLayout(new java.awt.BorderLayout());
        add(graphPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 800, 450));
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
        Random r = new Random();
        int Low = 58;
        int High = 70;
        int Result = (int) (r.nextInt(High - Low) + Low);
        
        
        ActionListener updateFunc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //cal.add(Calendar.SECOND, 1);
                String newTime = sdf.format(new Date());
                Date newDate = null;
                try {
                    newDate = sdf.parse(newTime);
                } catch (ParseException ex) {
                    Logger.getLogger(CaptureVitalSignsJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("newDate in string:"+newDate);
                
                lblDateTime.setText(newDate.toString());
                int addBpm = r.nextInt(3);
                //System.out.println("addBpm: "+addBpm);
                int bpmUpdate;
                if(addBpm <2){
                    bpmUpdate = (int) ((Result + addBpm)*trigger);
                }
                else{
                    bpmUpdate = (int) ((Result - addBpm)*trigger);
                }
                
                if(bpmUpdate > highestBPMRecorded){
                    highestBPMRecorded = bpmUpdate;
                }
                
                if(chkbTrigger.isSelected() && trigger < 1.7){
                    trigger += 0.3;
                }
                
                if(bpmUpdate > 70 && !chkbTrigger.isSelected()){
                    trigger -= 0.3;
                }
                
                if(bpmUpdate < 70 && !chkbTrigger.isSelected()){
                    trigger = 1;
                }
                
                lblBPM.setText(String.valueOf(bpmUpdate));
                if(Integer.parseInt(lblBPM.getText())>70){
                    lblBPM.setForeground(Color.red);
                }
                bpm.put(newDate, bpmUpdate);
                output = output + "Heart beat: " +bpmUpdate+ "  At time: "+newDate.toString()+ "\n";
                //System.out.println(output);
                taLog.setText(output);
                
                DefaultCategoryDataset ds = createCategoryDataset();
                refreshGraph(ds);
            }
        };
        
        timer = new Timer(1000, updateFunc);
        timer.start();
        
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        // TODO add your handling code here:
        timer.stop();
        heartRecords.setHeartRecords(bpm);
        //heartRecords.calculateHighLow(bpm);
        System.out.println("Highest recorded: "+highestBPMRecorded);
        personCapturedVital.put(new Date(), heartRecords);
        
        if(highestBPMRecorded > 100){
            sendAutomatedRequest();
        }
        
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        
        Component[] componentArray = userProcessContainer.getComponents();
        System.out.println("componentarray length:"+componentArray.length);
        Component component = componentArray[componentArray.length - 1];
        MyHealthTrackerJPanel myHealthTrackerJPanel = (MyHealthTrackerJPanel) component;
        myHealthTrackerJPanel.populateRequestTable();
        myHealthTrackerJPanel.populateTestTable();
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JCheckBox chkbTrigger;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBPM;
    private javax.swing.JLabel lblDateTime;
    private javax.swing.JTextArea taLog;
    // End of variables declaration//GEN-END:variables
}
