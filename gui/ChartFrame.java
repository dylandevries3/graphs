//ChartFrame.java
package gui; 
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import proj2.Graphs;
import framework.CChart; 

import framework.CChart; 

public class ChartFrame extends JFrame { 

    public static String DEFAULT_TITLE = "Add Your Chart"; 
    public static int DEFAULT_WIDTH = 300; 
    public static int DEFAULT_HEIGHT = 300; 
    private ChartPanel chartPanel; 
    private String chartTitle; 
    private String selected_file;

    //default window
    public ChartFrame() { 
        super(DEFAULT_TITLE); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.add(new ChartPanel()); 
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT); 
        this.setVisible(true); 
    } 

    //window for graphs 
    public ChartFrame(String chartTitle, CChart aChart) { 
        super(chartTitle); 
        this.chartPanel = new ChartPanel(aChart); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.add(new ChartPanel(aChart)); 
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT); 
        this.setVisible(true); 
    } 

    //main default window
    public ChartFrame(String chartTitle){

        //setting chart title
        super(chartTitle); 

        //creating buttons
        JButton Generate_button = new JButton("Generate");
        JButton Choose_button = new JButton("Choose File");

        //genertate button will graph the file
        Generate_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                proj2.Graphs.graph(selected_file);
            }
        });

        //choose button will select file
        Choose_button.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    int returnValue = fileChooser.showOpenDialog(null);
                    if (returnValue == JFileChooser.APPROVE_OPTION)
                    {
                        File selectedFile = fileChooser.getSelectedFile();
                        selected_file = selectedFile.getName();
                    }
                }
        });

        //creating panel
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,1));

        //add buttons to panel
        panel.add(Choose_button);
        panel.add(Generate_button);

        //add panel to frame
        this.add(panel, BorderLayout.CENTER);

        //frame stuff
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setSize(500, 300);
        this.setVisible(true); 
    }

} 