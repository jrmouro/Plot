/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.plot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronaldo
 */
public abstract class ScriptPlottable implements Plottable{

    final Path scriptPath;

    public ScriptPlottable(Path scriptPath) {
        this.scriptPath = scriptPath;
    }
    
    public abstract String getScript();
    
    @Override
    public void plot() {
        
        this.createScriptFile();
        
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("gnuplot -p " + this.scriptPath.toString());
        } catch (IOException ex) {
            Logger.getLogger(DataScriptPlottable.class.getName()).log(Level.SEVERE, null, ex);
        }

        StringBuilder error = new StringBuilder();

        BufferedReader stdError = new BufferedReader(
                new InputStreamReader(process.getErrorStream()));

        String line;
        try {
            while ((line = stdError.readLine()) != null) {
                error.append(line).append("\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(DataScriptPlottable.class.getName()).log(Level.SEVERE, null, ex);
        }

        int exitVal = 0;
        try {
            exitVal = process.waitFor();
        } catch (InterruptedException ex) {
            Logger.getLogger(DataScriptPlottable.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (exitVal == 0 && error.toString().length() > 0) {

            System.out.println("Error: " + error.toString());

        }
        
    }
    
    private void createScriptFile() {        
        
        File file = new File(this.scriptPath.toString());

        // delete the file if it exists
        file.delete();

        try {
            // creates the file
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(FunctionPlottable.class.getName()).log(Level.SEVERE, null, ex);
        }

        // creates a FileWriter Object
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
        } catch (IOException ex) {
            Logger.getLogger(FunctionPlottable.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // Writes the content to the file
            writer.write(this.getScript());
            
        } catch (IOException ex) {
            Logger.getLogger(FunctionPlottable.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(FunctionPlottable.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(FunctionPlottable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
}
