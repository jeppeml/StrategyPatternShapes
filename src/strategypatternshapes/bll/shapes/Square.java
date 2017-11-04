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
public class Square extends Shape{

    public Square(int size) {
        super(size);
    }

    public Square(Color color, int size) {
        super(color, size);
    }

    public Square(Color color) {
        super(color);
    }

    public Square() {
    }

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
