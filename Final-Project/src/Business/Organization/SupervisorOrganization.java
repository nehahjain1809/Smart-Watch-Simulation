/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.Role;
import Business.Role.SupervisorRole;
import java.util.ArrayList;

/**
 *
 * @author nehah
 */
public class SupervisorOrganization extends Organization {

    public SupervisorOrganization()
    {
        super(Organization.Type.Supervisor.getValue());
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Role> roles= new ArrayList<>();
        roles.add(new SupervisorRole());
        return roles;
    }
}
