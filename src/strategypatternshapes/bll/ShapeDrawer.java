/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypatternshapes.bll;

import strategypatternshapes.bll.patterns.DrawingPattern;
import strategypatternshapes.bll.shapes.Shape;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Jeppe
 */
public class ShapeDrawer {
    GraphicsContext context;
    List<Shape> shapes = new ArrayList();
    
    private DrawingPattern drawStrategy;

    public DrawingPattern getDrawStrategy() {
        return drawStrategy;
    }

    public void setDrawStrategy(DrawingPattern drawStrategy) {
        this.drawStrategy = drawStrategy;
    }

    public void addShape(Shape shape)
    {
        this.shapes.add(shape);
    }
    
    public void removeShape(Shape shape)
    {
        this.shapes.remove(shape);
    }
    
    public void addAllShapes(List<Shape> shapes) {
        this.shapes.addAll(shapes);
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public ShapeDrawer(GraphicsContext context) {
        this.context = context;
    }
    
    public void draw() {
        drawStrategy.drawShapes(shapes, context);
    }
           
    
}
