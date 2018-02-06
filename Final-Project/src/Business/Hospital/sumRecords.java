/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author ankushdeora
 */
public class sumRecords {
    private HashMap<Date, HeartRecord> sumRecords;

    public sumRecords() {
        sumRecords = new HashMap<>();
    }

    
    public HashMap<Date, HeartRecord> getSumRecords() {
        return sumRecords;
    }

    public void setSumRecords(HashMap<Date, HeartRecord> sumRecords) {
        this.sumRecords = sumRecords;
    }
    
    public String toString(){
        return "Results";
    }

    public void setSumRecordsh(HashMap<Date, Integer> heartRecords) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
