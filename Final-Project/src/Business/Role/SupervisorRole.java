/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.Organization.SupervisorOrganization;
import Business.UserAccount.UserAccount;
import Interface.Hospital.Doctor.DoctorJPanel;
import Interface.Supervisor.SupervisorWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author nehah
 */
public class SupervisorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount userAccount, Enterprise inEnterprise, Organization inOrganization, EcoSystem system, Network n) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return new SupervisorWorkArea(userProcessContainer, userAccount, (SupervisorOrganization)inOrganization,inEnterprise,system,n);
    }
    
}
