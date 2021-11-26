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
public interface DrawingPattern {

    /**
     * Draws the shapes on the context
     *
     * @param shapes, a List of shapes that is to be drawn on provided context
     * @param context, the GraphicsContext that the shapes list is drawn upon
     */
    public void drawShapes(List<Shape> shapes, GraphicsContext context);
}
