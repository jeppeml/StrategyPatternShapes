/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypatternshapes.bll.shapes;

import javafx.scene.canvas.GraphicsContext;

/**
 * Implementation of drawing a Star shape on a specific context
 *
 * @author Jeppe
 */
public class Star extends Shape {

    // Different radius for each part of the start
    private final double[] radius = {size, size / 2, size, size / 2};
    // Amount of vertices on the star polygon
    private int nPoints = 26;

    /**
     *
     * @param size in pixels
     */
    public Star(int size) {
        super(size);
        setSize(size);
    }

    /**
     *
     */
    public Star() {
        super();
    }

    /**
     *
     * @return the amount of vertices on the star polygon
     */
    public int getnPoints() {
        return nPoints;
    }

    /**
     *
     * @param nPoints, the amount of vertices on the star polygon
     */
    public void setnPoints(int nPoints) {
        this.nPoints = nPoints;
    }

    /**
     * Sets the four radius for the star.
     *
     * @param r1
     * @param r2
     * @param r3
     * @param r4
     */
    public void setRadius(double r1, double r2, double r3, double r4) {
        radius[0] = r1;
        radius[1] = r2;
        radius[2] = r3;
        radius[3] = r4;
    }

    /**
     *
     *
     * @param size of star in pixels
     */
    public void setSize(int size) {
        this.size = size;
        setRadius(size, size / 2, size, size / 2);
    }

    /**
     * Draws the star on specified point
     *
     *
     * @param xStart, starting point
     * @param yStart, starting point
     * @param context, drawing context
     */
    @Override
    public void draw(int xStart, int yStart, GraphicsContext context) {
        double[] xPoints = new double[nPoints];
        double[] yPoints = new double[nPoints];

        for (double current = 0.0; current < nPoints; current++) {
            int i = (int) current;
            double x = Math.cos(current * ((2 * Math.PI) / nPoints)) * radius[i % 4];
            double y = Math.sin(current * ((2 * Math.PI) / nPoints)) * radius[i % 4];

            xPoints[i] = x + xStart;
            yPoints[i] = y + yStart;
        }
        context.beginPath();
        context.strokePolygon(xPoints, yPoints, nPoints);
    }

    /**
     *
     * @return a simple string representation
     */
    @Override
    public String toString() {
        return "Star{" + size + '}';
    }

}
