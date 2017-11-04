/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypatternshapes.gui;

import strategypatternshapes.bll.patterns.SpiralPattern;
import strategypatternshapes.bll.patterns.GridPattern;
import strategypatternshapes.bll.shapes.Square;
import strategypatternshapes.bll.patterns.RandomPattern;
import strategypatternshapes.bll.shapes.Triangle;
import strategypatternshapes.bll.shapes.Star;
import strategypatternshapes.bll.ShapeDrawer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import strategypatternshapes.bll.patterns.DrawingPattern;
import strategypatternshapes.bll.shapes.Shape;

/**
 *
 * @author Jeppe
 */
public class MainWindowController implements Initializable {

    private enum ShapeType {
        Square, Star, Triangle
    };

    private enum PatternTypes {
        Grid, Random, Spiral
    };
    @FXML
    private Canvas canvasMain;
    @FXML
    private ComboBox<PatternTypes> comboPatterns;
    @FXML
    private ComboBox<ShapeType> comboShapes;
    @FXML
    private ListView<Shape> lstShapes;
    @FXML
    private TextField txtSize;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (ShapeType st : ShapeType.values()) {
            comboShapes.getItems().add(st);
        }

        for (PatternTypes pt : PatternTypes.values()) {
            comboPatterns.getItems().add(pt);
        }

        comboShapes.getSelectionModel().selectFirst();
        comboPatterns.getSelectionModel().selectFirst();

        txtSize.setText("10");
    }

    @FXML
    private void clickDrawShapes(ActionEvent event) {
        DrawingPattern pattern = null;
        PatternTypes selectedPattern = comboPatterns.getSelectionModel().getSelectedItem();

        if (null != selectedPattern) {
            switch (selectedPattern) {
                case Grid:
                    pattern = new GridPattern();
                    break;
                case Random:
                    pattern = new RandomPattern();
                    break;
                case Spiral:
                    pattern = new SpiralPattern();
                    break;
                default:
                    break;
            }
        }

        ShapeDrawer shapeDrawer = new ShapeDrawer(canvasMain.getGraphicsContext2D());
        shapeDrawer.setDrawStrategy(pattern);

        ObservableList<Shape> shapes = lstShapes.getItems();

        for (Shape shape : shapes) {
            shapeDrawer.addShape(shape);
        }

        canvasMain.getGraphicsContext2D().clearRect(0, 0, canvasMain.getWidth(), canvasMain.getHeight());
        shapeDrawer.draw();

    }

    @FXML
    private void clickAddShape(ActionEvent event) {
        
        try {
            Shape shape = null;
            int size = 0;
            size = Integer.parseInt(txtSize.getText());
            ShapeType selectedType = comboShapes.getSelectionModel().getSelectedItem();
            if (null != selectedType) {
                switch (selectedType) {
                    case Square:
                        shape = new Square(size);
                        break;
                    case Star:
                        shape = new Star(size);
                        break;
                    case Triangle:
                        shape = new Triangle(size);
                        break;
                    default:
                        break;
                }
            }

            lstShapes.getItems().add(shape);
        } catch (NumberFormatException nfe) {
            txtSize.setText("");
        }
    }
}
