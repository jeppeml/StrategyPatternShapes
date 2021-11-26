/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypatternshapes.bll.shapes;

/**
 *
 * @author jeppjleemoritzled
 */
public class ShapeFactory {

    /**
     * The diffent types of shapes, that the factory supports.
     */
    public enum ShapeType {
        Square,
        Star,
        Triangle;
    };

    /**
     * Creates and returns a new shape from a selected type
     *
     * @param shapeType
     * @return
     */
    public Shape create(ShapeType shapeType) {
        return create(shapeType, 10);
    }

    /**
     *
     * Creates and returns a new shape from a selected type
     *
     * @param shapeType
     * @param size
     * @return
     */
    public Shape create(ShapeType shapeType, int size) {
        switch (shapeType) {
            case Square:
                return new Square(size);
            case Star:
                return new Star(size);
            case Triangle:
                return new Triangle(size);
            default:
                throw new UnsupportedOperationException("Type not implemented in factory");
        }
    }
}
