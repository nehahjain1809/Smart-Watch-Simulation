/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Person;

import Business.EcoSystem;
import Business.Enterprise.CompanyEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Helper.GraphHelper;
import Business.Helper.ScheduleRecommender;
import Business.Helper.VacationHelper;
import Business.Multithreading.WorkOutThread;
import Business.Network.Network;
import Business.Organization.CustomerOrganization;
import Business.Organization.Organization;
import Business.Organization.SupervisorOrganization;
import Business.Organization.TeamLeaderOrganization;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Recommendations.RecommendationDirectory;
import Business.Recommendations.Recommendations;
import Business.UserAccount.UserAccount;
import Business.WorkPlace.Holiday;
import Business.WorkPlace.LeaveRequest;
import Business.WorkPlace.LeaveRequestHistory;
import Business.WorkPlace.MyVacation;
import Business.WorkPlace.MyVaccationHistory;
import Business.WorkPlace.SupervisorDirectory;
import Business.WorkPlace.TeamLeaderDirectory;
import Business.WorkPlace.WorkProgress;
import Business.WorkPlace.WorkSchedule;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
//import java.util.Timer;
import javax.swing.Timer;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.tools.ShellFunctions.input;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author nehah
 */
public class MyWorkPlaceJPanel1 extends javax.swing.JPanel {
    JDatePickerImpl datePicker;
    JPanel userProcessContainer;
    UserAccount userAccount;
    CustomerOrganization customerOrganization;
    Enterprise inEnterprise;
    Network n;
    Person p;
    EcoSystem system;
    ArrayList<Holiday>holidayList;
    Calendar cal = Calendar.getInstance();
    VacationHelper vh;
    List<LocalDate> getBestStartDates;
    PersonDirectory personDirectory;
    SupervisorDirectory supervisorDirectory;
    TeamLeaderDirectory teamLeaderDirectory;
    LeaveRequestHistory leaverequestHistory;
    MyVaccationHistory vaccationHistory;
    RecommendationDirectory recommendationDirectory;
     Timer t1;
     private static float totalBreak=0;
    private static float totalWork=0;
    Date startDate;
    Date endDate;
    public static int counter=0;
    public static final Map<String, Integer> workScheduleMap=new HashMap<>();
     public static final Map<String, Integer> ScheduleMap=new HashMap<>();
   
    private SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");

    /**
     * Creates new form MyWorkPlaceJPanel1
     */
    public MyWorkPlaceJPanel1(JPanel userProcessContainer, 
            UserAccount userAccount, 
            CustomerOrganization customerOrganization, 
            Enterprise inEnterprise, 
            EcoSystem system, 
            Network n,
            Person p) {
       
        initComponents();
        
        
        this.userProcessContainer=userProcessContainer;
        this.userAccount=userAccount;
        this.customerOrganization=customerOrganization;
        this.n=n;
        this.system=system;
        this.inEnterprise=inEnterprise;
        this.p=p;
        this.holidayList=system.getHolidayList();
        this.personDirectory=customerOrganization.getPersonDirectory();
        this.vaccationHistory=customerOrganization.getVacationHistory();
        this.recommendationDirectory=customerOrganization.getRecommmendationDirectory();
        
        
        
        
        
        
        EnterpriseDirectory entr=n.getEnterpriseDirectory();
        for(Enterprise ent:entr.getEnterpriseList()){
            if(ent.getEnterpriseType().Company.getValue().equals("Company")){
                for(Organization org:ent.getOrganizationDirectory().getOrganizationList())
                {
                 if(org instanceof SupervisorOrganization)
                 {
                     supervisorDirectory=org.getSupervisorDirectory();
                     leaverequestHistory=org.getLeaverequestDirectory();
                 }
                 
                 if(org instanceof TeamLeaderOrganization)
                 {
                     teamLeaderDirectory=org.getTeamLeaderDirectory();
                 }
                }
            }
        }
        populateLeaveTrendsTable();
        populateLeaveRequestTable();
        populateScheduleTable();
        cleanRecommendations();
        
            //vh=new  VacationHelper(holidayList);
            //getBestStartDates=vh.getBestVacationStartDates(p.getMyVaccationBalance());
            //populateTable();
        
       
              
    }
    
