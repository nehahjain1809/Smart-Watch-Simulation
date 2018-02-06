/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Person;

import Business.Helper.MultiLineChart;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Helper.GraphHelper;
import Business.Helper.RoutineHelper;
import Business.Helper.SleepHelper;
import Business.Helper.VacationHelper;
import Business.Hospital.Appointment;
import Business.Hospital.AppointmentDirectory;
import Business.Hospital.DoctorDirectory;
import Business.Hospital.VitalSigns;
import Business.Hospital.VitalSignsDirectoryy;
import Business.Network.Network;
import Business.Organization.CustomerOrganization;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Recommendations.RecommendationDirectory;
import Business.Recommendations.Recommendations;
import Business.Routine.FoodConsumptionTracker;
import Business.Routine.FoodConsumptionTrackerDirectory;
import Business.Routine.Sleep;
import Business.Routine.SleepDirectory;
import Business.Routine.WorkOut;
import Business.Routine.WorkOutDirectory;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkPlace.Holiday;
import Business.WorkPlace.HolidayList;
import Business.WorkPlace.LeaveRequest;
import Business.WorkPlace.LeaveRequestHistory;
import Business.WorkPlace.MyVacation;
import Business.WorkPlace.MyVaccationHistory;
import Business.WorkPlace.SupervisorDirectory;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
/**
 *
 * @author KRISH PRAVIN JAIN
 */
public class MyRoutineJPanel1 extends javax.swing.JPanel {

    /**
     * Creates new form MyRoutineJPanel1
     */
    JPanel userProcessContainer;
    UserAccount userAccount;
    CustomerOrganization customerOrganization;
    Enterprise inEnterprise;
    Network n;
    Person p;
    EcoSystem system;
    
        Calendar cal = Calendar.getInstance();
        SleepDirectory sleeplist;
        List<LocalDate> getBestStartDates;
        VacationHelper vh;
        RecommendationDirectory recommmendationDirectory;
        SleepHelper sleepHelper;
        RoutineHelper routinehelper;
        private HashMap<Date, Float> sleephours;
        private HashMap<Date, Float> foodConsumption;
        private HashMap<Date, Float> workOut;
         Map<Person, ArrayList<Sleep>> map1=new HashMap<>();
         Map<Person, ArrayList<FoodConsumptionTracker>> map2=new HashMap<>();
         Map<Person, ArrayList<WorkOut>> map3=new HashMap<>();
    
    PersonDirectory personDirectory;
    SleepDirectory sleepDirectory;
    WorkOutDirectory workoutDirectory;
    FoodConsumptionTrackerDirectory foodConsumptionTrackerDirectory;
    VitalSignsDirectoryy vitalSignsDirectory;
    AppointmentDirectory appointmentDirectory;
    MyVaccationHistory vacationDirectory;
    ArrayList<Holiday> holidayList;
    PersonDirectory personDirectory1;
    SleepDirectory sleepDirectory1;
    WorkOutDirectory workoutDirectory1;
    MyRoutineJPanel1(JPanel userProcessContainer, 
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
        this.sleepDirectory=customerOrganization.getSleepDirectory();
        this.workoutDirectory=customerOrganization.getWorkoutDirectory();
        this.foodConsumptionTrackerDirectory=customerOrganization.getFoodConsumptionTrackerDirectory();
        this.vitalSignsDirectory=customerOrganization.getVitalsignDirectory();
        this.appointmentDirectory=customerOrganization.getAppointmentDirectory();
        this.vacationDirectory=customerOrganization.getVacationHistory();
        this.recommmendationDirectory=customerOrganization.getRecommmendationDirectory();
        //vh=new  VacationHelper(holidayList);
        //getBestStartDates=vh.getBestVacationStartDates(p.getMyVaccationBalance());
        cleanRecommendations();
//        personDirectory1=new PersonDirectory();
//        sleepDirectory1=new SleepDirectory();
//        workoutDirectory1=new WorkOutDirectory();
//        for(Network net:system.getNetworkList()){
//            for(Enterprise e:net.getEnterpriseDirectory().getEnterpriseList()){
//                for(Organization o: e.getOrganizationDirectory().getOrganizationList()){
//                    for(Person per: o.getPersonDirectory().getPersonList()){
//                        personDirectory1.getPersonList().add(p);
//                    }
//                }
//            }
//        }
//        sleepDirectory1=new SleepDirectory();
//        for(Network net:system.getNetworkList()){
//            for(Enterprise e:net.getEnterpriseDirectory().getEnterpriseList()){
//                for(Organization o: e.getOrganizationDirectory().getOrganizationList()){
//                    for(Person per: o.getPersonDirectory().getPersonList()){
//                        for(Sleep s:per.getSleepTracker())
//                        sleepDirectory1.getSleepDirectory().add(s);
//                    }
//                }
//            }
//        }
//        
//        workoutDirectory1=new WorkOutDirectory();
//        for(Network net:system.getNetworkList()){
//            for(Enterprise e:net.getEnterpriseDirectory().getEnterpriseList()){
//                for(Organization o: e.getOrganizationDirectory().getOrganizationList()){
//                    for(Person per: o.getPersonDirectory().getPersonList()){
//                        for(WorkOut w:per.getWorkOutList())
//                        workoutDirectory1.getWorkOutList().add(w);
//                    }
//                }
//            }
//        }
        sleepHelper=new SleepHelper(personDirectory.getPersonList(), sleepDirectory, recommmendationDirectory);
        routinehelper=new RoutineHelper(personDirectory.getPersonList(),   recommmendationDirectory);
            
        sleephours=new HashMap<>();
        foodConsumption=new HashMap<>();
        workOut=new HashMap<>();
            
        populateSleepTable();
        populateTable();
        populateWorkoutTable();
        populateFoodTable();
    }
    
