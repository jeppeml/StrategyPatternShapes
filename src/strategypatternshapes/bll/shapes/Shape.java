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
 */
public abstract class Shape {

    protected Color color;

    protected int size;

    /**
     *
     * @param size, size of shape in pixels
     */
    public Shape(int size) {
        this.size = size;
    }

    /**
     *
     * @return size of shape in pixels
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @return Color of the shape
     */
    public Color getColor() {
        return color;
    }

    /**
     *
     * @param color, the color of the shape
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     *
     * @param color
     * @param size
     */
    public Shape(Color color, int size) {
        this.color = color;
        this.size = size;
    }

    /**
     *
     * @param color
     */
    public Shape(Color color) {
        this(color, 10);
    }

    /**
     * Sets default color to black
     */
    public Shape() {
        this(Color.BLACK);
    }

    /**
     *
     * @param x, start point
     * @param y, start point
     * @param context, the context to draw upon
     */
    public abstract void draw(int x, int y, GraphicsContext context);

    /**
     * Returns a simple string representation of the instance.
     *
     */
    @Override
    public abstract String toString();
}
