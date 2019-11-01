
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
        functions.add("sin(x)");
        functions.add("cos(x)");
    
        Plottable p = new FunctionPlottable(functions, "Functions", CanonicalPath.getPath("sinx.plot"));
        p.plot();
        
        
    }
}
