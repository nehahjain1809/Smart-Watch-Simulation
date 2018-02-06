
package Interface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Hospital.Appointment;
import Business.Hospital.AppointmentDirectory;
import Business.Hospital.Doctor;
import Business.Hospital.DoctorDirectory;
import Business.Hospital.LabAssistant;
import Business.Hospital.VitalSigns;
import Business.Hospital.VitalSignsDirectoryy;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Recommendations.RecommendationDirectory;
import Business.Routine.FoodConsumptionTracker;
import Business.Routine.FoodConsumptionTrackerDirectory;
import Business.Routine.Sleep;
import Business.Routine.SleepDirectory;
import Business.Routine.WorkOut;
import Business.Routine.WorkOutDirectory;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkPlace.Holiday;
import Business.WorkPlace.HolidayList;
import Business.WorkPlace.LeaveRequestHistory;
import Business.WorkPlace.MyVacation;
import Business.WorkPlace.MyVaccationHistory;
import Business.WorkPlace.SupervisorDirectory;
import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author KRISH PRAVIN JAIN
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

   JPanel userProcessContainer;
    private static EcoSystem system;
    private static final String DATA_FILES_HOME = "./data/";
    private static final String DELIMITER = ",";
    private static final String HOLIDAY_FILE_NAME="Holiday.csv";
    private ArrayList<Holiday> holidayList;

    private static final String APPOINTMENT_FILE_NAME = "Appointment.csv";
    private static final String FOODCONSUMPTION_FILE_NAME = "FoodConsumption.csv";
    //private static final String HOLIDAY_FILE_NAME="Holiday.csv";
    private static final String LEAVEDATA_NAME="LeaveData.csv";
    private static final String LEAVEREQUESTS_FILE_NAME="LeaveRequests.csv";
    //private static final String PERSON_NAME="Person.csv";
    private static final String SLEEP_FILE_NAME="Sleep.csv";
    //private static final String SUPERVISOR_SCHEDULE_FILE_NAME="Supervisor.csv";
   // private static final String USERRACCOUNT_FILE_NAME="UserAccount.csv";
    private static final String VACATION_FILE_NAME="Vacation.csv";
    private static final String VITALSIGNS_SCHEDULE_FILE_NAME="VitalSigns.csv";
    private static final String WORKOUT_SCHEDULE_FILE_NAME="WorkOut.csv";
   // private static final String DATA_FILES_HOME = "C:/Users/nehah/Documents/NetBeansProjects/AED-Final-Project/data/";
    //private static final String DELIMITER = ",";
    //private EcoSystem system;
    
    private static DoctorDirectory doctorList;
    private static UserAccountDirectory uad;
    private static PersonDirectory personList;
    private static SupervisorDirectory supervisorList;
    private static MyVaccationHistory leaveList;
    private static AppointmentDirectory appointmentDirectory;
    private static SleepDirectory sleepDirectory;
    private static FoodConsumptionTrackerDirectory foodTracker;
    private static VitalSignsDirectoryy vitalSignList;
    private static LeaveRequestHistory leaveRequestDirectory;
    private static RecommendationDirectory recommmendationDirectory;
    private static WorkOutDirectory workoutDirectory;
   /**
     * Creates new form AdminWorkAreaJPanel
     */
    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        holidayList=system.getHolidayList();
        populateTree();
        doctorList=system.getDoctorDirectory();
        personList=system.getPersonDirectory();
        supervisorList=system.getSupervisorDirectory();
        
        
    }
    public void populateTree() {
        
        DefaultTreeModel model = (DefaultTreeModel) JTree.getModel();

        
        
        ArrayList<Network> networkList = system.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;
        ArrayList<Holiday> holidayList=system.getHolidayList();
        Network network;
        Enterprise enterprise;
        Holiday holiday;
        Organization organization;

        DefaultMutableTreeNode networks = new DefaultMutableTreeNode("Networks");
        DefaultMutableTreeNode holidays = new DefaultMutableTreeNode("Holidays");
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();
        root.insert(networks, 0);
        root.insert(holidays, 1);
        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
         DefaultMutableTreeNode holidayNode;
        
        for (int i = 0; i < networkList.size(); i++) {
            network = networkList.get(i);
            networkNode = new DefaultMutableTreeNode(network.getName());
            networks.insert(networkNode, i);

            enterpriseList = network.getEnterpriseDirectory().getEnterpriseList();

            for (int j = 0; j < enterpriseList.size(); j++) {
                enterprise = enterpriseList.get(j);
                enterpriseNode = new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);

                organizationList = enterprise.getOrganizationDirectory().getOrganizationList();
                for (int k = 0; k < organizationList.size(); k++) {
                    organization = organizationList.get(k);
                    organizationNode = new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);
                }
            }
        }
            for(int i=0; i<holidayList.size();i++){
                holiday = holidayList.get(i);
                holidayNode = new DefaultMutableTreeNode(holiday.getDatetime());
                holidays.insert(holidayNode, i);
            }
        

        model.reload();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        manageNetworkJButton = new javax.swing.JButton();
        manageAdminJButton = new javax.swing.JButton();
        manageEnterpriseJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        selectedNodeJLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTree = new javax.swing.JTree();

        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(150);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageNetworkJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        manageNetworkJButton.setText("Manage Network");
        manageNetworkJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageNetworkJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(manageNetworkJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 215, -1));

        manageAdminJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        manageAdminJButton.setText("Manage Enterprise Admin");
        manageAdminJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAdminJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(manageAdminJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 220, -1));

        manageEnterpriseJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        manageEnterpriseJButton.setText("Manage Enterprise");
        manageEnterpriseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEnterpriseJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(manageEnterpriseJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 215, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Selected Node:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        selectedNodeJLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        selectedNodeJLabel.setForeground(new java.awt.Color(255, 255, 255));
        selectedNodeJLabel.setText("<view_selected_node>");
        jPanel1.add(selectedNodeJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Upload holiday Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 220, -1));

        jSplitPane1.setRightComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("System");
        JTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        JTree.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                valueChangedAction(evt);
            }
        });
        jScrollPane1.setViewportView(JTree);

        jPanel2.add(jScrollPane1);

        jSplitPane1.setLeftComponent(jPanel2);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void manageEnterpriseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEnterpriseJButtonActionPerformed

        ManageEnterpriseJPanel manageEnterpriseJPanel = new ManageEnterpriseJPanel(userProcessContainer, system);
        userProcessContainer.add("manageEnterpriseJPanel", manageEnterpriseJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEnterpriseJButtonActionPerformed

    private void manageAdminJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAdminJButtonActionPerformed
        // TODO add your handling code here:
        ManageEnterpriseAdminJPanel manageEnterpriseAdminJPanel = new ManageEnterpriseAdminJPanel(userProcessContainer, system);
        userProcessContainer.add("manageEnterpriseAdminJPanel", manageEnterpriseAdminJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageAdminJButtonActionPerformed

    private void manageNetworkJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageNetworkJButtonActionPerformed
        ManageNetworkJPanel manageNetworkJPanel = new ManageNetworkJPanel(userProcessContainer, system);
        userProcessContainer.add("manageNetworkJPanel", manageNetworkJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageNetworkJButtonActionPerformed

    private void valueChangedAction(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_valueChangedAction
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) JTree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            selectedNodeJLabel.setText(selectedNode.toString());
        }

    }//GEN-LAST:event_valueChangedAction

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                
        Set<Holiday> holiday = parseHolidayData(loadDataFromCsvFile(DATA_FILES_HOME + HOLIDAY_FILE_NAME));
        System.out.println("Holiday Signs  data loaded..");
        
    }//GEN-LAST:event_jButton1ActionPerformed
