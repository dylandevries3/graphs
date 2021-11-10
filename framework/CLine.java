//CLine.java
package framework; 

import java.awt.*;


public class CLine extends AShape { 
    
    private int x1; 
    private int y1; 
    private int x2; 
    private int y2;	 
    public int Xoffset;
    private Color lineColor = Color.BLACK; 

 
    public CLine(int x1, int y1, int x2, int y2, Color lineColor) { 
        this.x1 = x1; 
        this.y1 = y1; 
        this.x2 = x2; 
        this.y2 = y2; 
        this.lineColor = lineColor; 
    } 

    @Override 
    public void draw(Graphics g) { 
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(lineColor); 
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(x1, 265-y1, x2, 265-y2); 
    } 

// Provides an example for overriding the toString() method defined in  
// the Object class 

    public String toString() { 
        return "Line in color=" + lineColor;  
    } 
} 
