/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.plot;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ronaldo
 */
public final class FunctionPlottable extends ScriptPlottable{
    
    final List<String> functions;
    final String title;

    public FunctionPlottable(List<String> functions, String title, Path scriptPath) {
        super(scriptPath);
        this.functions = functions;
        this.title = title;
    }
    
    public FunctionPlottable(String function, String title, Path scriptPath) {
        super(scriptPath);
        this.functions = new ArrayList();
        this.title = title;
        
        this.functions.add(function);
    }
    
    @Override
    public String getScript() {
        
        StringBuilder sb = new StringBuilder();

        sb.append("set title \"").append(title).append("\"\n");
        sb.append("set xlabel \"elapse time\"\n");
        sb.append("set ylabel \"volume\"\n");
        sb.append("set grid\n");
        
        char c = 'f';
        for (String function : this.functions) {
            sb.append(c++).append("(x) = ").append(function).append("\n");
        }      
        
        //sb.append("set xrange [0:1]\n");
        //sb.append("set yrange [0:1]\n");
        
        c = 'f';
        sb.append("plot ");        
        int i = 0;
        for (; i < this.functions.size() - 1; i++) {
            sb.append(c++).append("(x) title '").append(this.functions.get(i)).append("', ");
        }
        sb.append(c++).append("(x) title '").append(this.functions.get(i)).append("'\n");        
        
        return sb.toString();
    }

    
}
