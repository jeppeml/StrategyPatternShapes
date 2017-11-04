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
public interface DrawingPattern{ 
    public void drawShapes(List<Shape> shapes, GraphicsContext context);
}
