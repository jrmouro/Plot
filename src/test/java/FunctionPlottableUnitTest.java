
import com.jrmouro.plot.CanonicalPath;
import com.jrmouro.plot.FunctionPlottable;
import com.jrmouro.plot.Plottable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ronaldo
 */
public class FunctionPlottableUnitTest {
   
    @Test
    public void test() throws IOException {
        
        
        List<String> functions = new ArrayList();
        functions.add("(3.14159265359 * log((x - exp(1.0))))");
        
        List<String> sets = new ArrayList();        
                
        sets.add("title 'Test'");
        sets.add("xlabel 'time'");
        sets.add("ylabel 'volume'");
        sets.add("grid");
        sets.add("xrange [0:100]");
        sets.add("yrange [0:20]");
    
        Plottable p = new FunctionPlottable(functions, sets, CanonicalPath.getPath("sinx.plot"));
        p.plot();
        
        
    }
}