     public void cleanRecommendations(){
        
            for(Recommendations r: recommendationDirectory.getRecommendationsList()){
                if(r.getPerson().getPersonName().equals(p.getPersonName())){
                p.getMyRecommendationsList().remove(r);
                }
            }
        
    }
     
    public void populateScheduleRecommendations(){
        DefaultTableModel dtm =(DefaultTableModel)recommTbl.getModel();
        dtm.setRowCount(0);
        for (Recommendations r:p.getMyRecommendationsList())
        
        {
            Object row[]= new Object [1];
            row[0]=r.getRecommendationDescription();
            dtm.addRow(row);
        }
    }
    
    public void populateScheduleTable(){
    DefaultTableModel dtm =(DefaultTableModel)WorkSchedule.getModel();
    dtm.setRowCount(0);
        for(WorkSchedule wksc:p.getMyworkSchedules()){
        Object row[]= new Object [6];
        row[0]=wksc.getId();
        row[1]=wksc.getDate();
        row[2]=wksc.getTotalWorkTime();
        row[3]=wksc.getTotalBreakTime();
        row[4]=wksc.getTotalworkingHours();
        row[5]=wksc.getP();
        dtm.addRow(row);
        }
    }
     public void populateTable(){
    DefaultTableModel dtm =(DefaultTableModel)tblVaccationRecommender.getModel();
    dtm.setRowCount(0);
    //for (LocalDate l:getBestStartDates)
    for(int i=0;i<(getBestStartDates.size());i++)    
    {
        Object row[]= new Object [2];
        row[0]=getBestStartDates.get(i);
        row[1]=getBestStartDates.get(i+1);
        i=i+1;
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

        WorkAreaJTabbedPane = new javax.swing.JTabbedPane();
        ViewVacationRecommendationsJPanel = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLeaveRequests = new javax.swing.JTable();
        btnRequestLeave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVaccationRecommender = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        ViewMyWorkHoursTrendJPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        consoleTxtArea = new javax.swing.JTextArea();
        workScheduleChartJPanel = new javax.swing.JPanel();
        btnStop = new javax.swing.JButton();
        actionCombo = new javax.swing.JComboBox<>();
        btnStart = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        recommTbl = new javax.swing.JTable();
        ViewScheduleRecommender = new java.awt.Button();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        WorkSchedule = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        ScheduleChart = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        ProgressChart = new javax.swing.JPanel();
        ViewMyLeaveTrendsJPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        LeavTrends = new javax.swing.JTable();
        sleepChartPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ViewVacationRecommendationsJPanel.setBackground(new java.awt.Color(102, 102, 102));
        ViewVacationRecommendationsJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("See my Vaccation Recommendations>>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        ViewVacationRecommendationsJPanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        tblLeaveRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person", "StartDate", "End Date", "Supervisor", "Status", "Request id"
            }
        ));
        jScrollPane2.setViewportView(tblLeaveRequests);

        ViewVacationRecommendationsJPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 550, 340));

        btnRequestLeave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRequestLeave.setText("Request Leave>>");
        btnRequestLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestLeaveActionPerformed(evt);
            }
        });
        ViewVacationRecommendationsJPanel.add(btnRequestLeave, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 120, -1));

        tblVaccationRecommender.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccation STartDate", "Vaccation End Date"
            }
        ));
        jScrollPane1.setViewportView(tblVaccationRecommender);

        ViewVacationRecommendationsJPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 390, 330));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("delete request");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        ViewVacationRecommendationsJPanel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, -1, -1));

        WorkAreaJTabbedPane.addTab("View VacationReccomendations", ViewVacationRecommendationsJPanel);

        ViewMyWorkHoursTrendJPanel.setBackground(new java.awt.Color(102, 102, 102));
        ViewMyWorkHoursTrendJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Action");
        ViewMyWorkHoursTrendJPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 70, 20));

        consoleTxtArea.setColumns(20);
        consoleTxtArea.setRows(5);
        jScrollPane4.setViewportView(consoleTxtArea);

        ViewMyWorkHoursTrendJPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1090, 160));

        workScheduleChartJPanel.setBackground(new java.awt.Color(255, 255, 255));
        workScheduleChartJPanel.setLayout(new java.awt.BorderLayout());
        ViewMyWorkHoursTrendJPanel.add(workScheduleChartJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 1090, 240));

        btnStop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });
        ViewMyWorkHoursTrendJPanel.add(btnStop, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, 140, -1));

        actionCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Work", "Break" }));
        ViewMyWorkHoursTrendJPanel.add(actionCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 140, -1));

        btnStart.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        ViewMyWorkHoursTrendJPanel.add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 140, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Done ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        ViewMyWorkHoursTrendJPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, 140, -1));
        ViewMyWorkHoursTrendJPanel.add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, -1));

        WorkAreaJTabbedPane.addTab("Monitor My Work Schedule", ViewMyWorkHoursTrendJPanel);

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recommTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Recommendation"
            }
        ));
        jScrollPane5.setViewportView(recommTbl);

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 910, 360));

        ViewScheduleRecommender.setActionCommand("BtnViewScheduleRecommendations\n");
        ViewScheduleRecommender.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        ViewScheduleRecommender.setLabel("View Schedule Recommendations>>");
        ViewScheduleRecommender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewScheduleRecommenderActionPerformed(evt);
            }
        });
        jPanel4.add(ViewScheduleRecommender, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 34, 280, 30));

        WorkAreaJTabbedPane.addTab("View Schedule Recommender", jPanel4);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        WorkSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Id", "Date", "Work hours", "Break Hours", "Total Hours", "Person"
            }
        ));
        jScrollPane6.setViewportView(WorkSchedule);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1030, 110));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("View Trends>>");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 200, -1));

        ScheduleChart.setBackground(new java.awt.Color(255, 255, 255));
        ScheduleChart.setLayout(new java.awt.BorderLayout());
        jPanel1.add(ScheduleChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 1020, 280));

        WorkAreaJTabbedPane.addTab("My Schedule Trends", jPanel1);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setText("View My Progress>>");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        ProgressChart.setBackground(new java.awt.Color(255, 255, 255));
        ProgressChart.setLayout(new java.awt.BorderLayout());
        jPanel2.add(ProgressChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 1060, 330));

        WorkAreaJTabbedPane.addTab("My Progress Report", jPanel2);

        ViewMyLeaveTrendsJPanel.setBackground(new java.awt.Color(102, 102, 102));
        ViewMyLeaveTrendsJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("View Leave Chart>>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ViewMyLeaveTrendsJPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, 270, -1));

        LeavTrends.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Start Date", "End Date", "Total Number of Days", "Type"
            }
        ));
        jScrollPane3.setViewportView(LeavTrends);

        ViewMyLeaveTrendsJPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1010, 100));

        sleepChartPanel.setBackground(new java.awt.Color(255, 255, 255));
        sleepChartPanel.setLayout(new java.awt.BorderLayout());
        ViewMyLeaveTrendsJPanel.add(sleepChartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 1010, 290));

        WorkAreaJTabbedPane.addTab("View My Leave Trends", ViewMyLeaveTrendsJPanel);

        add(WorkAreaJTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1130, 530));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("My WorkPlace Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 260, -1));

        btnback.setText("<<Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        for (Map.Entry entry : workScheduleMap.entrySet()) {
            System.out.println(entry.getKey().toString()+" "+ entry.getValue());
        }

        for (Map.Entry entry : workScheduleMap.entrySet()) {
            if(entry.getKey().toString().equals("Break")){
                totalBreak=(float)(Integer.parseInt(entry.getValue().toString())*15)/60;
                System.out.println(totalBreak);
            }
            else {
                totalWork=(float)(Integer.parseInt(entry.getValue().toString())*15)/60;
                System.out.println(totalWork);
            }
        }
        JOptionPane.showMessageDialog(null, totalWork);
        WorkSchedule wks=customerOrganization.getWksHistory().addWorkSchedule();
        //WorkSchedule wks=new WorkSchedule();
        Date date=dateChooser.getDate();
        JOptionPane.showMessageDialog(null, date);
        wks.setDate(date);
        wks.setP(p);
        wks.setTotalBreakTime(totalBreak);
        wks.setTotalWorkTime(totalWork);
        wks.setTotalworkingHours(totalBreak+totalWork);
        p.getMyworkSchedules().add(wks);

        Map< String, Float> workMap=new HashMap< String, Float>();
        for (Map.Entry entry : workScheduleMap.entrySet()) {
            workMap.put(entry.getKey().toString(),(float)(Integer.parseInt(entry.getValue().toString())*15)/60 );
        }



        totalBreak=0;
        totalWork=0;
        consoleTxtArea.setText("");

        workScheduleMap.remove("Work");
        workScheduleMap.remove("Break");
        populateScheduleTable();
        populategraph(workMap);
    }//GEN-LAST:event_jButton2ActionPerformed

    public void populategraph(Map< String, Float> workMap){
        
        GraphHelper gh=new GraphHelper();
        JFreeChart chart= gh.showChart3(workMap);
        ChartPanel cp=new ChartPanel(chart);
        workScheduleChartJPanel.removeAll();
        workScheduleChartJPanel.add(cp,BorderLayout.CENTER);
        workScheduleChartJPanel.validate();
        workScheduleChartJPanel.repaint();
    }
    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
        String action=actionCombo.getSelectedItem().toString();
        counter=0;
        ActionListener updateClock = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                startDate=cal.getTime();
                cal.add(Calendar.SECOND, 15);
                counter=counter+1;
                endDate=cal.getTime();
                String newTime = sdf.format(cal.getTime());
                Date strDate = null;
                try {
                    strDate = sdf.parse(newTime);
                } catch (ParseException ex) {
                    System.out.println(e);
                }
                consoleTxtArea.append(" Status at-> "+counter+" "+strDate+" " + action + "\n");
                if(counter==((p.getLunchBreakThreshold()*60+p.getTeaBreakThreshold()*60)/15)-1 && action.equals("Break")){
                    JOptionPane.showMessageDialog(null, "Break hours exhausting. Recommended to resume work.");
                }
                if(counter==((p.getAtStretchWorkThreshold()*60/15)-1) && action.equals("Work")){
                    JOptionPane.showMessageDialog(null, "You have been working for almost 3 hours at a stretch. Recommended to take a Power Break.");
                }
                if (!workScheduleMap.containsKey(action)) {
                    workScheduleMap.put(action, 1);

                }
                else{
                    for (Map.Entry< String, Integer> entry : workScheduleMap.entrySet()) {
                        if(entry.getKey()==(action)){
                            entry.setValue(entry.getValue()+1);
                        }
                    }
                }
                Map< String, Float> workMap=new HashMap< String, Float>();
                for (Map.Entry entry : workScheduleMap.entrySet()) {
                workMap.put(entry.getKey().toString(),(float)(Integer.parseInt(entry.getValue().toString())*15)/60 );
                populategraph(workMap);
                
        }

            }
        };
        
            t1 = new Timer(1000, updateClock);
            t1.start();

    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        //        cal.add(Calendar.SECOND, 15*count);
        //        endDate=cal.getTime();

        t1.stop();

    }//GEN-LAST:event_btnStopActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int selectedRow=tblLeaveRequests.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
        else{
            LeaveRequest lr=customerOrganization.getLeaverequestDirectory().findbyID(Integer.parseInt(tblLeaveRequests.getValueAt(selectedRow, 5).toString()));
            p.getLeaveRequestTracker().remove(lr);
            p.getMySupervisor().getLeaveList().remove(lr);
            customerOrganization.getLeaverequestDirectory().getLeaveRequestList().remove(lr);
            
            JOptionPane.showMessageDialog(null, "Request deleted");
            populateLeaveRequestTable();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnRequestLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestLeaveActionPerformed
        // TODO add your handling code here:
        int selectedRow=tblVaccationRecommender.getSelectedRow();
        LocalDate startlocaldate=(LocalDate)tblVaccationRecommender.getValueAt(selectedRow, 0);
        LocalDate endlocaldate=(LocalDate)tblVaccationRecommender.getValueAt(selectedRow, 1);
        //        Date startDate;
        //        Date endDate;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try{
            startDate=  sdf.parse(startlocaldate.toString());
            endDate=sdf.parse(endlocaldate.toString());

        }
        catch(Exception e){
            System.out.print(e);
        }

        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
        else if(checkOverLap(p,startDate,endDate)){
            JOptionPane.showMessageDialog(null, "You have an overlapping vacation. select another best option");
        }
        else{
            LeaveRequest lr=customerOrganization.getLeaverequestDirectory().addLeavRequest();
            for(Enterprise e:n.getEnterpriseDirectory().getEnterpriseList()){
                for(Organization org:e.getOrganizationDirectory().getOrganizationList()){
                    if(org instanceof SupervisorOrganization){
                        leaverequestHistory=org.getLeaverequestDirectory();
                        leaverequestHistory.getLeaveRequestList().add(lr);
                    }
                }
            }
            lr.setP(p);
            lr.setS(p.getMySupervisor());
            
            lr.setVaccStartDate(startDate);
            lr.setVaccEndDate(endDate);
            lr.setStatus("Pending");
            p.getLeaveRequestTracker().add(lr);
            p.getMySupervisor().getLeaveList().add(lr);
            populateLeaveRequestTable();
        }
    }//GEN-LAST:event_btnRequestLeaveActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        if(p.getMyVaccationBalance()<0){
            JOptionPane.showMessageDialog(null, "You have no vacation Balance left.");
        }

        else{
            vh=new  VacationHelper(holidayList);
            getBestStartDates=vh.getBestVacationStartDates(p.getMyVaccationBalance());
            populateTable();
        }

        //          VacationRecommenderJPanel panel= new VacationRecommenderJPanel(userProcessContainer,
            //
            //                                                        p,
            //                                                        doctorList,
            //                                                        uad,
            //                                                        personList,
            //                                                        supervisorList,
            //                                                        leaveList,
            //                                                        holidayList,
            //                                                        //vaccationHelper,
            //                                                        appointmentDirectory,
            //                                                        sleepDirectory,
            //                                                        foodTracker,
            //                                                        vitalSignList,
            //           leaveRequestDirectory,
            //          recommmendationDirectory);
        //        //untManageWorkJPanel(UserProcessContainer, accountDirectory);
        //        userProcessContainer.add("VacationRecommenderJPanel", panel);
        //        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        //        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //         GraphHelper gh=new GraphHelper();
        //        JFreeChart chart= gh.showChart(leaveChart);
        //        ChartPanel cp=new ChartPanel(chart);
        //        foodConsumptionChart.removeAll();
        //        foodConsumptionChart.add(cp, BorderLayout.CENTER);
        Map<Integer, Integer> leaveMap=new HashMap<Integer, Integer>();
        leaveMap=vaccationHistory.calculateVacationPerMonth(p);
        GraphHelper gh=new GraphHelper();
        JFreeChart chart= gh.showChart2(leaveMap);
        ChartPanel cp=new ChartPanel(chart);
        sleepChartPanel.removeAll();
        sleepChartPanel.add(cp,BorderLayout.CENTER);

        for (Map.Entry entry : leaveMap.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Map< Date, Float> workMap1=new HashMap< Date, Float>();
       
        for(WorkSchedule wk:p.getMyworkSchedules()){
            
            workMap1.put(wk.getDate(), wk.getTotalworkingHours());
        }
         GraphHelper gh=new GraphHelper();
        JFreeChart chart= gh.showChart4(workMap1);
        ChartPanel cp=new ChartPanel(chart);
        ScheduleChart.removeAll();
        ScheduleChart.add(cp,BorderLayout.CENTER);
    }//GEN-LAST:event_jButton5ActionPerformed

    public void LoadProgressGraph(){
        Map< Date, Integer> progressMap=new HashMap< Date, Integer>();
       
        for(WorkProgress wp:p.getMyWorkProgress()){
            
            progressMap.put(wp.getDate(), wp.getProgress());
        }
        GraphHelper gh=new GraphHelper();
        JFreeChart chart= gh.showChart5(progressMap);
        ChartPanel cp=new ChartPanel(chart);
        ProgressChart.removeAll();
        ProgressChart.add(cp,BorderLayout.CENTER);
        ProgressChart.validate();
        ProgressChart.repaint();
    }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        LoadProgressGraph();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        
         userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        MyWorkAreaJPanel sysAdminwjp = ( MyWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnbackActionPerformed

    private void ViewScheduleRecommenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewScheduleRecommenderActionPerformed
        // TODO add your handling code here:
        ScheduleRecommender sc=new ScheduleRecommender(p,recommendationDirectory);
        //ArrayList<String> recommendations=new ArrayList<String>();
        String rec=sc.getRecommendations(p);
        System.out.println(rec);
        populateScheduleRecommendations();
        
    }//GEN-LAST:event_ViewScheduleRecommenderActionPerformed

    private void populateLeaveTrendsTable(){
    DefaultTableModel dtm =(DefaultTableModel)LeavTrends.getModel();
    dtm.setRowCount(0);
    //for (LocalDate l:getBestStartDates)
    for(MyVacation l: p.getLeaveTracker())
    {
        Object row[]= new Object [5];
        row[0]=l.getP().getPersonName().toString();
        row[1]=l.getStartDate().toString();
        row[2]=l.getEndDate().toString();
        row[3]=l.getTotalNumberofDays();
        row[4]=l.getType().toString();
        
        dtm.addRow(row);
    }
    }
    
    private void populateLeaveRequestTable() {
    DefaultTableModel dtm =(DefaultTableModel)tblLeaveRequests.getModel();
    dtm.setRowCount(0);
    //for (LocalDate l:getBestStartDates)
    for(LeaveRequest l: p.getLeaveRequestTracker())
    {
        Object row[]= new Object [6];
        row[0]=l.getP().getPersonName().toString();
        row[1]=l.getVaccStartDate();
        row[2]=l.getVaccEndDate();
        row[3]=l.getP().getMySupervisor().getSupervisorName();
        row[4]=l.getStatus();
        row[5]=l.getRequestId();
        dtm.addRow(row);
    }
   }
    
    public boolean checkOverLap(Person p, Date startdate, Date enddate){
        
        for(MyVacation myvac:p.getLeaveTracker()){
            if(
              ((startdate.before(myvac.getStartDate())&& enddate.after(myvac.getStartDate())) || (enddate.equals(myvac.getStartDate())))
                    ||
             (myvac.getStartDate().equals(startdate) || (myvac.getStartDate().before(startdate) && myvac.getEndDate().after(enddate)))
               ||
             (myvac.getStartDate().equals(startdate) && myvac.getEndDate().equals(enddate))          
             
                    ||
              (myvac.getEndDate().equals(startdate) || (myvac.getEndDate().before(startdate) && myvac.getEndDate().after(enddate)))
             
            )
                return true;
        }
        return false;
    }
   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable LeavTrends;
    private javax.swing.JPanel ProgressChart;
    private javax.swing.JPanel ScheduleChart;
    private javax.swing.JPanel ViewMyLeaveTrendsJPanel;
    private javax.swing.JPanel ViewMyWorkHoursTrendJPanel;
    private java.awt.Button ViewScheduleRecommender;
    private javax.swing.JPanel ViewVacationRecommendationsJPanel;
    private javax.swing.JTabbedPane WorkAreaJTabbedPane;
    private javax.swing.JTable WorkSchedule;
    private javax.swing.JComboBox<String> actionCombo;
    private javax.swing.JButton btnRequestLeave;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton btnback;
    private javax.swing.JTextArea consoleTxtArea;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable recommTbl;
    private javax.swing.JPanel sleepChartPanel;
    private javax.swing.JTable tblLeaveRequests;
    private javax.swing.JTable tblVaccationRecommender;
    private javax.swing.JPanel workScheduleChartJPanel;
    // End of variables declaration//GEN-END:variables
}
