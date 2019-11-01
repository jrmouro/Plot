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
    final List<String> sets;

        
    public FunctionPlottable(
            List<String> functions, 
            List<String> sets,
            Path scriptPath) {
        super(scriptPath);
        this.functions = functions;
        this.sets = sets;
    }
    
    public FunctionPlottable(String function, List<String> sets, Path scriptPath) {
        super(scriptPath);
        this.functions = new ArrayList();
        this.sets = sets;
        
        this.functions.add(function);
    }
    
    @Override
    public String getScript() {
        
        StringBuilder sb = new StringBuilder();
        
        for (String set : this.sets) {
            sb.append("set ").append(set).append("\n");
        }
        char c = 'f';
        for (String function : this.functions) {
            sb.append(c++).append("(x) = ").append(function).append("\n");
        }     
        
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
