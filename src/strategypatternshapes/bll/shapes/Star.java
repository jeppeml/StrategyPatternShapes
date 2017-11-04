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
public class Star extends Shape{
    private final double[] radius = {size,size/2,size,size/2};
    private int nPoints = 26;

    public Star(int size) {
        super(size);
        setSize(size);
    }

    public Star() {
    }

    public int getnPoints() {
        return nPoints;
    }

    public void setnPoints(int nPoints) {
        this.nPoints = nPoints;
    }
    
    public void setRadius(double r1, double r2, double r3, double r4)
    {
        radius[0] = r1;
        radius[1] = r2;
        radius[2] = r3;
        radius[3] = r4;
    }

    public void setSize(int size) {
        this.size = size;
        setRadius(size,size/2,size,size/2);
    }
    
    @Override
    public void draw(int xStart, int yStart, GraphicsContext context) {
        double[] xPoints = new double[nPoints];
        double[] yPoints = new double[nPoints];

        for (double current=0.0; current<nPoints; current++)
        {
            int i = (int) current;
            double x = Math.cos(current*((2*Math.PI)/nPoints))*radius[i % 4];
            double y = Math.sin(current*((2*Math.PI)/nPoints))*radius[i % 4];

            xPoints[i] = x+xStart;
            yPoints[i] = y+yStart;
        }
        context.beginPath();
        context.strokePolygon(xPoints, yPoints, nPoints);
    }
    @Override
    public String toString() {
        return "Star{" + size + '}';
    }
 
    
}
