/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypatternshapes.bll.patterns;

/**
 *
 * @author jeppjleemoritzled
 */
public class PatternFactory {

    /**
     * Patterns supported by factory
     */
    public enum PatternType {
        Grid,
        Random,
        Spiral
    };

    /**
     * The pattern factory makes it easier to create new shapes, dependant on
     * the chosen PatternType
     *
     * @param patternType
     * @return
     */
    public DrawingPattern create(PatternType patternType) {
        switch (patternType) {
            case Grid:
                return new GridPattern();
            case Random:
                return new RandomPattern();
            case Spiral:
                return new SpiralPattern();
            default:
                throw new UnsupportedOperationException("Type not implemented in factory");
        }
    }

}
