/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1s1.Models;

/**
 *
 * @author admin
 */
public class Activity {
    
    String name;
    int timeSpent; 
    String notes;    
    int completion; //ak
    private Boolean complete;
    
    public Activity(String name){
        this.name = name;
        complete = false;

    }
    
    public Boolean getComplete(){
        return complete;
    }
    
    public void setComplete(Boolean inpComplete){
        complete = inpComplete;
    }
    
    enum workType {
        studying, programming, writing
    }
    
    public String getName(){
        return name;
    }
    
    @Override
    public String toString(){
        return name;
    }        
}

