/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1s1.Models;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Semester {
    int type;
    ArrayList<Module> modules = new ArrayList<>();
    
    public Semester(){}
    
    public void addModules(Module m){
        modules.add(m);        
    }
    
    public ArrayList<Module> getModules(){
        return modules;
    }
    
}
