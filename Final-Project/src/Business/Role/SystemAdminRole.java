/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Interface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author KRISH PRAVIN JAIN
 */
public class SystemAdminRole extends Role{

    @Override
//    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
//        return new SystemAdminWorkAreaJPanel(userProcessContainer, system);
//    }

    //@Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount userAccount, Enterprise inEnterprise, Organization inOrganization, EcoSystem system, Network n) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return new SystemAdminWorkAreaJPanel(userProcessContainer, system);
    }
    
}