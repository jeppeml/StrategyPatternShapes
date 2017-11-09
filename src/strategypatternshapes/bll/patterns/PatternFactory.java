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
public class PatternFactory
{
    public enum PatternType { Grid, Random, Spiral };
    
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
