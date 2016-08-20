/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
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
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author sp1d3r
 */
public class Utils {

    
    public HashMap<String,String> SettingsFile=null;
    private static final File configFile = new File("config.properties");
    private static Utils _instance;
    public static final String CHART_SETTING = "CHART_SETTING";
    public static final String ITEM_WINDOW_OPENED_SETTING = "ITEM_WINDOW_OPENED_SETTING";
    public static final String MEASURE_WINDOW_OPENED_SETTING = "MEASURE_WINDOW_OPENED_SETTING";
    public static final String CATEGORY_WINDOW_OPENED_SETTING = "CATEGORY_WINDOW_OPENED_SETTING";
    
    
    public Utils() {

        _instance = this;
        

        
    }

    public static Utils getInstance() {

        if (_instance == null) {
            _instance = new Utils();
        }

        return _instance;
    }

    
    
    public void loadSettings() throws FileNotFoundException, IOException {
        // init settings HashMap
        SettingsFile =  new HashMap<String, String>();

        
        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);
             Enumeration e = props.propertyNames();
             while (e.hasMoreElements()){
                 String key = (String) e.nextElement();
                 SettingsFile.put(key,props.getProperty(key));
             }

            reader.close();
        } catch (FileNotFoundException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        }
         
    }

    public void saveSettings() throws FileNotFoundException, IOException {

        try {
            Properties props = new Properties();
            for(String k:SettingsFile.keySet())
                props.setProperty(k, SettingsFile.get(k));
            FileWriter writer = new FileWriter(configFile);
            props.store(writer,"program settings");
            writer.close();
        } catch (FileNotFoundException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        }
    }

    public void showErrorDialog(Component c, String msg, String title) {
        JOptionPane.showMessageDialog(c, msg,
                title,
                JOptionPane.ERROR_MESSAGE);

    }

    public int showYesNoDialog(Component c, String msg, String title) {
        return JOptionPane.showConfirmDialog(c, msg, title, JOptionPane.YES_NO_OPTION);

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

        } else if (o instanceof JComboBox) {
            JComboBox tf = (JComboBox) o;
            if (tf.getSelectedItem() == null) {
                tf.setBackground(Color.red);
                result = false;
            } else {
                tf.setBackground(Color.white);
            }
        }

        return result;
    }

    /**
     *
     * @param PieChart
     * @param total
     * @param remain
     * @return
     */
    public ChartPanel createPieChart(String chartTitle, double total, double remain) {
        System.out.println("PieChart");
        PieDataset dataset = createPieDataset(total, remain);
        JFreeChart chart = createChart(dataset, chartTitle);
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

    private PieDataset createPieDataset(double total, double remain) {
        System.out.println("PieDataset");
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Totale", 100 - (remain * 100 / total));
        result.setValue("Residuo", remain * 100 / total);
        System.out.println("total: " + total + " perc. residuo: " + remain * 100 / total);
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

    /**
     *
     * @param BarChart
     * @param chartTitle
     * @param init
     * @param remain
     */
    public void createBarChart(JPanel panel, String chartTitle, double init, double remain) {

        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "",
                "",
                createBarDataset(init, remain),
                PlotOrientation.VERTICAL,
                false, false, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(260, 167));

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel.add(chartPanel);
    }

    private CategoryDataset createBarDataset(double init, double remain) {
        final String initQ = "Q. iniziale";
        final String remainQ = "Q. residua";

        final DefaultCategoryDataset dataset
                = new DefaultCategoryDataset();

        dataset.addValue(init, initQ, initQ);
        dataset.addValue(remain, remainQ, remainQ);

        return dataset;
    }

    /**
     * TimeSeries Chart
     */
    public void createTSChart(JPanel panel, String title, HashMap<java.util.Date, Double> dset) {
        XYDataset dataset = createTSDataset(dset);
        JFreeChart chart = createTSChart(title, dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chart.setBackgroundPaint(panel.getBackground());
        chartPanel.setPreferredSize(panel.getPreferredSize());

        chartPanel.setMouseZoomable(true, false);
        panel.add(chartPanel);
        chartPanel.updateUI();

    }

    private XYDataset createTSDataset(HashMap<java.util.Date, Double> dset) {
        final TimeSeries series = new TimeSeries("Andamento");

        for (java.util.Date d : dset.keySet()) {
            try {
                series.add(new Day(d), (Double) dset.get(d));
            } catch (SeriesException e) {
                System.err.println("Error adding to series");
            }
        }

        return new TimeSeriesCollection(series);
    }

    private JFreeChart createTSChart(String title, final XYDataset dataset) {
        return ChartFactory.createTimeSeriesChart(
                title,
                "Data",
                "Uscite",
                dataset,
                false,
                false,
                false);
    }

}
