//ChartPanel.java
package gui; 

import java.awt.Color; 
import java.awt.Graphics; 
import javax.swing.JPanel; 
import framework.CChart; 

public class ChartPanel extends JPanel { 

    private CChart theChart; 

    public ChartPanel(CChart aChart) { 
        setBackground(Color.WHITE); 
        this.theChart = aChart; 
    } 

    //abstract constructor
    public ChartPanel() { 
    } 

    public void paintComponent(Graphics g) { 
        super.paintComponent(g); 
        theChart.draw(g); 
    } 
} 