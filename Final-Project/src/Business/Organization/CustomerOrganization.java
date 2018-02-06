/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package Business.Organization;

import Business.Role.CustomerRole;
import Business.Role.Role;
import Business.Role.TeamLeaderRole;
import java.util.ArrayList;

/**
 *
 * @author KRISH PRAVIN JAIN
 */
public class CustomerOrganization extends Organization {

   public CustomerOrganization()
    {
        super(Organization.Type.Customer.getValue());
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Role> roles= new ArrayList<>();
        roles.add(new CustomerRole());
        return roles;
    }
    
}