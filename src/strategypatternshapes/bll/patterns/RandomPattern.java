/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypatternshapes.bll.patterns;

import strategypatternshapes.bll.shapes.Shape;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Jeppe
 */
public class RandomPattern implements DrawingPattern{ 

    @Override
    public void drawShapes(List<Shape> shapes, GraphicsContext context) {
        
        
        for (Shape shape : shapes) {
            int x = (int)(Math.random()*context.getCanvas().getWidth());
        int y = (int)(Math.random()*context.getCanvas().getHeight());
            shape.draw(x, y, context);
        }
        
    }
    
}
