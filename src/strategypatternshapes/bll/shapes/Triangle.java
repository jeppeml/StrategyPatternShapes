/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypatternshapes.bll.shapes;

import java.awt.Point;
import java.util.Arrays;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Jeppe
 */
public class Triangle extends Shape{

    public Triangle(int size) {
        super(size);
    }

    public Triangle(Color color, int size) {
        super(color, size);
    }

    public Triangle(Color color) {
        super(color);
    }

    public Triangle() {
    }

    @Override
    public void draw(int x, int y, GraphicsContext context) {
        context.setFill(super.color);
        context.setStroke(super.color);
        context.setLineWidth(1);
        double[] xPoints = {x,x+size,x-size};
        double[] yPoints = {y,y+size,y+size};
        context.beginPath();
        context.strokePolygon(xPoints, yPoints, 3);
    }
@Override
    public String toString() {
        return "Triangle{" + size + '}';
    }
}
