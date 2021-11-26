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
    private final List<Shape> shapes = new ArrayList();

    private DrawingPattern drawStrategy;

    /**
     * Fetches the current drawing strategy.
     *
     * @return a pattern for drawing shapes.
     */
    public DrawingPattern getDrawStrategy() {
        return drawStrategy;
    }

    /**
     * Sets the strategy to use for drawing. The strategy is a pattern of the
     * shapes to be drawn.
     *
     * @param drawStrategy
     */
    public void setDrawStrategy(DrawingPattern drawStrategy) {
        this.drawStrategy = drawStrategy;
    }

    /**
     * Adds a shape to the end of the List
     *
     * @param shape, the shape to add
     */
    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    /**
     * Removes a shape
     *
     * @param shape, the instance of the shape to remove
     */
    public void removeShape(Shape shape) {
        this.shapes.remove(shape);
    }

    /**
     * Appends alle the shapes to the end of the list.
     *
     * @param shapes
     */
    public void addAllShapes(List<Shape> shapes) {
        this.shapes.addAll(shapes);
    }

    /**
     * Gets the list of shapes
     *
     * @return The internal list of shapes
     */
    public List<Shape> getShapes() {
        return shapes;
    }

    /**
     * Initializes a new instance, with an empty list of shapes
     *
     * @param context, the context to draw on
     */
    public ShapeDrawer(GraphicsContext context) {
        this.context = context;
    }

    /**
     * Drawes all shapes that have been added
     */
    public void draw() {
        drawStrategy.drawShapes(shapes, context);
    }

}
