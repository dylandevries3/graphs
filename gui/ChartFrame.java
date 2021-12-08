//ChartFrame.java
package gui; 
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
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
    private String selected_file = "";

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
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        this.add(new ChartPanel(aChart)); 
        this.setVisible(true); 
        this.setSize(300, 300); 
    } 

    //main default window
    public ChartFrame(String chartTitle){

        //setting chart title
        super(chartTitle); 
        
        
        //creating buttons
        JButton Generate_button = new JButton("Generate");

        JLabel Choose_label = new JLabel("Choose File: ");
        JLabel Graph_label = new JLabel("Choose Graph Type: ");
        JLabel Title_label = new JLabel("Enter Graph Title: ");
        JButton Choose_button = new JButton("Choose File");
        JTextField Text_field = new JTextField();
        JLabel Error_Label = new JLabel("Must Select File to generate graph!", JLabel.CENTER);
        Error_Label.setForeground(Color.red);

        Text_field.setPreferredSize(new Dimension(100, 25));
        Choose_button.setPreferredSize(new Dimension(100, 25));

        //create combo box
        String choices[] = {"Line", "Scatter", "Bar"};
        JComboBox combo = new JComboBox(choices);
        combo.setPreferredSize(new Dimension(100, 25));
        //genertate button will graph the file
        Generate_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selected_file == ""){
                    Error_Label.setVisible(true);
                }
                else{
                    String title;
                    if(Text_field.getText().isEmpty()){
                         title = "Graph";
                    }
                    else{
                        title = Text_field.getText();
                    }
                    proj2.Graphs.graph(selected_file, combo.getSelectedIndex(), title);
                }


                
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
                        selected_file = selectedFile.getPath();
                        Choose_button.setText(selectedFile.getName());
                        Error_Label.setVisible(false);
                    }
                }
        });

        //creating panel
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //choose file layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5,0,5,5);
        panel.add(Choose_label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5,5,5,0);
        panel.add(Choose_button, gbc);

        //graph choice layout
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(combo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5,0,0,50);
        panel.add(Graph_label, gbc);
        
        //graph title layout
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(5,0,0,35);
        panel.add(Title_label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(5,5,5,0);
        panel.add(Text_field, gbc);

        //error label layout
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;  
        gbc.gridwidth = 2;  
        Error_Label.setVisible(false);
        panel.add(Error_Label, gbc);


        //generate button layout
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;  
        gbc.gridwidth = 2;  
        gbc.insets = new Insets(30,0,0,0);
        panel.add(Generate_button, gbc);






        //add panel to frame
        this.add(panel, BorderLayout.CENTER);

        //frame stuff
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setSize(400, 250);
        this.setVisible(true); 
    }

} 