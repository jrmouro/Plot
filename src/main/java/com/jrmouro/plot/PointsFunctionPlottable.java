/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.plot;

import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author ronaldo
 */
public class PointsFunctionPlottable extends DataScriptPlottable{
    
    final String function; 
    final List<String> sets;
    final double [][] points;

    public PointsFunctionPlottable(
            double [][] points, 
            String function, 
            List<String> sets,
            Path dataPath, 
            Path scriptPath) 
    {        
        super(dataPath, scriptPath);
        this.sets = sets;
        this.function = function;
        this.points = points;
    }

    @Override
    public String getScript() {
        
        StringBuilder sb = new StringBuilder();
        
        for (String set : this.sets) {
            sb.append("set ").append(set).append("\n");
        }
        
        sb.append("f(x) = ").append(function).append("\n");
                
        sb.append("plot f(x) title '").append(function).append("', '");
        
        sb.append(this.dataPath).append("' w p ls 1 title 'points'");        
        
        return sb.toString();
    }

    @Override
    public String getData() {
        
        StringBuilder sb = new StringBuilder();
        
        for (double[] point : this.points) {
            for (double d : point) {
                sb.append(String.valueOf(d)).append("\t");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
    
    
    
    
    
}
