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
import javafx.scene.control.TableView;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ashmit.khadka
 */
public class form_main implements Initializable {
    
    @FXML
    private WebView webView;
    @FXML
    private VBox main_container;
    @FXML
    private TableView tableView_Complete;
    
    private GaussianBlur gaussianBlur = new GaussianBlur();
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        URL gc = this.getClass().getResource("Resources/gantt_chart/main.html");
        WebEngine engine = webView.getEngine();
        System.out.println(gc.toString());
        engine.load(gc.toString());
        
    }
    
    public void blur(boolean set){
        if (set){
            gaussianBlur.setRadius(10); 
        }else {
            gaussianBlur.setRadius(0); 
        }
        main_container.setEffect(gaussianBlur);
    }
    
    

    public void show_form_task(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("form_task.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("New task");
            stage.setScene(new Scene(root1));  
            stage.initModality(Modality.APPLICATION_MODAL);
            blur(true);
            //stage.show();
            stage.showAndWait();
            blur(false);
        }
        catch (Exception e){
            
        }
    }
    
    public void show_form_deadline(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("form_deadline.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Select a deadline...");
            stage.setScene(new Scene(root1));  
            stage.initModality(Modality.APPLICATION_MODAL);
            blur(true);
            //stage.show();
            stage.showAndWait();
            blur(false);
        }
        catch (Exception e){
            
        }
        //blur();
    }    
 
    
}