private  Set<Holiday> parseHolidayData(Collection<String []> holidayData)
    {
        Set<Holiday> holidays = new HashSet<>();
        for (String[] holidayDataRow : holidayData) {
            Holiday holiday=new Holiday();
            SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
            try{
            Date holidayDate = (Date)sdf.parse(holidayDataRow[1]);
            holiday.setDatetime((holidayDate));

           }
            catch(Exception e){
                System.out.print(e);
            }
            holiday.setCountry(holidayDataRow[0]);
            holidays.add(holiday);
            holidayList.add(holiday);
            
       }
        
        for(Holiday h:holidayList){
            System.out.println(h.getDatetime());
        }
        
       return holidays;
    }

private static Collection<String []> loadDataFromCsvFile(String filePath)
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
    public void LoadData(){
        
        Set<VitalSigns> vitalSignses = parseVitalSignData(loadDataFromCsvFile(DATA_FILES_HOME + VITALSIGNS_SCHEDULE_FILE_NAME));
        System.out.println("Vital Signs  data loaded..");
        
//        Set<Appointment> appointments = parseAppointmentData(loadDataFromCsvFile(DATA_FILES_HOME + APPOINTMENT_FILE_NAME));
//        System.out.println("Appointment data loaded..");
        
        Set<FoodConsumptionTracker> foodConsumptionTrackers = parseFoodConsumptionData(loadDataFromCsvFile(DATA_FILES_HOME + FOODCONSUMPTION_FILE_NAME));
        System.out.println("Food Consumption data loaded..");
        
        
        Set<Sleep> sleeps = parseSleepData(loadDataFromCsvFile(DATA_FILES_HOME + SLEEP_FILE_NAME));
        System.out.println("SLeep data loaded..");
        
        Set<MyVacation> vaccations = parseMyVacationtData(loadDataFromCsvFile(DATA_FILES_HOME + VACATION_FILE_NAME));
        System.out.println("Vaccation data loaded..");
        
        Set<WorkOut> workOuts = parseWorkOutData(loadDataFromCsvFile(DATA_FILES_HOME + WORKOUT_SCHEDULE_FILE_NAME));
        System.out.println("Workout data loaded..");
        
 
    }
    
    
