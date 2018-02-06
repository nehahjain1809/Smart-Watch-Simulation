/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Person;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Helper.JsonConvertor;
import Business.Hospital.Appointment;
import Business.Hospital.AppointmentDirectory;
import Business.Hospital.Doctor;
import Business.Hospital.VitalSigns;
import Business.Hospital.VitalSignsDirectoryy;
import Business.Network.Network;
import Business.Organization.CustomerOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.Organization.SupervisorOrganization;
import Business.Organization.TeamLeaderOrganization;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Routine.FoodConsumptionTracker;
import Business.Routine.FoodConsumptionTrackerDirectory;
import Business.Routine.Sleep;
import Business.Routine.SleepDirectory;
import Business.Routine.WorkOut;
import Business.Routine.WorkOutDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkPlace.LeaveRequest;
import Business.WorkPlace.LeaveRequestHistory;
import Business.WorkPlace.MyVacation;
import Business.WorkPlace.MyVaccationHistory;
import Business.WorkPlace.Supervisor;
import Business.WorkPlace.TeamLeader;
import Interface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;
import static com.db4o.qlin.QLinSupport.p;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nehah
 */
public class FillMyDetailsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form FillMyDetailsJPanel
     */
    private String APPOINTMENT_FILE_NAME = "Appointment.csv";
    private String VITALSIGNS_SCHEDULE_FILE_NAME="VitalSigns.csv";
    private  String VACATION_FILE_NAME="Vacation.csv";
      private String LEAVEREQUESTS_FILE_NAME="LeaveRequests.csv";
    private  String WORKOUT_SCHEDULE_FILE_NAME="WorkOut.csv";
    private String FOODCONSUMPTION_FILE_NAME = "FoodConsumption.csv";
    private   String SLEEP_FILE_NAME="Sleep.csv";
    private  String DATA_FILES_HOME = "./src/data/";
    private  String DELIMITER = ",";
    JPanel userProcessContainer;
    UserAccount userAccount;
    CustomerOrganization customerOrganization;
    Enterprise inEnterprise;
    EcoSystem system;
    Network n;
    //PersonDirectory personDirectory;
    Person p;
    
    PersonDirectory personDirectory;
    SleepDirectory sleepDirectory;
    WorkOutDirectory workoutDirectory;
    FoodConsumptionTrackerDirectory foodConsumptionTrackerDirectory;
    VitalSignsDirectoryy vitalSignsDirectory;
    AppointmentDirectory appointmentDirectory;
    MyVaccationHistory vacationDirectory;
    LeaveRequestHistory leaverequestHistory;
    
    public FillMyDetailsJPanel(JPanel userProcessContainer, UserAccount userAccount, CustomerOrganization customerOrganization, Enterprise inEnterprise, EcoSystem system, Network n) {
        initComponents();
        
        this.userProcessContainer=userProcessContainer;
        this.userAccount=userAccount;
        this.customerOrganization=customerOrganization;
        this.n=n;
        this.system=system;
        this.inEnterprise=inEnterprise;
        //LoadDoctorCOmbo();
        LoadSuperVisorCombo();
        LoadTeamCOmbo();
        LoadNetworkCombo();
        //personDirectory=customerOrganization.getPersonDirectory();
        this.personDirectory=customerOrganization.getPersonDirectory();
        this.sleepDirectory=customerOrganization.getSleepDirectory();
        this.workoutDirectory=customerOrganization.getWorkoutDirectory();
        this.foodConsumptionTrackerDirectory=customerOrganization.getFoodConsumptionTrackerDirectory();
        this.vitalSignsDirectory=customerOrganization.getVitalsignDirectory();
        this.appointmentDirectory=customerOrganization.getAppointmentDirectory();
        this.vacationDirectory=customerOrganization.getVacationHistory();
        this.leaverequestHistory=customerOrganization.getLeaverequestDirectory();
         p=personDirectory.findPersonByUserName(userAccount.getUsername());
         //populateSleepTable();
         //populateFoodTable();
         //populateWorkoutTable();
         
         
         
        
         String personName=p.getPersonName();
         if(personName.equals("")){
             nameTxtField.setText("");
        }
         
         else{
             nameTxtField.setText(p.getPersonName());
         }
         
         
         String email=p.getEmailId();
         if(email != null){
             emailTxtField.setText("");
        }
         else{
             emailTxtField.setText(p.getEmailId());
         }
         int age=p.getPersonAge();
         if(String.valueOf(age).equals(null)){
             agetxtField.setText("");
        }
         else{
             agetxtField.setText(String.valueOf(p.getPersonAge()));
         }
         
         float height=p.getHeight();
         if(String.valueOf(height).equals(null)){
             htTxtField.setText("");
        }
         else{
             htTxtField.setText(String.valueOf(p.getHeight()));
         }
         
         float wg=p.getWeight();
         if(String.valueOf(wg).equals(null)){
             weighttxtField.setText("");
        }
         else{
             weighttxtField.setText(String.valueOf(p.getWeight()));
         }
         
         float bmi=p.getBmi();
         if(String.valueOf(bmi).equals(null)){
             bmiTxtField.setText("");
        }
         else{
             bmiTxtField.setText(String.valueOf(p.getBmi()));
         }
         
         int vac=p.getMyVaccationBalance();
         if(String.valueOf(vac).equals(null)){
             vaccBalance.setText("");
        }
         else{
             vaccBalance.setText(String.valueOf(p.getMyVaccationBalance()));
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nameTxtField = new javax.swing.JTextField();
        agetxtField = new javax.swing.JTextField();
        genderCombo = new javax.swing.JComboBox<>();
        htTxtField = new javax.swing.JTextField();
        weighttxtField = new javax.swing.JTextField();
        bmiTxtField = new javax.swing.JTextField();
        doctorCombo = new javax.swing.JComboBox();
        superVisorCombo = new javax.swing.JComboBox();
        btnSave = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnFoodconsumption = new javax.swing.JButton();
        btnWorkout = new javax.swing.JButton();
        btnLeave = new javax.swing.JButton();
        btnVitalSign = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        vaccBalance = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        calConsumptionTxtField = new javax.swing.JTextField();
        calBurnThreshold = new javax.swing.JTextField();
        fileNameTxtField = new javax.swing.JTextField();
        btnBrowze = new javax.swing.JButton();
        imageLbl = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        networkCombo = new javax.swing.JComboBox();
        statsPermissionChkBox = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        emailTxtField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("View and Update My Details");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Age");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gender");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("height");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("weight");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Doctor");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("bmi");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Supervisor");

        genderCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male" }));

        doctorCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorComboActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Load My Sleep Data>>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnFoodconsumption.setBackground(new java.awt.Color(255, 255, 255));
        btnFoodconsumption.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnFoodconsumption.setText("Load My Food consumption>>");
        btnFoodconsumption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoodconsumptionActionPerformed(evt);
            }
        });

        btnWorkout.setBackground(new java.awt.Color(255, 255, 255));
        btnWorkout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnWorkout.setText("Load My Work-out Trends>>");
        btnWorkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWorkoutActionPerformed(evt);
            }
        });

        btnLeave.setBackground(new java.awt.Color(255, 255, 255));
        btnLeave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLeave.setText("Load My Vacation Data>>");
        btnLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaveActionPerformed(evt);
            }
        });

        btnVitalSign.setBackground(new java.awt.Color(255, 255, 255));
        btnVitalSign.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVitalSign.setText("Load Vital Signs>>");
        btnVitalSign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVitalSignActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Vacation Balance");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Calorie Consumption threshold");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Calorie Burn Threshold");

        btnBrowze.setBackground(new java.awt.Color(255, 255, 255));
        btnBrowze.setText("browse");
        btnBrowze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowzeActionPerformed(evt);
            }
        });

        imageLbl.setBackground(new java.awt.Color(102, 102, 102));
        imageLbl.setForeground(new java.awt.Color(153, 153, 153));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Team Leader");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Set My Location");

        networkCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkComboActionPerformed(evt);
            }
        });

        statsPermissionChkBox.setBackground(new java.awt.Color(0, 0, 0));
        statsPermissionChkBox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        statsPermissionChkBox.setForeground(new java.awt.Color(255, 255, 255));
        statsPermissionChkBox.setText("Check to allow for capturing your statistics for improved results");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Email Id");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Quick Link >>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(networkCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(imageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnWorkout, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLeave, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnFoodconsumption, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(calConsumptionTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(calBurnThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(vaccBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnVitalSign, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(statsPermissionChkBox, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4))
                                    .addGap(56, 56, 56))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(htTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nameTxtField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(agetxtField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(genderCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 208, Short.MAX_VALUE))
                                .addComponent(weighttxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnBrowze)
                                .addComponent(jLabel8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bmiTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(fileNameTxtField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                    .addComponent(emailTxtField, javax.swing.GroupLayout.Alignment.LEADING)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doctorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(superVisorCombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agetxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(genderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(htTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(weighttxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(bmiTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnBrowze)
                                    .addComponent(fileNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(emailTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(networkCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnFoodconsumption)
                        .addGap(11, 11, 11)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnWorkout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLeave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVitalSign)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(imageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(doctorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(superVisorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(vaccBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(calBurnThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(calConsumptionTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(statsPermissionChkBox))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("My Personal Details", jPanel1);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("<<back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(442, 442, 442)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private Set<Sleep> parseSleepData(Collection<String []> sleepData) 
    {
        Set<Sleep> sleeps = new HashSet<>();
        for (String[] sleepDataRow : sleepData) {
          if(p.getAccount().getUsername().equals(sleepDataRow[0].toString())){
            Sleep sleep=new Sleep();
            SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
            sleep.setP(p);
            sleep.setSleepHours(Float.parseFloat(sleepDataRow[2]));
            
            try{
            Date date = (Date)sdf.parse(sleepDataRow[1]); 
            sleep.setDate(date);
            }
            catch(Exception e){
                System.out.print(e);
            }
            
            
            sleeps.add(sleep);
            p.getSleepTracker().add(sleep);
            sleepDirectory.getSleepDirectory().add(sleep);
            
            
        }
        }
        return sleeps;
    }
    
    public void LoadNetworkCombo(){
        for(Network n:system.getNetworkList()){
            networkCombo.addItem(n);
        }
    }
    
    private Set<LeaveRequest> parseLeaverequestData(Collection<String[]> leaverequestData)
    {
        Set<LeaveRequest> leaverequests = new HashSet<>();
        for(String[] leaverequestDataRow : leaverequestData)
        {
            if(p.getAccount().getUsername().equals(leaverequestDataRow[1]))
            {
                LeaveRequest leaverequest=new LeaveRequest();
                 SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
                 try{
            Date vacstartDate = (Date)sdf.parse(leaverequestDataRow[4]); 
            Date vacendDate = (Date)sdf.parse(leaverequestDataRow[5]); 
            leaverequest.setVaccStartDate(vacstartDate);
            leaverequest.setVaccEndDate(vacendDate);
            
            }
            catch(Exception e){
                System.out.print(e);
            }
                 leaverequest.setP(p);
                 
                 leaverequest.setTotalNumberofDays(Integer.parseInt(leaverequestDataRow[6]));
                 leaverequest.setStatus(leaverequestDataRow[7]);
                 
                 leaverequests.add(leaverequest);
                 p.getLeaveRequestTracker().add(leaverequest);
                 
                 leaverequestHistory.getLeaveRequestList().add(leaverequest);
            }
        }
        return leaverequests;
    }
    
    
    private  Set<MyVacation> parseMyVacationtData(Collection<String []> vacationData) 
    {
        Set<MyVacation> vacations = new HashSet<>();
        for (String[] vacationDataDataRow : vacationData) {
            if(vacationDataDataRow[0].toString().equals(p.getAccount().getUsername())){
            MyVacation vacation=new MyVacation();   
            //MyVacation vacation = leaveList.addMyVacation();
                SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
                try{
                Date vaccationStartDate = (Date)sdf.parse(vacationDataDataRow[1]); 
                Date vaccationEndDate = (Date)sdf.parse(vacationDataDataRow[2]); 

                vacation.setStartDate(vaccationStartDate);
                vacation.setEndDate(vaccationEndDate);
                }
                catch(Exception e){
                    System.out.print(e);
                }
            //Person p=personList.findPersonByUserName(vacationDataDataRow[0]);
                vacation.setP(p);
                vacation.setTotalNumberofDays(Integer.parseInt(vacationDataDataRow[3]));
                vacation.setStatus(vacationDataDataRow[4]);
                vacation.setType(vacationDataDataRow[5]);
                        
            
            vacations.add(vacation);
            p.getLeaveTracker().add(vacation);
            vacationDirectory.getVacationList().add(vacation);
            
        }
        }
        return vacations;
    }
    
     private  Set<WorkOut> parseWorkOutData(Collection<String []> workOutData) 
    {
        Set<WorkOut> workOuts = new HashSet<>();
        for (String[] workOutDataDataRow : workOutData) {
            if(workOutDataDataRow[1].equals(p.getAccount().getUsername())){
            //WorkOut workout =workoutDirectory.addWorkOut();
            WorkOut workout=new WorkOut();
            SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
            //SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
            try{
            Date date = (Date)sdf.parse(workOutDataDataRow[2]); 
           
            workout.setDate(date);
           
            }
            catch(Exception e){
                System.out.print(e);
            }
            //Date date=new Date();
            //Person p=personList.findPersonByPersonName(workOutDataDataRow[0]);
            workout.setP(p);
            
            workout.setTotal_calories_burnt(Float.parseFloat(workOutDataDataRow[3]));
            //workout.setSweat(Float.parseFloat(workOutDataDataRow[4]));
            //workout.setWorkouttype(workOutDataDataRow[4]);
            workout.setRunning_calories(Float.parseFloat(workOutDataDataRow[4]));
            workout.setWalking_calories(Float.parseFloat(workOutDataDataRow[5]));
            workout.setGyming_calories(Float.parseFloat(workOutDataDataRow[6]));
            VitalSigns v=new VitalSigns();
            v.setBloodPressure(Integer.parseInt(workOutDataDataRow[8]));
            v.setHeartRate(Integer.parseInt(workOutDataDataRow[7]));
            v.setSugarLevel(Integer.parseInt(workOutDataDataRow[9]));
            workout.setVitalSigns(v);
            
                        
            
            workOuts.add(workout);
            p.getWorkOutList().add(workout);
            workoutDirectory.getWorkOutList().add(workout);
            
            
        }
        }
        return workOuts;
    }
    
    private Set<VitalSigns> parseVitalSignData(Collection<String []> vitalSignsData) 
    {
        Set<VitalSigns> vitalSigns = new HashSet<>();
        for (String[] vitalSignDataDataRow : vitalSignsData) {
            if(vitalSignDataDataRow[0].toString().equals(p.getAccount().getUsername())){
            //VitalSigns vitalSign = vitalSignList.addVitalSigns();
            VitalSigns vitalSign=new VitalSigns();
            SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
            
            //Person p=personList.findPersonByUserName(vitalSignDataDataRow[0]);
            vitalSign.setP(p);
            vitalSign.setHeartRate(Integer.parseInt(vitalSignDataDataRow[1]));
            vitalSign.setBloodPressure(Integer.parseInt(vitalSignDataDataRow[2]));
            vitalSign.setSugarLevel(Integer.parseInt(vitalSignDataDataRow[3]));
            vitalSign.setWaterLevel(Float.parseFloat(vitalSignDataDataRow[4]));
            //vita.setTotalNumberofDays(Integer.parseInt(vacationDataDataRow[3]));
            Date date=new Date();
            vitalSign.setDate(date);
                        
            
            vitalSigns.add(vitalSign);
            p.getVitalSignHistory().add(vitalSign);
            vitalSignsDirectory.getVitalSignsList().add(vitalSign);
            
            
        }
        }
        return vitalSigns;
    } 
    
    private Set<Appointment> parseAppointmentData(Collection<String []> appointmentData) 
    {
        Set<Appointment> appointments = new HashSet<>();
        for (String[] appointmentDataRow : appointmentData) {
            if(appointmentDataRow[2].toString().equals(p.getAccount().getUsername())){
            Appointment appointment=new Appointment();
            //Appointment appointment = appointmentDirectory.addAppointment();
            SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
            try{
            Date appointmentDate = (Date)sdf.parse(appointmentDataRow[0]); 
            appointment.setAppointmentDate(appointmentDate);
            }
            catch(Exception e){
                System.out.print(e);
            }
            
            appointment.setPatientName(appointmentDataRow[1]);
            appointment.setPatientUserName(appointmentDataRow[2]);
            appointment.setDoctorName(appointmentDataRow[3]);
            appointment.setDoctorUserName(appointmentDataRow[4]);
            appointment.setLabAssistantName(appointmentDataRow[5]);
            appointment.setLabAssistantUserName(appointmentDataRow[6]);
            appointment.setAppointmentReason(appointmentDataRow[7]);
            String personUserName=appointment.getPatientUserName();
            String doctorUserName=appointment.getDoctorUserName();
            //System.out.println(personUserName);
           // Person p=personList.findPersonByUserName(personUserName);
            Doctor d=p.getMyDoctor();
            appointments.add(appointment);
//            appointmentDirectory.getAppointmentList().add(appointment);
            p.getAppointmentList().add(appointment);
          //  d.getAppointmentList().add(appointment);
            appointmentDirectory.getAppointmentList().add(appointment);
            
            
        }
        }
        return appointments;
    }
    
    private  Set<FoodConsumptionTracker> parseFoodConsumptionData(Collection<String []> foodConsumptionData) 
    {
        Set<FoodConsumptionTracker> foodConsumptions = new HashSet<>();
        for (String[] fcDataRow : foodConsumptionData) {
            if(p.getAccount().getUsername().equals(fcDataRow[1])){
            FoodConsumptionTracker foodConsumption=new FoodConsumptionTracker();
            //FoodConsumptionTracker foodConsumption = foodTracker.addFoodConsumptionTracker();
            String username=fcDataRow[1];
            //Person p=personList.findPersonByUserName(username);
            foodConsumption.setP(p);
            foodConsumption.setFats(Float.parseFloat(fcDataRow[2]));
            foodConsumption.setCarbs(Float.parseFloat(fcDataRow[3]));
            foodConsumption.setVitamins(Float.parseFloat(fcDataRow[4]));
            foodConsumption.setProteins(Float.parseFloat(fcDataRow[5]));
            foodConsumption.setWatercontent(Float.parseFloat(fcDataRow[6]));
            foodConsumption.setTotalcalories(foodConsumption.getCarbs()*4+foodConsumption.getFats()*9+foodConsumption.getProteins()*4+foodConsumption.getVitamins()*4);
            SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
            try{
            Date date = (Date)sdf.parse(fcDataRow[7]); 
           
            foodConsumption.setDate(date);
           
            }
            catch(Exception e){
                System.out.print(e);           
            }
            foodConsumptions.add(foodConsumption);
            p.getFoodConsumptionTrackerList().add(foodConsumption);
            foodConsumptionTrackerDirectory.getFoodconsumptionList().add(foodConsumption);
            
        }
        }
        return foodConsumptions;
    }
    
    
    public void LoadDoctorCOmbo(){
        //doctorCombo.removeAll();
//        for(int i=0;i<doctorCombo.getItemCount()-1;i++){
//            doctorCombo.remove(i);
//        }
        //Network net=(Network)networkCombo.getSelectedItem();
        for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
            for(Organization org:e.getOrganizationDirectory().getOrganizationList()){
             if(org instanceof DoctorOrganization){
                 for(Doctor d:org.getDoctorDirectory().getDoctorList()){
                     
                     doctorCombo.addItem(d);
                 }
             }
        }
        }
    }
    
    public void LoadTeamCOmbo(){
        jComboBox1.removeAll();
        for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
            for(Organization org:e.getOrganizationDirectory().getOrganizationList()){
             if(org instanceof TeamLeaderOrganization){
                 for(TeamLeader t:org.getTeamLeaderDirectory().getTeamleaderList()){
                    jComboBox1.addItem(t);
                 }
             }
        }
        }
    }
    
    
    public void LoadSuperVisorCombo(){
        superVisorCombo.removeAll();
         for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
            for(Organization org:e.getOrganizationDirectory().getOrganizationList()){
             if(org instanceof SupervisorOrganization){
                 for(Supervisor d:org.getSupervisorDirectory().getSupervisorList()){
                     superVisorCombo.addItem(d);
                 }
             }
        }
        }
    }
    
    public boolean ValidateEmail(String email){
        if(Pattern.matches("[a-zA-Z0-9.._%-]*+[@]+[a-zA-Z]*+[.][a-zA-z]{2,4}", email)){
            return true;
        }
        return false;
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(nameTxtField.getText().isEmpty() || agetxtField.getText().isEmpty()
           || genderCombo.getSelectedItem().toString().isEmpty()
           || htTxtField.getText().isEmpty()
           || weighttxtField.getText().isEmpty()
           || bmiTxtField.getText().isEmpty()
           || vaccBalance.getText().isEmpty()
           || calConsumptionTxtField.getText().isEmpty()
           || calBurnThreshold.getText().isEmpty()
           || emailTxtField.getText().isEmpty()
           ){
            JOptionPane.showMessageDialog(null, "Please enter all values");
        }else if(Float.parseFloat(htTxtField.getText()) <=0
                || Float.parseFloat(weighttxtField.getText()) <=0
                || Float.parseFloat(bmiTxtField.getText()) <=0
                || Integer.parseInt(vaccBalance.getText()) <0
                || Float.parseFloat(calConsumptionTxtField.getText()) <=0
                || Float.parseFloat(calBurnThreshold.getText()) <=0
                
                ){
                JOptionPane.showMessageDialog(null, "Please enter non-negative values");
        }
        else{
        try{
            Person p=customerOrganization.getPersonDirectory().findPersonByUserName(userAccount.getUsername());
            p.setPersonName(nameTxtField.getText());
            p.setPersonAge(Integer.parseInt(agetxtField.getText()));
            p.setGender(genderCombo.getSelectedItem().toString());
            p.setHeight(Float.parseFloat(htTxtField.getText()));
            p.setWeight(Float.parseFloat(weighttxtField.getText()));
            p.setMyDoctor((Doctor)doctorCombo.getSelectedItem());
            p.setMySupervisor((Supervisor)superVisorCombo.getSelectedItem());
            p.setMyTeamLeader((TeamLeader)jComboBox1.getSelectedItem());
            p.setBmi(Float.parseFloat(bmiTxtField.getText()));
            p.setMyVaccationBalance(Integer.parseInt(vaccBalance.getText()));
            p.setCaloriesConsumptionThreshold(Float.parseFloat(calConsumptionTxtField.getText()));
            p.setCaloriesburnThreshold(Float.parseFloat(calBurnThreshold.getText()));
            p.setLocation((Network)networkCombo.getSelectedItem());
            p.setStatsPermission(statsPermissionChkBox.isSelected());
            boolean emailValidate=false;
            
            emailValidate=ValidateEmail(emailTxtField.getText());
            
            if(!emailValidate){
                JOptionPane.showMessageDialog(null, "Email format incorrect. Please reenter");
                
            }
            else{
                
                p.setEmailId(emailTxtField.getText());
                
            }
            
            Doctor d=(Doctor)doctorCombo.getSelectedItem();
            boolean flag2=false;
            for(Person per:d.getPersonList()){
                if(per.equals(p)){
                    flag2=true;
                    break;
                }
            }
            if(!flag2){
            d.getPersonList().add(p);
            }
            
            
            Supervisor s=(Supervisor)superVisorCombo.getSelectedItem();
            
            boolean flag1=false;
            for(Person per:s.getPersonList()){
                if(per.equals(p)){
                    flag1=true;
                    break;
                }
            }
            if(!flag1){
            s.getPersonList().add(p);
            }
            
            TeamLeader t=(TeamLeader)jComboBox1.getSelectedItem();
            boolean flag=false;
            for(Person per:t.getPersonList()){
                if(per.equals(p)){
                    flag=true;
                    break;
                }
            }
            if(!flag){
            t.getPersonList().add(p);
            }
//            JsonConvertor jc=new JsonConvertor(p);
//            jc.converttoJson(p);
            JOptionPane.showMessageDialog(null, "Details added  successfully!!");
        }
        catch(Exception e){
           System.out.println(e);
        }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here: 
        Set<Sleep> sleeps = parseSleepData(loadDataFromCsvFile(DATA_FILES_HOME + SLEEP_FILE_NAME));
        System.out.println("SLeep data loaded..");
       // populateSleepTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnFoodconsumptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoodconsumptionActionPerformed
        // TODO add your handling code here:
        
        Set<FoodConsumptionTracker> foodConsumptionTrackers = parseFoodConsumptionData(loadDataFromCsvFile(DATA_FILES_HOME + FOODCONSUMPTION_FILE_NAME));
        System.out.println("Food Consumption data loaded..");
       // populateFoodTable();
    }//GEN-LAST:event_btnFoodconsumptionActionPerformed

    private void btnWorkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWorkoutActionPerformed
        // TODO add your handling code here:
        
         Set<WorkOut> workOuts = parseWorkOutData(loadDataFromCsvFile(DATA_FILES_HOME + WORKOUT_SCHEDULE_FILE_NAME));
        System.out.println("Workout data loaded..");
       // populateWorkoutTable();
    }//GEN-LAST:event_btnWorkoutActionPerformed

    private void btnLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaveActionPerformed
        // TODO add your handling code here:
        Set<MyVacation> vaccations = parseMyVacationtData(loadDataFromCsvFile(DATA_FILES_HOME + VACATION_FILE_NAME));
          System.out.println("Vaccation data loaded..");
    }//GEN-LAST:event_btnLeaveActionPerformed

    private void btnVitalSignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVitalSignActionPerformed
        // TODO add your handling code here:
         Set<VitalSigns> vitalSignses = parseVitalSignData(loadDataFromCsvFile(DATA_FILES_HOME + VITALSIGNS_SCHEDULE_FILE_NAME));
        System.out.println("Vital Signs  data loaded..");
        
    }//GEN-LAST:event_btnVitalSignActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
         Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        MyWorkAreaJPanel sysAdminwjp = ( MyWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBrowzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowzeActionPerformed
        // TODO add your handling code here:
        JFileChooser browser = new JFileChooser();
        //ImageIcon img=new ImageIcon();
        browser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = browser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File image = browser.getSelectedFile();
            //String fileName=browser.getName(image);
            String filePath=image.getAbsolutePath();
            fileNameTxtField.setText(image.getAbsolutePath());
            ImageIcon imageIcon = new ImageIcon(filePath);
            Image resizeImage = imageIcon.getImage(); // transform it
            Image finalimage = resizeImage.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
            ImageIcon resizedImage=new ImageIcon(finalimage);
            imageLbl.setIcon(resizedImage);
            p.setProfileImge(resizedImage);
    }//GEN-LAST:event_btnBrowzeActionPerformed
    }
    private void networkComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkComboActionPerformed
        // TODO add your handling code here:
        if(networkCombo.getSelectedIndex()!=0){
            JOptionPane.showMessageDialog(null, "You are suggested change your doctor if you are changing your network. Check quick link for doctor and fitness contact incase of an emergency while you travelling in other network ");
        }
        DefaultComboBoxModel model=new DefaultComboBoxModel();
        doctorCombo.setModel(model);
        Network net=(Network)networkCombo.getSelectedItem();
        for(Enterprise e: net.getEnterpriseDirectory().getEnterpriseList()){
            for(Organization org:e.getOrganizationDirectory().getOrganizationList()){
             if(org instanceof DoctorOrganization){
                 for(Doctor d:org.getDoctorDirectory().getDoctorList()){
                     doctorCombo.addItem(d);
                     System.out.println(doctorCombo.getItemCount());
                     }
                 }
             }
        }
    }//GEN-LAST:event_networkComboActionPerformed

    private void doctorComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doctorComboActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Desktop browser =Desktop.getDesktop();
        try
        {
            browser.browse(new URI("http://localhost:8080/"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(FillMyDetailsJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FillMyDetailsJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private  Collection<String []> loadDataFromCsvFile(String filePath) 
    {
        File inputFile = new File(filePath);
        Collection<String []> tableData = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(inputFile);
            boolean skippedHeader = false;
            while(scanner.hasNextLine()) {
                if (!skippedHeader) {
                    skippedHeader = true;
                    scanner.nextLine();
                    continue;
                }
                tableData.add(scanner.nextLine().split(DELIMITER));
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return tableData;
    }      

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agetxtField;
    private javax.swing.JTextField bmiTxtField;
    private javax.swing.JButton btnBrowze;
    private javax.swing.JButton btnFoodconsumption;
    private javax.swing.JButton btnLeave;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnVitalSign;
    private javax.swing.JButton btnWorkout;
    private javax.swing.JTextField calBurnThreshold;
    private javax.swing.JTextField calConsumptionTxtField;
    private javax.swing.JComboBox doctorCombo;
    private javax.swing.JTextField emailTxtField;
    private javax.swing.JTextField fileNameTxtField;
    private javax.swing.JComboBox<String> genderCombo;
    private javax.swing.JTextField htTxtField;
    private javax.swing.JLabel imageLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nameTxtField;
    private javax.swing.JComboBox networkCombo;
    private javax.swing.JCheckBox statsPermissionChkBox;
    private javax.swing.JComboBox superVisorCombo;
    private javax.swing.JTextField vaccBalance;
    private javax.swing.JTextField weighttxtField;
    // End of variables declaration//GEN-END:variables
}
