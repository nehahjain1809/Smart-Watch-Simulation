/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author nehah
 */
public class CustomerEnterprise extends Enterprise{

    public CustomerEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.Customer);
    }

//    CustomerEnterprise(String name) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
    