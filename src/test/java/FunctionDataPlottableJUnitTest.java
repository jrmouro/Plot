/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jrmouro.plot.CanonicalPath;
import com.jrmouro.plot.Plottable;
import com.jrmouro.plot.PointsFunctionPlottable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author ronaldo
 */
public class FunctionDataPlottableJUnitTest {
    
    @Test
    public void test() throws IOException {
    
        double [][]points = {
            {.15,.15},
            {-.15,-.15},
            {.15,-.15},
            {-.15,.15}
        };
        
        List<String> sets = new ArrayList();        
                
        sets.add("title 'Test'");
        sets.add("xlabel 'time'");
        sets.add("ylabel 'volume'");
        sets.add("grid");
        sets.add("xrange [-pi:pi]");
        sets.add("yrange [-1:1]");
        sets.add("style line 1 lc rgb '#0060ad' pt 7 ps 0.5 lt 1 lw 2");
        
        
        
        
        Plottable p = new PointsFunctionPlottable(
                points, 
                "cos(x)", 
                sets,
                CanonicalPath.getPath("cosx.txt"),
                CanonicalPath.getPath("cosx.plot"));
        
        p.plot();
        
    }
}
