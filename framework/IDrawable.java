//IDrawable.java
package framework;
import java.awt.Graphics;

// An interface for anything that can be drawn to the graphical context
// Don't create the g yourself: it's available in the paintComponent() method 
public interface IDrawable {
    void draw(Graphics g);
 }