//CScatter.java
package framework; 

import java.awt.Color; 
import java.awt.Graphics; 
import java.awt.Graphics2D; 


public class CScatter extends AShape { 
    
    private int x1; 
    private int y1; 
    public int Xoffset;
    private Color lineColor = Color.BLACK; 

 
    public CScatter(int x1, int y1, Color lineColor) { 
        this.x1 = x1; 
        this.y1 = y1; 
        this.lineColor = lineColor; 
    } 

    @Override 
    public void draw(Graphics g) { 

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(lineColor); 
        g2.fillOval(x1, 265-y1, 10, 10);

    } 

// Provides an example for overriding the toString() method defined in  
// the Object class 

    public String toString() { 
        return "Line in color=" + lineColor;  
    } 
} 
