/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Helper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author nehah
 */
public class GraphHelper {
//    private HashMap<Date, Float> sleephours;
//    private HashMap<Date, Float> foodConsumption;
//    private HashMap<Date, Float> workOut;
    private Map<Date, Float> sortedMap;
     private Map<Integer, Integer> sortedMap2;
     private  Map<String, Float> sortedMap3;
     private  Map<Date, Float> sortedMap4;
      private  Map<String, Float> sortedMap5;
      private  Map<Date, Integer> sortedMap6;
     
    public GraphHelper(){
//        sleephours=new HashMap<>();
//        foodConsumption=new HashMap<>();
//        workOut=new HashMap<>(); 
    }
    
    
    
    public JFreeChart showChart(HashMap<Date, Float> map){
        
                
                XYDataset ds = createDataset();
                DefaultCategoryDataset ds1 = new DefaultCategoryDataset();
                
                
                sortedMap = new TreeMap<>(map);
                for(Date d  : sortedMap.keySet()){
                    double h = map.get(d);
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    
                    ds1.setValue(h, "", sdf.format(d));
                }
                
                //DefaultHighLowDataset ds1 = new DefaultHighLowDataset("", new Date, 50, 100, 1.0, 110.0, 34.0);
                //JFreeChart chart = ChartFactory.createXYLineChart("", "x", "y", ds1, PlotOrientation.VERTICAL, true, true, true);
                JFreeChart chart = ChartFactory.createLineChart("", "x", "y", ds1, PlotOrientation.VERTICAL, true, true, true);
                //JFreeChart chart = ChartFactory.create
                //ChartPanel cp = new ChartPanel(chart);
                
                //frame.getContentPane().add(cp);
                return chart;
           
    }
    
    public JFreeChart showChart2(Map<Integer, Integer> map){
        
                
                XYDataset ds = createDataset();
                DefaultCategoryDataset ds1 = new DefaultCategoryDataset();
                
                
                sortedMap2 = new TreeMap<>(map);
                for(Integer d  : sortedMap2.keySet()){
                    Integer h = map.get(d);
                   // SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    
                    ds1.setValue(h, "", d);
                }
                
                //DefaultHighLowDataset ds1 = new DefaultHighLowDataset("", new Date, 50, 100, 1.0, 110.0, 34.0);
                //JFreeChart chart = ChartFactory.createXYLineChart("", "x", "y", ds1, PlotOrientation.VERTICAL, true, true, true);
                JFreeChart chart = ChartFactory.createBarChart("Leave Trends", "Months", "Number of Leaves", ds1, PlotOrientation.VERTICAL, true, true, true);
                //JFreeChart chart = ChartFactory.create
                //ChartPanel cp = new ChartPanel(chart);
                
                //frame.getContentPane().add(cp);
                return chart;
           
    }
    
    
    public JFreeChart showChart3(Map<String, Float> map){
        
                
                XYDataset ds = createDataset();
                DefaultCategoryDataset ds1 = new DefaultCategoryDataset();
                
                
                sortedMap3 = new TreeMap<>(map);
                for(String s  : sortedMap3.keySet()){
                    Float h = map.get(s);
                   // SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    
                    ds1.setValue(h, "", s);
                }
                
                //DefaultHighLowDataset ds1 = new DefaultHighLowDataset("", new Date, 50, 100, 1.0, 110.0, 34.0);
                //JFreeChart chart = ChartFactory.createXYLineChart("", "x", "y", ds1, PlotOrientation.VERTICAL, true, true, true);
                JFreeChart chart = ChartFactory.createBarChart("Today's Work Schedule", "Action", "Hours", ds1, PlotOrientation.VERTICAL, true, true, true);
                //JFreeChart chart = ChartFactory.create
                //ChartPanel cp = new ChartPanel(chart);
                
                //frame.getContentPane().add(cp);
                return chart;
           
    }
    
      public JFreeChart showChart4(Map<Date, Float> map){
        
                
                XYDataset ds = createDataset();
                DefaultCategoryDataset ds1 = new DefaultCategoryDataset();
                
                
                sortedMap4 = new TreeMap<>(map);
                for(Date s  : sortedMap4.keySet()){
                    Float h = map.get(s);
                   // SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    
                    ds1.setValue(h, "", s);
                }
                //JFreeChart chart = ChartFactory.crea("Work Schedule Trend", "Date", "Office Hours", ds1, PlotOrientation.VERTICAL, true, true, true);
                
                JFreeChart chart = ChartFactory.createBarChart("Work Schedule Trend", "Date", "Office Hours", ds1, PlotOrientation.VERTICAL, true, true, true);
                
                return chart;
           
    }
    

    
    public ArrayList<JFreeChart> showChart5(Map<String, Float> map1,Map<String, Float> map2,Map<String, Float> map3){
        
                
                XYDataset ds = createDataset();
               
                DefaultCategoryDataset ds1 = new DefaultCategoryDataset();
                DefaultCategoryDataset ds2 = new DefaultCategoryDataset();
                DefaultCategoryDataset ds3 = new DefaultCategoryDataset();
                
                sortedMap5 = new TreeMap<>(map1);
                for(String s  : sortedMap5.keySet()){
                    Float h = map1.get(s);
                    ds1.setValue(h, "", s);
                }
                sortedMap5 = new TreeMap<>(map2);
                for(String s  : sortedMap5.keySet()){
                    Float h = map2.get(s);
                    ds2.setValue(h, "", s);
                }
                sortedMap5 = new TreeMap<>(map3);
                for(String s  : sortedMap5.keySet()){
                    Float h = map3.get(s);
                    ds3.setValue(h, "", s);
                }
                ArrayList<JFreeChart> abc=new ArrayList<>();
                JFreeChart chart1 = ChartFactory.createBarChart("Work Out Trend", "Date", "Calories Burnt", ds1, PlotOrientation.VERTICAL, true, true, true);
                JFreeChart chart2 = ChartFactory.createBarChart("Work Out Trend", "Date", "Calories Burnt", ds2, PlotOrientation.VERTICAL, true, true, true);
                JFreeChart chart3 = ChartFactory.createBarChart("Work Out Trend", "Date", "Calories Burnt", ds3, PlotOrientation.VERTICAL, true, true, true);
               
                
                abc.add(chart1);
                abc.add(chart2);
                abc.add(chart3);
                
                return abc;
           
    }
    
    
        private static XYDataset createDataset(){
        DefaultXYDataset  ds = new DefaultXYDataset();
        
        
        return ds;
    }
    
        
    public JFreeChart showChart5(Map<Date, Integer> map){
        
                
                XYDataset ds = createDataset();
                DefaultCategoryDataset ds1 = new DefaultCategoryDataset();
                
                
                sortedMap6 = new TreeMap<>(map);
                for(Date s  : sortedMap6.keySet()){
                    Integer h = map.get(s);
                   // SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    
                    ds1.setValue(h, "", s);
                }
                
                JFreeChart chart = ChartFactory.createBarChart("Work Progress", "Date", "Percentage", ds1, PlotOrientation.VERTICAL, true, true, true);
                
                return chart;
           
    }
    
}

