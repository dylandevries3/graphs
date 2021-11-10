//Proj2Main.java
package proj2; 

import java.awt.Color;
import java.io.*;
import java.util.*;

import framework.AShape; 
import framework.CChart; 
import framework.CLine; 
import framework.CBar; 
import framework.CScatter; 
import gui.ChartFrame; 

public class Graphs { 
    public static void main(String[] args) { 
        // Create your own chart by calling a createMyChart() method, and 
        // provide a title accordingly 

        //CChart aChart = createDummyChart(); 

        if(args.length != 1){
            System.out.println("Improper Usage: Please specify filename as command line argument");
            return;
        }
        String filename = args[0];
                
        CChart aChart;
        try{
            aChart = createChart(filename);
        }
        catch(FileNotFoundException exc){
            System.out.println("File Not Found");
            System.out.println("");
            return;
        }
        catch(NoSuchElementException exc){
            System.out.println("No Such Element");
            System.out.println("");
            return;
        }


        new ChartFrame(aChart.title, aChart); 
    } 

    // Create your own chart by reading data from a file, handle exceptions  
    // properly, and think about line chart, scatter chart (with dots), and 
    // bar chart, etc. 

    private static CChart createChart(String filename) throws FileNotFoundException, NoSuchElementException{ 

        int x1=0, x2=0, y1=0, y2=0;
        Random randomNumbers = new Random(); 
        String title = "";
        int offset =0;
        List<AShape> list = new ArrayList<AShape>();


        Scanner dataFile = new Scanner(new File(filename));

        //gets lines and calls different create_chart methods based on how many ints per line
        while(dataFile.hasNextLine()){

            String line = dataFile.nextLine();
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(" ");

            if(scanner.hasNextInt() ){
                x1 = scanner.nextInt();
            
                if(scanner.hasNextInt() ){
                    y1 = scanner.nextInt();

                    if(scanner.hasNextInt() ){
                        x2 = scanner.nextInt();
                        

                        //creates line graph because 4 ints per line
                        if(scanner.hasNextInt() ){
                            y2 = scanner.nextInt();
                            Color color = new Color(randomNumbers.nextInt(256),  
                            randomNumbers.nextInt(256),  
                            randomNumbers.nextInt(256)); 
                            list.add(new CLine(x1, y1, x2, y2, color));
                        }
                    }
                    //creates scatter plot because 2 ints per line
                    else{
                        Color color = new Color(randomNumbers.nextInt(256),  
                        randomNumbers.nextInt(256),  
                        randomNumbers.nextInt(256)); 
                        list.add(new CScatter(x1, y1, color));
                    }

                }
                //creates bar chart, because one int per line
                else{
                    Color color = new Color(randomNumbers.nextInt(256),  
                    randomNumbers.nextInt(256),  
                    randomNumbers.nextInt(256)); 
                    list.add(new CBar(x1, offset, color));
                    offset += 28;
                }
            }

            else{
                if(scanner.hasNext()) title = scanner.next();
            }
            scanner.close();
        }
        AShape[] shapes = new AShape[list.size()];

       list.toArray(shapes);

        CChart ret = new CChart(shapes);
        ret.title = title;
        return ret; 
    }
} 
