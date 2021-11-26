/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypatternshapes.bll.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Jeppe
 *
 * Implementation of drawing a Square shape on a specific context
 *
 */
public class Square extends Shape {

    /**
     *
     * @param size
     */
    public Square(int size) {
        super(size);
    }

    /**
     *
     * @param color
     * @param size
     */
    public Square(Color color, int size) {
        super(color, size);
    }

    /**
     *
     * @param color
     */
    public Square(Color color) {
        super(color);
    }

    /**
     *
     */
    public Square() {
    }

    /**
     *
     * Draws a square using the provided starting point and context.
     *
     * @param x, starting point
     * @param y, starting point
     * @param context
     */
    @Override
    public void draw(int x, int y, GraphicsContext context) {
        context.beginPath();
        context.setFill(super.color);
        context.setStroke(super.color);
        context.setLineWidth(1);
        context.strokeRect(x, y, size, size);
    }

    @Override
    public String toString() {
        return "Square{" + size + '}';
    }

}
