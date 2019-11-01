/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jrmouro.plot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ronaldo
 */
public class Plottables implements Iterable<Plottable>, Plottable{

    final private List<Plottable> plottables = new ArrayList();
    final private String title;

    public Plottables(String title) {
        this.title = title;
    }
    
    public void add(Plottable p){
        this.plottables.add(p);
    }
    
    public int size(){
        return this.plottables.size();
    }

    @Override
    public void plot() {
        this.plottables.forEach((t) -> {
            t.plot();
        });
    }
  
    @Override
    public Iterator<Plottable> iterator() {
        return plottables.iterator();
    }

}
