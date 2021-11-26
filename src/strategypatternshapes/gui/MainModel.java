/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypatternshapes.gui;

import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;
import strategypatternshapes.bll.ShapeDrawer;
import strategypatternshapes.bll.patterns.DrawingPattern;
import strategypatternshapes.bll.patterns.PatternFactory;
import strategypatternshapes.bll.patterns.PatternFactory.PatternType;
import strategypatternshapes.bll.shapes.Shape;
import strategypatternshapes.bll.shapes.ShapeFactory;

/**
 *
 * Represents the views state as a model
 *
 * @author jeppjleemoritzled
 */
public class MainModel {

    private final ObservableList<Shape> shapeList = FXCollections.observableArrayList();

    private ShapeFactory shapeFactory = new ShapeFactory();
    private PatternFactory patternFactory = new PatternFactory();

    /**
     *
     * @return an observable list of shapes
     */
    public ObservableList<Shape> getShapeList() {
        return shapeList;
    }

    /**
     * Removes all added shapes
     */
    public void clear() {
        shapeList.clear();
    }

    /**
     * Adds a specified amount of shapes. Chooses random shape and size of
     * shape.
     *
     * @param amount of random shapes to add
     */
    public void fillRandomShapes(int amount) {
        shapeList.clear();
        Random rand = new Random();
        for (int i = 0; i < amount; i++) {
            int randNum = rand.nextInt(ShapeFactory.ShapeType.values().length);
            ShapeFactory.ShapeType randomShape = ShapeFactory.ShapeType.values()[randNum];
            int randSize = (int) (Math.random() * 25 + 5);
            Shape shape = shapeFactory.create(randomShape, randSize);
            shapeList.add(shape);
        }
    }

    /**
     *
     * Creates a new shape based on the type wanted
     *
     *
     * @param selectedType, the type specified in the factory (ShapeFactory
     * enum)
     * @param size, the size in pixels
     */
    public void addShape(ShapeFactory.ShapeType selectedType, int size) {
        Shape shape = shapeFactory.create(selectedType, size);
        shapeList.add(shape);
    }

    /**
     *
     * creates a new pattern based on the type wanted
     *
     * @param selectedPattern, the type specified in the factory (PatternFactory
     * enum)
     * @param context
     */
    public void drawPattern(PatternType selectedPattern, GraphicsContext context) {
        DrawingPattern pattern = patternFactory.create(selectedPattern);

        ShapeDrawer shapeDrawer = new ShapeDrawer(context);
        shapeDrawer.setDrawStrategy(pattern);
        shapeDrawer.addAllShapes(shapeList);
        shapeDrawer.draw();
    }

}
