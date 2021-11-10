//CChart.java
package framework; 

import java.awt.Graphics; 
// C is for "concrete" 
// A concrete class that is drawable, by implementing the IDrawable interface 
// An instance of CChart encapsulate a number of AShape objects, each of  
// which is Drawable. 

 
public class CChart implements IDrawable { 

    private AShape[] chartComponents; 
    public String title;

    public CChart(AShape[] shapes) { 
        this.chartComponents = shapes; 
        this.title = "Random Chart";
    } 
    // When the Chart draws itself, it will iterate through all of its  
    // shapes and draw them in the order as stored in the array. 
    // You need to create the CChart object with the order in mind, since 
    // a shape painted later may cover up those painted before it. 
    @Override 
    public void draw(Graphics g) { 
        for (AShape aShape : chartComponents) 
            aShape.draw(g); 
    } 
} 