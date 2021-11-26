/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypatternshapes.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import strategypatternshapes.bll.patterns.PatternFactory.PatternType;
import strategypatternshapes.bll.shapes.Shape;
import strategypatternshapes.bll.shapes.ShapeFactory.ShapeType;

/**
 *
 * @author Jeppe
 */
public class MainWindowController implements Initializable {

    @FXML
    private Canvas canvasMain;
    @FXML
    private ComboBox<PatternType> comboPatterns;
    @FXML
    private ComboBox<ShapeType> comboShapes;
    @FXML
    private ListView<Shape> lstShapes;
    @FXML
    private TextField txtSize;

    // Holds the list of shapes and communicates with BLL
    MainModel model = new MainModel();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Loads values into ComboBox from the enum in ShapeFactory
        for (ShapeType st : ShapeType.values()) {
            comboShapes.getItems().add(st);
        }

        // Loads values into ComboBox from the enum in PatternFactory
        for (PatternType pt : PatternType.values()) {
            comboPatterns.getItems().add(pt);
        }

        comboShapes.getSelectionModel().selectFirst();
        comboPatterns.getSelectionModel().selectFirst();

        /**
         * Connects model and view, so that the view is always updated
         * automagically
         */
        lstShapes.setItems(model.getShapeList());
        txtSize.setText("10");
    }

    @FXML
    private void clickDrawShapes(ActionEvent event) {
        PatternType selectedPattern = comboPatterns.getSelectionModel().getSelectedItem();
        canvasMain.getGraphicsContext2D().clearRect(0, 0, canvasMain.getWidth(), canvasMain.getHeight());

        model.drawPattern(selectedPattern, canvasMain.getGraphicsContext2D());
    }

    @FXML
    private void clickClearShapes(ActionEvent event) {
        model.clear();
    }

    @FXML
    private void clickAddRandom(ActionEvent event) {
        model.fillRandomShapes(100);
    }

    @FXML
    private void clickAddShape(ActionEvent event) {
        ShapeType selectedType = comboShapes.getSelectionModel().getSelectedItem();
        try {
            int size = Integer.parseInt(txtSize.getText());
            model.addShape(selectedType, size);
        }
        catch (NumberFormatException nfe) {
            txtSize.setText("");
        }
    }
}