//    private static Set<Appointment> parseAppointmentData(Collection<String []> appointmentData) 
//    {
//        Set<Appointment> appointments = new HashSet<>();
//        for (String[] appointmentDataRow : appointmentData) {
//           for(Person p:system.getPersonDirectory().getPersonList()){
//               if(appointmentDataRow[2].toString().equals(p.getAccount().getUsername())){
//               Appointment appointment=new Appointment();
//               SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
//            try{
//                Date appointmentDate = (Date)sdf.parse(appointmentDataRow[0]); 
//                appointment.setAppointmentDate(appointmentDate);
//                }
//            catch(Exception e){
//                    System.out.print(e);
//                }
//            
//            appointment.setPatientName(appointmentDataRow[1]);
//            appointment.setPatientUserName(appointmentDataRow[2]);
//            appointment.setDoctorName(appointmentDataRow[3]);
//            appointment.setDoctorUserName(appointmentDataRow[4]);
//            appointment.setLabAssistantName(appointmentDataRow[5]);
//            appointment.setLabAssistantUserName(appointmentDataRow[6]);
//            appointment.setAppointmentReason(appointmentDataRow[7]);
//            String personUserName=appointment.getPatientUserName();
//            String doctorUserName=appointment.getDoctorUserName();
//            //System.out.println(personUserName);
//           // Person p=personList.findPersonByUserName(personUserName);
//           
//            Doctor d=doctorList.searchDoctorbyUserName(doctorUserName);
//            appointments.add(appointment);
////            appointmentDirectory.getAppointmentList().add(appointment);
//            p.getAppointmentList().add(appointment);
//            d.getAppointmentList().add(appointment);
//            
//            
//        }
//           }
//           for(Appointment a:appointments){
//               System.out.println( a.getPatientUserName()+' '+a.getDoctorName());
//           }
//        
//        }
//        return appointments;
//    }
//   

    private static Set<FoodConsumptionTracker> parseFoodConsumptionData(Collection<String []> foodConsumptionData) 
    {
        Set<FoodConsumptionTracker> foodConsumptions = new HashSet<>();
        for (String[] fcDataRow : foodConsumptionData) {
          
        }
        return foodConsumptions;
    }
   
private static Set<Sleep> parseSleepData(Collection<String []> sleepData) 
    {
        Set<Sleep> sleeps = new HashSet<>();
        for (String[] sleepDataRow : sleepData) {
            
        }
        return sleeps;
    }
   
 private static Set<MyVacation> parseMyVacationtData(Collection<String []> vacationData) 
    {
        Set<MyVacation> vacations = new HashSet<>();
        for (String[] vacationDataDataRow : vacationData) {
           
        }
        return vacations;
    }
     
    private static Set<VitalSigns> parseVitalSignData(Collection<String []> vitalSignsData) 
    {
        Set<VitalSigns> vitalSigns = new HashSet<>();
        for (String[] vitalSignDataDataRow : vitalSignsData) {
           
        }
        return vitalSigns;
    } 
    
        private static Set<WorkOut> parseWorkOutData(Collection<String []> workOutData) 
    {
        Set<WorkOut> workOuts = new HashSet<>();
        for (String[] workOutDataDataRow : workOutData) {
          
        }
        return workOuts;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree JTree;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton manageAdminJButton;
    private javax.swing.JButton manageEnterpriseJButton;
    private javax.swing.JButton manageNetworkJButton;
    private javax.swing.JLabel selectedNodeJLabel;
    // End of variables declaration//GEN-END:variables
}
