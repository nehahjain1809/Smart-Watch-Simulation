/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.WorkPlace.Holiday;
import java.util.ArrayList;

/**
 *
 * @author KRISH PRAVIN JAIN
 */
public class EcoSystem extends Organization  {
     private static EcoSystem business;
    private ArrayList<Network> networkList;
    private ArrayList<Holiday> holidayList;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<Network>();
        holidayList=new ArrayList<Holiday>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public static EcoSystem getBusiness() {
        return business;
    }

    public static void setBusiness(EcoSystem business) {
        EcoSystem.business = business;
    }

    public ArrayList<Holiday> getHolidayList() {
        return holidayList;
    }

    public void setHolidayList(ArrayList<Holiday> holidayList) {
        this.holidayList = holidayList;
    }

    

    
    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }
    
    public Holiday createAndAddHoliday() {
        Holiday holiday = new Holiday();
        holidayList.add(holiday);
        return holiday;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }

        for (Network network : networkList) {
        }

        return true;
    }
}
