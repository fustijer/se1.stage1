/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1s1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author ashmit.khadka
 */
public class form_deadline implements Initializable {
    
   @FXML
   private TreeView treeView_deadlines;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        System.out.println("deadline view opened");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("form_main.fxml"));
        form_main main = loader.getController();   
        //main.blur();
        
        TreeItem<String> modules = new TreeItem<String> ("Modules");
        modules.setExpanded(true);
        
        TreeItem<String> mod1 = new TreeItem<String> ("Data Structures & Algorithums");
        mod1.setExpanded(true);
        TreeItem<String> mod1_cw1 = new TreeItem<String> ("Coursework 1");
        TreeItem<String> mod1_cw2 = new TreeItem<String> ("Coursework 2");
        mod1.getChildren().add(mod1_cw1);
        mod1.getChildren().add(mod1_cw2);
        modules.getChildren().add(mod1);
        
        treeView_deadlines.setRoot(modules);
    }
}