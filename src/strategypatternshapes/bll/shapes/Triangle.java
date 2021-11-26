/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypatternshapes.bll.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Implementation of drawing a Triangular shape on a specific context
 *
 * @author Jeppe
 */
public class Triangle extends Shape {

    /**
     *
     * @param size in pixels
     */
    public Triangle(int size) {
        super(size);
    }

    /**
     *
     * @param color
     * @param size in pixels
     */
    public Triangle(Color color, int size) {
        super(color, size);
    }

    /**
     *
     * @param color
     */
    public Triangle(Color color) {
        super(color);
    }

    /**
     *
     */
    public Triangle() {
    }

    /**
     *
     * Draws the triangle on the provided context
     *
     * @param x, starting point
     * @param y, starting point
     * @param context, drawing context
     */
    @Override
    public void draw(int x, int y, GraphicsContext context) {
        context.setFill(super.color);
        context.setStroke(super.color);
        context.setLineWidth(1);
        double[] xPoints = {x, x + size, x - size};
        double[] yPoints = {y, y + size, y + size};
        context.beginPath();
        context.strokePolygon(xPoints, yPoints, 3);
    }

    /**
     *
     * Simple string representation
     */
    @Override
    public String toString() {
        return "Triangle{" + size + '}';
    }
}
