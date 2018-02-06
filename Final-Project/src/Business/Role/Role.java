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
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author KRISH PRAVIN JAIN
 */
public abstract class Role {

//    public Component createWorkArea(JPanel userProcessContainer, UserAccount userAccount, Enterprise inEnterprise, Organization inOrganization, EcoSystem system, Network n) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    public enum RoleType{
        Admin("Admin"),
        Doctor("Doctor"),
        LabAssistant("Lab Assistant"),
        Person("Person"),
        Supervisor("Supervisor"),
        Customer("Customer"),
        TeamLeader("Team Leader");
        
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(
    JPanel userProcessContainer, 
    UserAccount userAccount, 
    Enterprise inEnterprise,
    Organization inOrganization, 
    EcoSystem system, 
    Network n);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}