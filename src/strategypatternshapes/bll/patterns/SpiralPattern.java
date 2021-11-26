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
public class SpiralPattern implements DrawingPattern {

    private double angleIncrement = 10;
    private double radiusIncrement = 2;
    private int xStart = 175;
    private int yStart = 175;

    /**
     * Gets the increment of the angle per drawing of shape
     *
     * @return angle in rads
     */
    public double getAngleIncrement() {
        return angleIncrement;
    }

    /**
     * Sets the increment of the angle per drawing of shape
     *
     * @param angleIncrement in rads
     */
    public void setAngleIncrement(double angleIncrement) {
        this.angleIncrement = angleIncrement;
    }

    /**
     * Gets the increment of the radius per drawing of shape
     *
     * @return radius in pixels
     */
    public double getRadiusIncrement() {
        return radiusIncrement;
    }

    /**
     * Sets the increment of the radius per drawing of shape
     *
     * @param radiusIncrement, radius in pixels
     */
    public void setRadiusIncrement(double radiusIncrement) {
        this.radiusIncrement = radiusIncrement;
    }

    /**
     *
     * @return start point for x
     */
    public int getxStart() {
        return xStart;
    }

    /**
     *
     * @param xStart, sets start point for x
     */
    public void setxStart(int xStart) {
        this.xStart = xStart;
    }

    /**
     *
     * @return start point for y
     */
    public int getyStart() {
        return yStart;
    }

    /**
     *
     * @param yStart, sets start point for y
     */
    public void setyStart(int yStart) {
        this.yStart = yStart;
    }

    /**
     * Draws all shapes in a spiral pattern, based on the angleincrement and
     * radius increment.
     *
     * @param shapes
     * @param context
     */
    @Override
    public void drawShapes(List<Shape> shapes, GraphicsContext context) {
        double r = 0, angle = 0;

        for (Shape shape : shapes) {
            angle += angleIncrement;
            r += radiusIncrement;
            double x = r * Math.sin(angle) + xStart;
            double y = r * Math.cos(angle) + yStart;
            shape.draw((int) x, (int) y, context);
        }

    }

}
