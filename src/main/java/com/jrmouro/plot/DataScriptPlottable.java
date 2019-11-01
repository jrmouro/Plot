/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.plot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ronaldo
 */
public abstract class DataScriptPlottable extends ScriptPlottable{
    
    final Path dataPath;

    public DataScriptPlottable(Path dataPath, Path scriptPath) {
        super(scriptPath);
        this.dataPath = dataPath;
                    
    }
    
    public final Path dataPath(){
        return this.dataPath;
    }
    
    public abstract String getData();

    
    private void createDataFile() {        
        
        File file = new File(this.dataPath.toString());

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
            writer.write(this.getData());
            
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

    @Override
    public void plot() {
        this.createDataFile();
        super.plot(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
