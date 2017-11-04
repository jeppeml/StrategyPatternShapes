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

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getSpacing() {
        return spacing;
    }

    public void setSpacing(int spacing) {
        this.spacing = spacing;
    }

    public GridPattern() {
        spacing = 10;
        startX = 10;
        startY = 10;
        rows = 8;
        columns = 8;
    }

    @Override
    public void drawShapes(List<Shape> shapes, GraphicsContext context) {
     
        int nextShapeIndex = 0;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {

                if (nextShapeIndex < shapes.size()) {
                    Shape currentShape = shapes.get(nextShapeIndex++);
                    currentShape.draw(2 * x * (currentShape.getSize() + spacing) + this.startX, 2 * y * (currentShape.getSize() + spacing) + this.startY, context);
                } else {
                    break;
                }
            }
        }
    }

}
