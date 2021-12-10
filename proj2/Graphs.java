//Proj2Main.java
package proj2; 

import java.awt.Color;
import java.io.*;
import java.text.BreakIterator;
import java.util.*;

import framework.AShape; 
import framework.CChart; 
import framework.CLine; 
import framework.CBar; 
import framework.CScatter; 
import gui.ChartFrame; 

enum graph{
    LINE,
    SCATTER,
    BAR
}

public class Graphs { 
    public static void main(String[] args) { 
        //generate main window
        new ChartFrame("Graphing Application");
    } 

    public static void graph(String filename, int graph_type, String title){
        //try to graph the chosen filename
        CChart aChart;
        try{
            aChart = createChart(filename, graph_type, title);
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

    public static CChart createChart(String filename, int g, String title) throws FileNotFoundException, NoSuchElementException{ 
        Integer offset = 0;
        int point;
        Random randomNumbers = new Random(); 
        List<AShape> list = new ArrayList<AShape>();
        Queue<Integer> q = new PriorityQueue<Integer>();
        Scanner dataFile = new Scanner(new File(filename));
        graph graph_type; 

        switch(g){
            case 0:
                graph_type = graph.LINE;
                break;
            case 1:
                graph_type = graph.SCATTER;
                break;
            case 2:
                graph_type = graph.BAR;
                break;
            default:
                graph_type = graph.LINE;
        }

        while(dataFile.hasNextLine()){
            String line = dataFile.nextLine();
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(" ");

            //get numbers and add them onto queue
            if(scanner.hasNextInt()){
                point = scanner.nextInt();
                q.add(point);

                //line graph
                //if line graph and 4 items are on queue then make new line object and add to list and clear queue
                if(graph_type == graph.LINE && q.size() == 4){
                    int x1= q.remove();
                    int y1 = q.remove();
                    int x2= q.remove();
                    int y2 = q.remove();
                    Color color = new Color(randomNumbers.nextInt(256),  
                    randomNumbers.nextInt(256),  
                    randomNumbers.nextInt(256)); 
                    list.add(new CLine(Integer.valueOf(x1), Integer.valueOf(y1), Integer.valueOf(x2), Integer.valueOf(y2), color));
                }
                //if scatter plot and 2 items are on queue then make new scatter object and add to list and clear queue
                if(graph_type == graph.SCATTER && q.size() == 2){
                    int x1= q.remove();
                    int y1 = q.remove();
                    Color color = new Color(randomNumbers.nextInt(256),  
                    randomNumbers.nextInt(256),  
                    randomNumbers.nextInt(256)); 
                    list.add(new CScatter(Integer.valueOf(x1), Integer.valueOf(y1), color));
                }
                //if bar graph and 1 item on queue then make new bar object and add to list and clear queue
                if(graph_type == graph.BAR && q.size() == 1){
                    int x1= q.remove();
                    Color color = new Color(randomNumbers.nextInt(256),  
                    randomNumbers.nextInt(256),  
                    randomNumbers.nextInt(256)); 
                    list.add(new CBar(Integer.valueOf(x1), offset, color));
                    offset += 28;
                }
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
