/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jrmouro.plot.CanonicalPath;
import com.jrmouro.plot.Plottable;
import com.jrmouro.plot.PointsFunctionPlottable;
import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class FunctionDataPlottableJUnitTest {
    
    @Test
    public void test() throws IOException {
    
        double [][]points = {
            {20.15,20.15},
            {-20.15,-20.15},
            {20.15,-20.15},
            {-20.15,20.15}
        };
        
        Plottable p = new PointsFunctionPlottable(
                points, 
                "cos(x)", 
                "title", 
                CanonicalPath.getPath("cosx.txt"),
                CanonicalPath.getPath("cosx.plot"));
        
        p.plot();
        
    }
}
