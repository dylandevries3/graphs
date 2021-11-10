//CBar.java
package framework; 

import java.awt.*;


public class CBar extends AShape { 
    
    private int x1; 
    private Color lineColor = Color.BLACK; 
 
    public CBar(int x1, int offset, Color lineColor) { 
        this.x1 = x1; 
        this.lineColor = lineColor; 
        this.refX = offset;
    } 

    @Override 
    public void draw(Graphics g) { 

        //rectangles
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(lineColor); 
        g2.fillRect(refX, 265-x1, 28, x1);

        //text
        Font font = new Font("Serif", Font.BOLD, 17);
        g2.setFont(font);
        g2.setColor(Color.BLACK); 
        String output = Integer.toString(x1);
        g2.drawString(output, refX, 265-x1);
    } 

// Provides an example for overriding the toString() method defined in  
// the Object class 

    public String toString() { 
        return "Line in color=" + lineColor;  
    } 
} 