    public void cleanRecommendations(){
        
            for(Recommendations r: recommmendationDirectory.getRecommendationsList()){
                if(r.getPerson().getPersonName().equals(p.getPersonName())){
                p.getMyRecommendationsList().remove(r);
                }
            }
        
    }
     public void populateSleepTable()
    {
    DefaultTableModel dtm =(DefaultTableModel)tblSleepTrends.getModel();
    dtm.setRowCount(0);
    
    for(Sleep s: p.getSleepTracker())
    {
       
        Object row[]= new Object [3];
        row[0]=s.getP().getPersonName().toString();
        row[1]=s.getDate();
        row[2]=s.getSleepHours();
       
        sleephours.put(s.getDate(), s.getSleepHours());
        dtm.addRow(row);
    }
    }
     
     public void populateTable(){
        DefaultTableModel dtm =(DefaultTableModel)tblRecommendations.getModel();
        dtm.setRowCount(0);
        for (Recommendations r:p.getMyRecommendationsList())
        
        {
            Object row[]= new Object [1];
            row[0]=r.getRecommendationDescription();
            dtm.addRow(row);
        }
    }
     
     public void populateWorkoutTable()
    {
         DefaultTableModel dtm =(DefaultTableModel)tblWorkout.getModel();
    dtm.setRowCount(0);
    
    for(WorkOut w : p.getWorkOutList())
    {
        Object row[]= new Object [9];
        row[0]=w.getP().getPersonName().toString();
        row[1]="None";
        row[2]=w.getTotal_calories_burnt();
        row[3]=w.getVitalSigns().getHeartRate();
        row[4]=w.getVitalSigns().getBloodPressure();
        row[5]=w.getVitalSigns().getSugarLevel();
        row[6]=w.getWalking_calories();
        row[7]=w.getRunning_calories();
        row[8]=w.getGyming_calories();
        workOut.put(w.getDate(),w.getTotal_calories_burnt());
        
        dtm.addRow(row);
    }
    }
     
     public float calculateTotalCalories(FoodConsumptionTracker f )
    {
        
          float totalcalories= (float) ((f.getCarbs()*4) + (f.getProteins()*4) + (f.getFats()*9) + (f.getVitamins()*4) );
          return totalcalories;
        
         
        
    }
    
