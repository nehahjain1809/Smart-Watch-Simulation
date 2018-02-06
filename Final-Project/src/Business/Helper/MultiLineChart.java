/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Helper;

import Business.Person.Person;
import Business.Routine.FoodConsumptionTracker;
import Business.Routine.Sleep;
import Business.Routine.WorkOut;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author nehah
 */
public class MultiLineChart {
    Map<Person, ArrayList<Sleep>> map=new HashMap<Person, ArrayList<Sleep>>();
     Map<Person, ArrayList<FoodConsumptionTracker>> map1=new HashMap<Person, ArrayList<FoodConsumptionTracker>>();
      Map<Person, ArrayList<WorkOut>> map2=new HashMap<Person, ArrayList<WorkOut>>();
    String line_Chart_Demo_6;
   public  MultiLineChart(String line_Chart_Demo_6) {
    
        //super(title);
        this.map=map;
        this.line_Chart_Demo_6=line_Chart_Demo_6;
//        final XYDataset dataset = createDataset(map);
//        final JFreeChart chart = createChart(dataset);
//        final ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
//        setContentPane(chartPanel);

    }
 
   public XYDataset createDataset(Map<Person, ArrayList<Sleep>> map) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        for(Person p:map.keySet()){
            System.out.println(p.getPersonName()+ " "+ map.keySet().toString());
            XYSeries series = new XYSeries(p.getPersonName());
            for(Sleep s:p.getSleepTracker()){
                series.add(s.getDate().getDate(),s.getSleepHours());
                System.out.println(s.getDate().getDate()+" " +s.getSleepHours());
            }
           dataset.addSeries(series); 
        }
        
                
        return dataset;
        
    }
    
       public  XYDataset createDataset1(Map<Person, ArrayList<FoodConsumptionTracker>> map) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        for(Person p:map.keySet()){
            System.out.println(p.getPersonName()+ " "+ map.keySet().toString());
            XYSeries series = new XYSeries(p.getPersonName());
            for(FoodConsumptionTracker s:p.getFoodConsumptionTrackerList()){
                series.add(s.getDate().getDate(),s.getTotalcalories());
                System.out.println(s.getDate().getDate()+" " +s.getTotalcalories());
            }
           dataset.addSeries(series); 
        }
        
                
        return dataset;
        
    }
        
     public XYDataset createDataset2(Map<Person, ArrayList<WorkOut>> map) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        for(Person p:map.keySet()){
            System.out.println(p.getPersonName()+ " "+ map.keySet().toString());
            XYSeries series = new XYSeries(p.getPersonName());
            for(WorkOut s:p.getWorkOutList()){
                series.add(s.getDate().getDate(),s.getTotal_calories_burnt());
                System.out.println(s.getDate().getDate()+" " +s.getTotal_calories_burnt());
            }
           dataset.addSeries(series); 
        }
        
                
        return dataset;
        
    }
    
   public  JFreeChart createChart(XYDataset dataset) {
        
        // create the chart...
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Trends",      // chart title
            "Date",                      // x axis label
            line_Chart_Demo_6,                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        
        chart.setBackgroundPaint(Color.white);

        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
    
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
                
        return chart;
        
    }
}
