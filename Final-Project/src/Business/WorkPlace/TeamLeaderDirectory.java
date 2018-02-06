/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkPlace;

import java.util.ArrayList;

/**
 *
 * @author nehah
 */
public class TeamLeaderDirectory {
      private ArrayList<TeamLeader> teamleaderList;
    
    public TeamLeaderDirectory(){
        teamleaderList=new ArrayList<TeamLeader>();
    }

    public ArrayList<TeamLeader> getTeamleaderList() {
        return teamleaderList;
    }

    public void setTeamleaderList(ArrayList<TeamLeader> teamleaderList) {
        this.teamleaderList = teamleaderList;
    }

    public TeamLeader findTeamLeaderByUserName(String username){
        for(TeamLeader t : teamleaderList){
            if(t.getUseraccount().getUsername().equals(username)){
              
            return t;
            }
        }
        return null;
    }
    
    public TeamLeader addTeamLeader()
    {
        TeamLeader t = new TeamLeader();
        teamleaderList.add(t);
        return t;
    }
}
