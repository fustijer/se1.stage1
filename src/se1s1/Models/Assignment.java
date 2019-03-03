/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1s1.Models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Assignment {
    
    String name;
    String moduleName; //@ak
    ArrayList<Task> tasks = new ArrayList<>(); 
    private Date    setDate,
                    returnDate;
    private int weight;
    boolean complete = false;
    

    //Getters and Setters begin here
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String name) {
        this.moduleName = name;
    }
    
    public Date getSetDate() {
        return setDate;
    }

    public void setSetDate(Date setDate) {
        this.setDate = setDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    //Getters and Setters end here
    
    
    @Override
    public String toString(){
//        return String.format("%s====\nSet:\t%s\nDue:\t%s\nWeight:\t%s\n",
//                name,
//                setDate.toString(),
//                returnDate.toString(),
//                weight
//        );
        return name;
    }
    
    
    public void addExtension(Date newDeadline){
        returnDate = newDeadline;
    }
    
    public void addExtension(int days){
        //returnDate.add(Date, days);
    }
    
    public boolean isComplete(){
        return complete;
    }
    
    public void setComplete(boolean completetion){
        this.complete = completetion;
    }
    
    public Assignment(
            String name,
            Date setDate,
            Date returnDate,
            int weight
    ) {
        this.name = name;
        this.setDate = setDate;
        this.returnDate = returnDate;
        this.weight = weight;
    }
    
  
    
    public Assignment(){
        this.name = "Default Assignment";
        //this.setDate = Date.getInstance();
        //this.returnDate = Date.getInstance();
        this.weight = 0;
    }
    
    
    public Assignment(String name, int weight){
        this.name = name;
        this.weight = weight;
    } 
    
    public ArrayList<Task> getTasks() {
    return tasks;
    }

    public void addTasks(Task task) {
        tasks.add(task);
    }    

}