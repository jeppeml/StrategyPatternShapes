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
public class GridPattern implements DrawingPattern {

    private int spacing;
    private int startX;
    private int startY;
    private int rows;
    private int columns;

    /**
     *
     * @return the amount of rows in the grid
     */
    public int getRows() {
        return rows;
    }

    /**
     *
     * @param rows of the grid to be drawn
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     *
     * @return the number of columns in the grid
     */
    public int getColumns() {
        return columns;
    }

    /**
     *
     * @param columns sets the number of columns in the grid
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    /**
     *
     * @return the starting point, x, of the pattern
     */
    public int getStartX() {
        return startX;
    }

    /**
     *
     * @param startX sets the starting point, x, of the pattern
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     *
     * @return the starting point, y, of the pattern
     */
    public int getStartY() {
        return startY;
    }

    /**
     *
     * @param startY the starting point, y, of the pattern
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     *
     * @return the spacing in pixels between elements
     */
    public int getSpacing() {
        return spacing;
    }

    /**
     *
     * @param spacing sets the spacing in pixels between elements
     */
    public void setSpacing(int spacing) {
        this.spacing = spacing;
    }

    /**
     * A pattern that draws in a grid of custom size
     */
    public GridPattern() {
        spacing = 10;
        startX = 10;
        startY = 10;
        rows = 30;
        columns = 21;
    }

    /**
     * Draws shapes on context in a row by column grid, using the spacing and
     * starting point provided
     *
     * @param shapes
     * @param context
     */
    @Override
    public void drawShapes(List<Shape> shapes, GraphicsContext context) {

        int nextShapeIndex = 0;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {

                if (nextShapeIndex < shapes.size()) {
                    Shape currentShape = shapes.get(nextShapeIndex++);
                    currentShape.draw(2 * x * spacing + this.startX, 2 * y * spacing + this.startY, context);
                }
                else {
                    break;
                }
            }
        }
    }

}
