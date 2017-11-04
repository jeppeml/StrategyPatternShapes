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
    private int xStart = 300;
    private int yStart = 300;

    public double getAngleIncrement() {
        return angleIncrement;
    }

    public void setAngleIncrement(double angleIncrement) {
        this.angleIncrement = angleIncrement;
    }

    public double getRadiusIncrement() {
        return radiusIncrement;
    }

    public void setRadiusIncrement(double radiusIncrement) {
        this.radiusIncrement = radiusIncrement;
    }

    public int getxStart() {
        return xStart;
    }

    public void setxStart(int xStart) {
        this.xStart = xStart;
    }

    public int getyStart() {
        return yStart;
    }

    public void setyStart(int yStart) {
        this.yStart = yStart;
    }

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
