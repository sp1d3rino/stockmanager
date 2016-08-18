/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author sp1d3r
 */
public class Utils {

    private static Utils _instance;

    public Utils() {

        _instance = this;
    }

    public static Utils getInstance() {

        if (_instance == null) {
            _instance = new Utils();
        }

        return _instance;
    }

    public void showErrorDialog(Component c, String msg, String title) {
        JOptionPane.showMessageDialog(c, msg,
                title,
                JOptionPane.ERROR_MESSAGE);

    }

    public boolean changeFieldBackground(Object o, boolean result) {

        if (o instanceof JTextField) {
            JTextField tf = (JTextField) o;
            if (tf.getText().isEmpty()) {
                tf.setBackground(Color.red);
                result = false;
            } else {
                tf.setBackground(Color.white);
            }
        } else if (o instanceof JFormattedTextField) {
            JFormattedTextField tf = (JFormattedTextField) o;
            if (tf.getText().isEmpty()) {
                tf.setBackground(Color.red);
                result = false;
            } else {
                tf.setBackground(Color.white);
            }

        }

        return result;
    }
    
    
    
    public ChartPanel createPieChart(String chartTitle,double total, double remain) {
        System.out.println("PieChart");
        PieDataset dataset = createPieDataset(total,remain);
        JFreeChart chart = createChart(dataset, chartTitle);
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

    private PieDataset createPieDataset(double total, double remain ) {
        System.out.println("PieDataset");
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Totale", 100-(remain*100/total));
        result.setValue("Residuo", remain*100/total);
        System.out.println("total: "+total+ " perc. residuo: "+remain*100/total);
        return result;

    }

    private JFreeChart createChart(PieDataset dataset, String title) {
        System.out.println("Create Chart");
        JFreeChart chart = ChartFactory.createPieChart3D(
                title, dataset, true, true, false);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
         plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        plot.setCircular(true);
        return chart;

    }
    
     
    public void createBarChart( JPanel panel , String chartTitle,double init,double remain )
   {
       
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "",            
         "",            
         createDataset(init,remain),          
         PlotOrientation.VERTICAL,           
         false, false, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 260 , 167 ) );
      
      panel.setLayout(new FlowLayout(FlowLayout.LEFT));

      panel.add(chartPanel);
   }
    
   private CategoryDataset createDataset(double init,double remain )
   {
      final String initQ = "Q. iniziale";        
      final String remainQ = "Q. residua";        
            

      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      dataset.addValue( init , initQ , initQ); 
      dataset.addValue( remain , remainQ , remainQ ); 
      
             

      return dataset; 
   }


}
