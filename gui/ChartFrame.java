//ChartFrame.java
package gui; 

import javax.swing.JFrame; 
import framework.CChart; 

public class ChartFrame extends JFrame { 

    public static String DEFAULT_TITLE = "Add Your Chart"; 
    public static int DEFAULT_WIDTH = 300; 
    public static int DEFAULT_HEIGHT = 300; 
    private ChartPanel chartPanel; 
    private String chartTitle; 

    // Creates a window with a blank chart panel and default settings, such 
    // as size and title 
    public ChartFrame() { 
        super(DEFAULT_TITLE); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.add(new ChartPanel()); 
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT); 
        this.setVisible(true); 
    } 

    // Allows for a custom title and prepared chart 
    public ChartFrame(String chartTitle, CChart aChart) { 
        super(chartTitle); 
        this.chartPanel = new ChartPanel(aChart); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.add(new ChartPanel(aChart)); 
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT); 
        this.setVisible(true); 
    } 

    // May further be overloaded for size as needed... 
    // May be extended to add control for, like data source and chart type  
} 