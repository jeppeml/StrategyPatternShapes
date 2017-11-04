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

    public Shape(int size) {
        this.size = size;
    }
    
    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Shape(Color color, int size) {
        this.color = color;
        this.size = size;
    }

    public Shape(Color color) {
        this(color, 10);
    }

    public Shape() {
        this(Color.BLACK);
    }

    public abstract void draw(int x, int y, GraphicsContext context);

    @Override
    public abstract String toString();
    
    
}
