/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Hospital.LabAssistant;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Hospital.Appointment;
import Business.Hospital.Doctor;
import Business.Hospital.LabAssistant;
import Business.Network.Network;
import Business.Organization.CustomerOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequestPersonDoc;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
/**
 *
 * @author KRISH PRAVIN JAIN
 */
public class LabAssistantJPanel extends javax.swing.JPanel {

    /**
     * Creates new form LabAssistantJPanel
     */
   
    JPanel userProcessContainer;
    UserAccount userAccount;
    LabOrganization labOrganization;
    Enterprise inEnterprise;
    EcoSystem system;
    Network n;
    private static String appointmentEmailSubject="Appointment notifcation email for:";
    public LabAssistantJPanel(JPanel userProcessContainer, UserAccount userAccount, LabOrganization labOrganization, Enterprise inEnterprise, EcoSystem system, Network n) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.userAccount=userAccount;
        this.system=system;
        this.n=n;
        this.inEnterprise=inEnterprise;
        this.labOrganization=labOrganization;
        
        populateRequestTable();
    }

    public void populateRequestTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblRequest.getModel();
        dtm.setRowCount(0);
        System.out.println("populateRequestTable1");
        for(WorkRequestPersonDoc request : labOrganization.getWorkQueuePersonDoc().getWorkRequestListPersonDoc()){
                System.out.println("populateRequestTable");
//                System.out.println("doctor username: "+request.getDoctor().getUserAccount());
                Object row[] = new Object[5];
                row[0] = request.getPerson();
                row[1] = request.getReqDate();
                row[2] = request;
                row[3] = request.getDoctor();
                row[4] = request.getAppappointmentDate();
                dtm.addRow(row);
            
        }
    }
    
    public void sendEmail(Person p, Appointment a) throws MessagingException{
        String from = labOrganization.getLabAssistantDirectory().searchAssistantbyUserName(userAccount.getUsername()).getEmailId().toString();
        String password = labOrganization.getLabAssistantDirectory().searchAssistantbyUserName(userAccount.getUsername()).getPwd();
        String[] to =     {p.getEmailId()};
        String subject = appointmentEmailSubject+" "+p.getPersonName();
        String body = "Hi "+p.getPersonName()+","+ "\n This email is to inform you that your appointment with your doctor " +
                a.getDoctor()+" has been booked for "+
                a.getAppointmentDate()+". Please let us know in case of any changes required. \n Thanking you, \n"+userAccount.getUsername();

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
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        btnSetAp = new javax.swing.JButton();
        emailIdText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pwd = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lab Assistant Work Area");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Flagged Vital Signs");

        tblRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person", "Date", "Message", "Doctor", "Appointment Date"
            }
        ));
        jScrollPane1.setViewportView(tblRequest);

        btnSetAp.setText("Set Appointment>>");
        btnSetAp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetApActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Configure my Email");

        jButton1.setText("Save");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(emailIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(859, 859, 859))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSetAp, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnSetAp)
                .addGap(175, 175, 175))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetApActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetApActionPerformed
        // TODO add your handling code here:
        //int selectedRow=0;
        //write code to get selected row from table;
        Person p=null;
        Appointment appointment = null;
//        for(Enterprise ent:n.getEnterpriseDirectory().getEnterpriseList()){
//            if(ent instanceof HospitalEnterprise){
//               for(Organization org:ent.getOrganizationDirectory().getOrganizationList()){
//                   if(org instanceof CustomerOrganization){
//                       p=org.getPersonDirectory().findPersonByPersonName(tblRequest.getValueAt(selectedRow, 0).toString());
//                   }
//               } 
//            }
//            
//        }
        
        int selectedRow = tblRequest.getSelectedRow();
        if(selectedRow >= 0){
            p = (Person) tblRequest.getValueAt(selectedRow, 0);
            Doctor d = (Doctor) tblRequest.getValueAt(selectedRow, 3);
            WorkRequestPersonDoc request = (WorkRequestPersonDoc) tblRequest.getValueAt(selectedRow, 2);
            appointment = d.getAppointmentList().addAppointment();
            appointment.setDoctor(d);
            appointment.setPatientName(p.toString());
            appointment.setAppointmentDate(jDateChooser1.getDate());
            request.setAppappointmentDate(jDateChooser1.getDate());
            System.out.println("app date set: "+request.getAppappointmentDate());
        }
        
        //Appointment appointment=labOrganization.getAppointmentDirectory().addAppointment();
        //set appointment attributes start
            //
        //set appointment attributes end
        try {
            //Send email after appoinment is set
            sendEmail(p, appointment);
        } catch (MessagingException ex) {
            Logger.getLogger(LabAssistantJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSetApActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LabAssistant l=labOrganization.getLabAssistantDirectory().searchAssistantbyUserName(userAccount.getUsername());
        l.setEmailId(emailIdText.getText());
        l.setPwd(pwd.getText());
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSetAp;
    private javax.swing.JTextField emailIdText;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pwd;
    private javax.swing.JTable tblRequest;
    // End of variables declaration//GEN-END:variables
}