    public void populateFoodTable()
    {
        DefaultTableModel dtm =(DefaultTableModel)tblFood.getModel();
    dtm.setRowCount(0);
    
    for(FoodConsumptionTracker f : p.getFoodConsumptionTrackerList())
    {
        
        Object row[]= new Object [8];
        row[0]=f.getP().getPersonName().toString();
        row[1]=f.getDate();
        row[2]=f.getCarbs();
        row[3]=f.getFats();
        row[4]=f.getVitamins();
        row[5]=f.getProteins();
        row[6]=f.getWatercontent();
        row[7]=f.getTotalcalories();
        foodConsumption.put(f.getDate(),f.getTotalcalories());
        
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
        ViewWorldTrends = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSleepTrends = new javax.swing.JTable();
        BtnSleepChart = new javax.swing.JButton();
        sleepChartJPanel = new javax.swing.JPanel();
        sleepHoursCombo = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFood = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        foodConsumptionChart = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        caloriesTxtField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblWorkout = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        workoutChart = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecommendations = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        trendChartJPanel = new javax.swing.JPanel();
        networkcheck = new javax.swing.JCheckBox();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        personCombo = new javax.swing.JComboBox();
        jButton6 = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(61, 57, 85));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("My Routine Tracker");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 340, -1));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        tblSleepTrends.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person", "Date", "Sleep hours"
            }
        ));
        jScrollPane2.setViewportView(tblSleepTrends);

        BtnSleepChart.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnSleepChart.setText("View Sleep Chart>>");
        BtnSleepChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSleepChartActionPerformed(evt);
            }
        });

        sleepChartJPanel.setBackground(new java.awt.Color(255, 255, 255));
        sleepChartJPanel.setLayout(new java.awt.BorderLayout());

        sleepHoursCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Add today's Sleep hours>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(dateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(sleepHoursCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton3)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 993, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BtnSleepChart, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sleepChartJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnSleepChart)
                .addGap(13, 13, 13)
                .addComponent(sleepChartJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sleepHoursCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        ViewWorldTrends.addTab("View Sleep Trends", jPanel1);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        tblFood.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person", "Datetime", "Carbs", "fats", "vitamins", "proteins", "water content", "total Calories"
            }
        ));
        jScrollPane3.setViewportView(tblFood);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("View Food Consumption Chart>>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        foodConsumptionChart.setBackground(new java.awt.Color(255, 255, 255));
        foodConsumptionChart.setLayout(new java.awt.BorderLayout());

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Add Today's Food Consumption>");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Calories");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(foodConsumptionChart, javax.swing.GroupLayout.PREFERRED_SIZE, 987, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(701, 701, 701)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(caloriesTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(foodConsumptionChart, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(caloriesTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        ViewWorldTrends.addTab("View Food Consumption Trends", jPanel2);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        tblWorkout.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person", "Action", "Calories burnt", "Heart Rate", "BP", "Sugar Level", "Walking", "Running", "Gym"
            }
        ));
        jScrollPane4.setViewportView(tblWorkout);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("View Workout Chart>>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        workoutChart.setBackground(new java.awt.Color(255, 255, 255));
        workoutChart.setForeground(new java.awt.Color(204, 204, 204));
        workoutChart.setLayout(new java.awt.BorderLayout());

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Start Work Out for Today>>");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(workoutChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(workoutChart, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton5)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        ViewWorldTrends.addTab("View Work-out Trends", jPanel3);

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        tblRecommendations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Recommendation"
            }
        ));
        jScrollPane1.setViewportView(tblRecommendations);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        ViewWorldTrends.addTab("View Recommendations", jPanel4);

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        trendChartJPanel.setBackground(new java.awt.Color(255, 255, 255));
        trendChartJPanel.setLayout(new java.awt.BorderLayout());

        networkcheck.setBackground(new java.awt.Color(51, 51, 51));
        networkcheck.setForeground(new java.awt.Color(255, 255, 255));
        networkcheck.setText("Within my Network");

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("Sleep Trends");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("Food Trends");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton9.setText("Work out trends");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("View Trends");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(networkcheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(255, 255, 255)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(personCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(trendChartJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 973, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(networkcheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton8)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 305, Short.MAX_VALUE)
                .addComponent(personCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(140, Short.MAX_VALUE)
                    .addComponent(trendChartJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(131, Short.MAX_VALUE)))
        );

        ViewWorldTrends.addTab("View World Trends", jPanel5);

        add(ViewWorldTrends, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1010, 570));

        jButton6.setText("<<Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSleepChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSleepChartActionPerformed
        // TODO add your handling code here:
        sleepchart();
        
    }//GEN-LAST:event_BtnSleepChartActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       foodGraph();
    }//GEN-LAST:event_jButton1ActionPerformed
   
    public void sleepchart(){
        GraphHelper gh=new GraphHelper();
        JFreeChart chart=gh.showChart(sleephours);
        ChartPanel cp=new ChartPanel(chart);
        sleepChartJPanel.removeAll();
        sleepChartJPanel.add(cp,BorderLayout.CENTER);
        sleepChartJPanel.validate();
        sleepChartJPanel.repaint();
    }
    public void foodGraph()
    {
         GraphHelper gh=new GraphHelper();
        JFreeChart chart= gh.showChart(foodConsumption);
        ChartPanel cp=new ChartPanel(chart);
        foodConsumptionChart.removeAll();
        foodConsumptionChart.add(cp, BorderLayout.CENTER);
        foodConsumptionChart.validate();
        foodConsumptionChart.repaint();
    }
    public void createworkoutGraph(){
        GraphHelper gh=new GraphHelper();
        JFreeChart chart=gh.showChart(workOut);
        ChartPanel cp=new ChartPanel(chart);
        workoutChart.removeAll();
        workoutChart.add(cp, BorderLayout.CENTER);
        workoutChart.validate();
        workoutChart.repaint();
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        createworkoutGraph();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         WorkOutJPanel panel= new WorkOutJPanel( userProcessContainer,
                userAccount, 
                customerOrganization, 
                inEnterprise,
                system,
                n,
                 p
            );
        //untManageWorkJPanel(UserProcessContainer, accountDirectory);
        userProcessContainer.add("WorkOutJPanel", panel);
        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(dateChooser.getDate()!=null){
        Sleep s=customerOrganization.getSleepDirectory().addSleepTracker();
        s.setDate(dateChooser.getDate());
        s.setP(p);
        s.setSleepHours(Integer.parseInt(sleepHoursCombo.getSelectedItem().toString()));
        p.getSleepTracker().add(s);
        sleephours.put(s.getDate(),s.getSleepHours());
        JOptionPane.showMessageDialog(null, "Sleep hours added");
        populateSleepTable();
        sleepchart();
//        cleanRecommendations();
//        SleepDirectory sleepDirectory2;
//        sleepDirectory2=new SleepDirectory();
//         for(Network net:system.getNetworkList()){
//             for(Enterprise e:net.getEnterpriseDirectory().getEnterpriseList()){
//                 for(Organization o: e.getOrganizationDirectory().getOrganizationList()){
//                     for(Person pers: o.getPersonDirectory().getPersonList()){
//                         for(Sleep sl:pers.getSleepTracker())
//                         sleepDirectory2.getSleepDirectory().add(sl);
//                     }
//                 }
//             }
//         }
//        sleepHelper=new SleepHelper(personDirectory1.getPersonList(), sleepDirectory2, recommmendationDirectory);
//        routinehelper=new RoutineHelper(personDirectory1.getPersonList(), recommmendationDirectory);
        populateTable();
        
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select a date");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        FoodConsumptionTracker ft=customerOrganization.getFoodConsumptionTrackerDirectory().addFoodConsumptionTracker();
        ft.setP(p);
        ft.setDate(dateChooser1.getDate());
        p.setCalories(p.getCalories()+Float.parseFloat(caloriesTxtField.getText()));
        ft.setTotalcalories(Float.parseFloat(caloriesTxtField.getText()));
        float carbs=ft.getTotalcalories()/4;
        float fats=ft.getTotalcalories()/9;
        float proteins=ft.getTotalcalories()/4;
        float vitamins=ft.getTotalcalories()/4;
        ft.setCarbs(carbs);
        ft.setFats(fats);
        ft.setProteins(proteins);
        ft.setVitamins(vitamins);
        
        p.getFoodConsumptionTrackerList().add(ft);
        foodConsumption.put(ft.getDate(),ft.getTotalcalories());
        populateFoodTable();
        foodGraph();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        MyWorkAreaJPanel sysAdminwjp = ( MyWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int count=0;
        DefaultComboBoxModel model=new DefaultComboBoxModel();
        personCombo.setModel(model);
        map1.clear();
        if(networkcheck.isSelected()){
            for(Enterprise ent:n.getEnterpriseDirectory().getEnterpriseList()){
                for(Organization o:ent.getOrganizationDirectory().getOrganizationList()){
                    for(Person per:o.getPersonDirectory().getPersonList()){
                        if(!p.getPersonName().equals(per.getPersonName())){
                        personCombo.addItem(per);
                        for(Sleep s:per.getSleepTracker()){
                            map1.put(per, per.getSleepTracker());
                            count++;
                        }
                        }
                    }
                }
            }
        }
        else{
            for(Network n: system.getNetworkList()){
                for(Enterprise ent:n.getEnterpriseDirectory().getEnterpriseList()){
                    for(Organization o:ent.getOrganizationDirectory().getOrganizationList()){
                        for(Person per:o.getPersonDirectory().getPersonList()){
                            if(!p.getPersonName().equals(per.getPersonName())){
                                personCombo.addItem(per);
                            for(Sleep s:per.getSleepTracker()){
                                map1.put(per, per.getSleepTracker());
                                count++;
                            }
                            }
                        }
                    }
                }

            }
        }

        MultiLineChart demo = new MultiLineChart("Sleep Hours");

        XYDataset dataset = demo.createDataset(map1);
        JFreeChart chart = demo.createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        chartPanel.removeAll();
        trendChartJPanel.add(chartPanel,BorderLayout.CENTER);

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
                int count=0;
        DefaultComboBoxModel model=new DefaultComboBoxModel();
        personCombo.setModel(model);
        map3.clear();
        if(networkcheck.isSelected()){
            for(Enterprise ent:n.getEnterpriseDirectory().getEnterpriseList()){
                for(Organization o:ent.getOrganizationDirectory().getOrganizationList()){
                    for(Person per:o.getPersonDirectory().getPersonList()){
                        if(!p.getPersonName().equals(per.getPersonName())){
                            personCombo.addItem(per);
                        for(WorkOut s:per.getWorkOutList()){
                            map3.put(per,per.getWorkOutList());
                            count++;
                        }
                        }
                    }
                }
            }
        }
        else{
            for(Network n: system.getNetworkList()){
                for(Enterprise ent:n.getEnterpriseDirectory().getEnterpriseList()){
                    for(Organization o:ent.getOrganizationDirectory().getOrganizationList()){
                        for(Person per:o.getPersonDirectory().getPersonList()){
                            if(!p.getPersonName().equals(per.getPersonName())){
                                personCombo.addItem(per);
                            for(WorkOut s:per.getWorkOutList()){
                                map3.put(per, per.getWorkOutList());
                                count++;
                            }
                            }
                        }
                    }
                }

            }
        }

        MultiLineChart demo = new MultiLineChart("Calories Burnt");

        XYDataset dataset = demo.createDataset2(map3);
        JFreeChart chart = demo.createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        chartPanel.removeAll();
        trendChartJPanel.add(chartPanel,BorderLayout.CENTER);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        int count=0;
        //personCombo.removeAll();
        DefaultComboBoxModel model=new DefaultComboBoxModel();
        personCombo.setModel(model);
        map2.clear();
        if(networkcheck.isSelected()){
            for(Enterprise ent:n.getEnterpriseDirectory().getEnterpriseList()){
                for(Organization o:ent.getOrganizationDirectory().getOrganizationList()){
                    for(Person per:o.getPersonDirectory().getPersonList()){
                        if(!p.getPersonName().equals(per.getPersonName())){
                        personCombo.addItem(per);
                        for(FoodConsumptionTracker s:per.getFoodConsumptionTrackerList()){
                            map2.put(per,per.getFoodConsumptionTrackerList());
                            count++;
                        }
                        }
                    }
                }
            }
        }
        else{
            for(Network n: system.getNetworkList()){
                for(Enterprise ent:n.getEnterpriseDirectory().getEnterpriseList()){
                    for(Organization o:ent.getOrganizationDirectory().getOrganizationList()){
                        for(Person per:o.getPersonDirectory().getPersonList()){
                            if(!p.getPersonName().equals(per.getPersonName())){
                                personCombo.addItem(per);
                                for(FoodConsumptionTracker s:per.getFoodConsumptionTrackerList()){
                                map2.put(per, per.getFoodConsumptionTrackerList());
                                count++;
                            }
                            }
                        }
                    }
                }

            }
        }

        MultiLineChart demo = new MultiLineChart("Calories Consumed");

        XYDataset dataset = demo.createDataset1(map2);
        JFreeChart chart = demo.createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        chartPanel.removeAll();
        trendChartJPanel.add(chartPanel,BorderLayout.CENTER);
                                            

    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSleepChart;
    private javax.swing.JTabbedPane ViewWorldTrends;
    private javax.swing.JTextField caloriesTxtField;
    private com.toedter.calendar.JDateChooser dateChooser;
    private com.toedter.calendar.JDateChooser dateChooser1;
    private javax.swing.JPanel foodConsumptionChart;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JCheckBox networkcheck;
    private javax.swing.JComboBox personCombo;
    private javax.swing.JPanel sleepChartJPanel;
    private javax.swing.JComboBox sleepHoursCombo;
    private javax.swing.JTable tblFood;
    private javax.swing.JTable tblRecommendations;
    private javax.swing.JTable tblSleepTrends;
    private javax.swing.JTable tblWorkout;
    private javax.swing.JPanel trendChartJPanel;
    private javax.swing.JPanel workoutChart;
    // End of variables declaration//GEN-END:variables
}
