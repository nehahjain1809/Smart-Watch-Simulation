/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author ankushdeora
 */
public class WorkQueuePersonDoc {
    private ArrayList<WorkRequestPersonDoc> workRequestListPersonDoc;

    public WorkQueuePersonDoc() {
        this.workRequestListPersonDoc = new ArrayList<>();
    }

    
    
    public ArrayList<WorkRequestPersonDoc> getWorkRequestListPersonDoc() {
        return workRequestListPersonDoc;
    }

   
 
}
