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
public class ShapeFactory
{
    public enum ShapeType { Square, Star, Triangle; };
    
    public Shape create(ShapeType shapeType) {
        return create(shapeType, 10);
    }

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
