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
public class Task {
    
    String name;
    int completion;
    ArrayList<Activity> activities = new ArrayList<>();   


    private String notes;
    
    enum workType {
        studying, programming, writing
    }
   
    
    //milestone: (e.g. time for studying, chapters for reading)
    
    private ArrayList<Task> taskArray = new ArrayList<>();
    private ArrayList<Activity> activitiesArray = new ArrayList<>();



    //void: chkDependencies
    
    public Task(String name){
        this.name = name;
    }


    //void: addNote
    public String getNote(){
        return notes;
    }
    
    public String getName(){
        return name;
    }
    
    public void setNote(String inpNote){
        notes = inpNote;
    }

    //boolean: chkActivitesComplete
    public boolean chkActivitesComplete(){
        boolean allComplete = true;
        for(int i = 0; i < activitiesArray.size(); i++){
            //if(activitiesArray.get(i).getComplete() == false){
            //    allComplete = false;
            //}
        }
        return allComplete;
    }
    
    //void: addDependncies
    public void addTaskArray(Task task){
        taskArray.add(task);
    }
    
    public void addActivity(Activity activity){
        activitiesArray.add(activity);
    }
    
    //Function: getArrayOfActivities
    public ArrayList<Task> getArrayOfActivities(){
        return taskArray;
    }
    
    //Function: getTaskAtIndex
    public Task getTaskAtIndex(int index){
        return taskArray.get(index);
    }

    public ArrayList<Activity> getActivitiesArray(){
        return activitiesArray;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
}