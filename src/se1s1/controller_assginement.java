/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1s1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import se1s1.Models.*;
;

/**
 *
 * @author ashmit.khadka
 */
public class controller_assginement implements Initializable {
    
   @FXML
   private TreeView<Object> treeView_deadlines;
   
   private controller_main parent_main;
   
   private final Image moduleIcon = new Image(getClass().getResourceAsStream(
                   "Resources/img/icons/agenda.png"),40,40, false, false);
   private final Image AssignmentIcon = new Image(getClass().getResourceAsStream(
                   "Resources/img/icons/alarm-clock_s.png"),24,24, false, false);
   private final Image taskIcon = new Image(getClass().getResourceAsStream(
                   "Resources/img/icons/list_s.png"),24,24, false, false);
   private final Image activityIcon = new Image(getClass().getResourceAsStream(
                   "Resources/img/icons/idea_s.png"),24,24, false, false);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        System.out.println("deadline view opened");
        
    } 
    
    
    public void set_main_controller(controller_main main){
        this.parent_main = main;
    }
    
    public void selectDeadline(){
        treeView_deadlines.setOnMouseClicked(event -> {
        if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
            Object selected_item = null;
            TreeItem<Object> selcted_node = treeView_deadlines.getSelectionModel().getSelectedItem();
            if (selcted_node != null){
                selected_item = selcted_node.getValue();
            }

            if (selected_item instanceof Module){
                Module m = (Module)selcted_node.getValue(); 
                parent_main.showModule((Module)selcted_node.getValue());
                close();
            }
            else if (selected_item instanceof Assignment){
                parent_main.showAssignment((Assignment)selcted_node.getValue());
                close();
            }
            else if (selected_item instanceof Task){
                Task t = (Task)selcted_node.getValue(); 
                parent_main.showTask((Task)selcted_node.getValue());
                close();
            }
            else if (selected_item instanceof Activity){
                Activity a = (Activity)selcted_node.getValue(); 
                close();
            }  
        }
        });        
    }
    
    public void setData(Semester s){
        TreeItem<Object> tv_modules = new TreeItem<Object>();        
        for (Module m: s.getModules()){
            //System.out.println(m.getAssginments());
            TreeItem<Object> tv_current_module = new TreeItem<Object>(
                    m, new ImageView(moduleIcon));           
            for (Assignment a : m.getAssginments()){
                TreeItem<Object> tv_current_assignment = new TreeItem<Object>(
                        a, new ImageView(AssignmentIcon));    
                for (Task t: a.getTasks()){
                    TreeItem<Object> ti_current_task = new TreeItem<Object>(
                            t, new ImageView(taskIcon));
                    for(Activity act : t.getActivitiesArray()){
                        TreeItem<Object> ti_current_activity = new TreeItem<Object>(act, new ImageView(activityIcon));
                        ti_current_task.getChildren().add(ti_current_activity);
                    }
                    tv_current_assignment.getChildren().add(ti_current_task);
                }
                tv_current_module.getChildren().add(tv_current_assignment);
            }
            tv_modules.getChildren().add(tv_current_module);
            
        }
        treeView_deadlines.setRoot(tv_modules);
        tv_modules.setExpanded(true);

    }
    
    private void close(){
        Stage stage = (Stage) treeView_deadlines.getScene().getWindow();
        stage.close();
    }
    
   
}