/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.plot;

import java.nio.file.Path;

/**
 *
 * @author ronaldo
 */
public class PointsFunctionPlottable extends DataScriptPlottable{
    
    final String function, title; 
    final double [][] points;

    public PointsFunctionPlottable(
            double [][] points, 
            String function, 
            String title, 
            Path dataPath, 
            Path scriptPath) 
    {        
        super(dataPath, scriptPath);
        this.function = function;
        this.title = title;
        this.points = points;
    }

    @Override
    public String getScript() {
        StringBuilder sb = new StringBuilder();

        sb.append("set title \"").append(title).append("\"\n");
        sb.append("set xlabel \"elapse time\"\n");
        sb.append("set ylabel \"volume\"\n");
        sb.append("set grid\n");
        sb.append("set angles\n");
        sb.append("set style line 1 lc rgb '#0060ad' pt 7 ps 0.5 lt 1 lw 2\n");
        sb.append("f(x) = ").append(function).append("\n");
                
        //sb.append("set xrange [0:1]\n");
        //sb.append("set yrange [0:1]\n");
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
