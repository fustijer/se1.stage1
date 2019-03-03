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

public class Module {
    //ArrayList<Assignment> deadlines = new ArrayList<>();
    
    public Module(String name){
        this.name = name;
    }    
    
    private String name;
    private ArrayList<Assignment> assignments = new ArrayList();
    private ArrayList<Task> tasks = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
    public ArrayList<Assignment> getAssginments() {
        return assignments;
    }

    public void addAssignment(Assignment deadline) {
        this.assignments.add(deadline);
    }
    
    public Assignment getAssginement(String name){
        for (Assignment a : assignments){
            if (a.name.equals(name)){
                return a;
            }            
        }
        return null;
    }
}
    
   