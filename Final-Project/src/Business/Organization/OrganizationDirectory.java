/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author KRISH PRAVIN JAIN
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
//    public Organization createOrganization(Organization.Type type){
//        Organization organization = null;
//        if (type.getValue().equals(Organization.Type.Doctor.getValue())){
//           organization = new DoctorOrganization();
//            organizationList.add(organization);
//        }
//        else if (type.getValue().equals(Organization.Type.Lab.getValue())){
//            //organization = new LabOrganization();
//            organizationList.add(organization);
//        }
//        return organization;
//    }
    
    public Organization createOrganization(Organization.Type type){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.Doctor.getValue())){
           organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Lab.getValue())){
            organization = new LabOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Supervisor.getValue())){
            organization = new SupervisorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.TeamLeader.getValue())){
            organization = new TeamLeaderOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Customer.getValue())){
            organization = new CustomerOrganization();
            organizationList.add(organization);
        }
        
       return organization;
    }
}
