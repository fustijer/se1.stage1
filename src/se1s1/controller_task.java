/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1s1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import se1s1.Models.*;


/**
 *
 * @author ashmit.khadka
 */
public class controller_task implements Initializable {    
    
    @FXML
    private TextField tf_title;
    
    @FXML
    private ComboBox cb_assginement;
    
    @FXML
    private ComboBox cb_dependency;
    
    @FXML
    private DatePicker dp_start;
    
    @FXML
    private DatePicker dp_end;
    
    @FXML
    private TextArea ta_note;
    
    private controller_main parent_main;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {     
        
        System.out.println("new task opened");  

        
    }
    
    public void set_main_controller(controller_main main){
        this.parent_main = main;
    }  
    
    public void setData(Semester s){
        ObservableList<String> options = FXCollections.observableArrayList();
        
        for (Module m: parent_main.current_semester.getModules()){
            for (Assignment a: m.getAssginments()){
                System.out.println(a.getName());
                cb_assginement.getItems().add(a.getName());
                //options.add(a.getName());
            }
        }
        System.out.println(options);
        //cb_assginement = new ComboBox(options);
    }
    
    public void addTask(){        
        if (tf_title.getText() != null){    
            System.out.println("adding task " + tf_title.getText());
            Task task = new Task(tf_title.getText());        
            for (Module m: parent_main.current_semester.getModules()){
                for (Assignment a: m.getAssginments()){
                    if (a.getName().equals(cb_assginement.getValue())){
                        a.addTasks(task);
                        close();
                    }
                    //options.add(a.getName());
                }
            }   
        }
        else{
            System.out.println("Please fill in relevant fields");
        }
    }
    
    private void close(){
        Stage stage = (Stage) tf_title.getScene().getWindow();
        stage.close();
    }
}