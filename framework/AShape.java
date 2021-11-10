//AShape.java
package framework; 
import java.awt.Graphics; 

// A is for "abstract"
// An abstract class that will be extended by specific shape classes. like 
// the CLin class. 

public abstract class AShape implements IDrawable { 

// Defines a reference point (refX, refY), which can be used in  
// subclasses, such as CLine, or CBox, to offset shapes to generate  
// chart more easily. 
protected int refX;
protected int refY;

AShape() { 

} 

abstract public void draw(Graphics g); 
} 