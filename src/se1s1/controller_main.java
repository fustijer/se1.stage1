/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1s1;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import se1s1.Models.*;


/**
 *
 * @author ashmit.khadka
 */
public class controller_main implements Initializable {
    
    Semester current_semester;
    
    @FXML
    private WebView webView;
    @FXML
    private VBox main_container;
    
    @FXML
    private TableView tv_completed;
    @FXML
    private TableView tv_upcomming;
    @FXML
    private TableView tv_missed;

    @FXML
    private Label deadline_name;
    @FXML
    private Label deadline_info;
    @FXML
    private Label main_day;
    @FXML
    private Label main_month;
    @FXML
    private Label main_day_month;
    
    
    private GaussianBlur gaussianBlur = new GaussianBlur();    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        updateCalender();        
        initialize_obj(); 
        showDashboard();
        URL gc = this.getClass().getResource("Resources/gantt_chart/main.html");
        WebEngine engine = webView.getEngine();
        engine.load(gc.toString());
        
    }   
    
    public void updateCalender(){
        Calendar today = Calendar.getInstance();
        Date date = today.getTime();
        main_day.setText(new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime()));
        main_month.setText(new SimpleDateFormat("MMMM", Locale.ENGLISH).format(date.getTime()));
        int month = date.getMonth()+1;
        switch (month){
            case 1 : main_day_month.setText(month + "st"); break;
            case 2 : main_day_month.setText(month + "nd"); break; 
            case 3 : main_day_month.setText(month + "rd"); break;
            default: main_day_month.setText(month + "th"); break;
        }
        
    }

    public void showViewTask(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view_task.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            fxmlLoader.<controller_task>getController().set_main_controller(this);              
            controller_task ctr_task = fxmlLoader.getController();
            ctr_task.setData(current_semester); 
            Stage stage = new Stage();
            stage.setTitle("New task");
            stage.setScene(new Scene(root1));  
            stage.initModality(Modality.APPLICATION_MODAL);
            blur(true);
            stage.showAndWait();
            blur(false);
        }
        catch (Exception e){
            
        }
    }
    
     public void showViewNav(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view_assginement.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            fxmlLoader.<controller_assginement>getController().set_main_controller(this);              
            controller_assginement ctr_deadlines = fxmlLoader.getController();
            ctr_deadlines.setData(current_semester);           
            Stage stage = new Stage();
            stage.setTitle("Select a deadline...");
            stage.setScene(new Scene(root1));  
            stage.initModality(Modality.APPLICATION_MODAL);
            blur(true);
            stage.showAndWait();
            blur(false);
        }
        catch (Exception e){            
        }
    }    
    
    public void showDashboard(){
        //Initialize view elements values
        deadline_name.setText("Deadlines");
        deadline_info.setText("");
        deadline_info.setVisible(false);

        //Clear previous data:
        tv_completed.getColumns().clear();
        tv_upcomming.getColumns().clear();
        tv_missed.getColumns().clear(); 
        
        //build table
        ObservableList<Assignment> tv_complete_data = FXCollections.observableArrayList();        
        ObservableList<Assignment> tv_upcomming_data = FXCollections.observableArrayList();        
        ObservableList<Assignment> tv_missed_data = FXCollections.observableArrayList();        
        Calendar cal = Calendar.getInstance();        
        Date today = cal.getTime();
        today.setYear(Calendar.getInstance().get(Calendar.YEAR));
        for(Module m: current_semester.getModules()){
            for (Assignment a: m.getAssginments()){
                a.setModuleName(m.getName());
                if (a.isComplete()){
                    tv_complete_data.add(a); 
                }
                else if (today.compareTo(a.getReturnDate())<=0) {
                    tv_upcomming_data.add(a);
                }
                else{
                    tv_missed_data.add(a);
                }
            }
        }
        //COMPLETE TABLE
        TableColumn tv_complete_subjectCol = new TableColumn("Module");
        tv_complete_subjectCol.setMinWidth(100);
        tv_complete_subjectCol.setCellValueFactory(
                new PropertyValueFactory<Assignment, String>("moduleName")); 
        
        TableColumn tv_complete_firstNameCol = new TableColumn("Name");
        tv_complete_firstNameCol.setMinWidth(100);
        tv_complete_firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Assignment, String>("name")); 
        
        TableColumn tv_complete_weightCol = new TableColumn("Weight");
        tv_complete_weightCol.setMinWidth(50);
        tv_complete_weightCol.setCellValueFactory(
                new PropertyValueFactory<Assignment, String>("weight")); 
        
        TableColumn tv_complete_statusCol = new TableColumn("Status");
        tv_complete_statusCol.setMinWidth(50);
        
        tv_completed.getColumns().addAll(
                tv_complete_subjectCol,
                tv_complete_firstNameCol, 
                tv_complete_weightCol,
                tv_complete_statusCol);   
        tv_completed.setItems(tv_complete_data);
        
        //UPCOMMING TABLE
        TableColumn tv_upcomming_subjectCol = new TableColumn("Module");
        tv_upcomming_subjectCol.setMinWidth(100);
        tv_upcomming_subjectCol.setCellValueFactory(
                new PropertyValueFactory<Assignment, String>("moduleName")); 
        
        TableColumn tv_upcomming_firstNameCol = new TableColumn("Name");
        tv_upcomming_firstNameCol.setMinWidth(100);
        tv_upcomming_firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Assignment, String>("name")); 
        
        TableColumn tv_upcomming_weightCol = new TableColumn("Weight");
        tv_upcomming_weightCol.setMinWidth(50);
        tv_upcomming_weightCol.setCellValueFactory(
                new PropertyValueFactory<Assignment, String>("weight")); 
        
        TableColumn tv_upcomming_statusCol = new TableColumn("Status");
        tv_upcomming_statusCol.setMinWidth(50);
        
        tv_upcomming.getColumns().addAll(
                tv_upcomming_subjectCol,
                tv_upcomming_firstNameCol,
                tv_upcomming_weightCol,
                tv_upcomming_statusCol);   
        tv_upcomming.setItems(tv_upcomming_data);
        
        //MISSED TABLE
        TableColumn tv_missed_subjectCol = new TableColumn("Module");
        tv_missed_subjectCol.setMinWidth(100);
        tv_missed_subjectCol.setCellValueFactory(
                new PropertyValueFactory<Assignment, String>("moduleName")); 
        
        TableColumn tv_missed_firstNameCol = new TableColumn("Name");
        tv_missed_firstNameCol.setMinWidth(100);
        tv_missed_firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Assignment, String>("name")); 
        
        TableColumn tv_missed_weightCol = new TableColumn("Weight");
        tv_missed_weightCol.setMinWidth(50);
        tv_missed_weightCol.setCellValueFactory(
                new PropertyValueFactory<Assignment, String>("weight")); 
        
        TableColumn tv_missed_statusCol = new TableColumn("Status");
        tv_missed_statusCol.setMinWidth(50);
        
        tv_missed.getColumns().addAll(
                tv_missed_subjectCol,
                tv_missed_firstNameCol,
                tv_missed_weightCol,
                tv_missed_statusCol);   
        tv_missed.setItems(tv_missed_data);    

    }
    
    
    public void showAssignment(Assignment a){
        deadline_name.setText(a.getName());
        deadline_info.setText(String.format("%s - %s%%",
                a.getReturnDate(),
                a.getWeight()));
        deadline_info.setVisible(true);
    } 
    
    public void showModule(Module m){

    }  
   
    public void showTask(Task m){
        
    }

    
    public void blur(boolean set){
        if (set){
            gaussianBlur.setRadius(10); 
        }else {
            gaussianBlur.setRadius(0); 
        }
        main_container.setEffect(gaussianBlur);
    }
    public void initialize_obj(){
        Activity t1a1 = new Activity("Create Album class");
        Activity t1a2 = new Activity("Test the code");
        Activity t2a1 = new Activity("Create UML class daigram");
        Activity t2a2 = new Activity("Define requirements");        
        Task t1 = new Task("Begin C++ cw");
        Task t2 = new Task("Plan C++ cw");        
        Assignment a1 = new Assignment("Corsework 1",
                new Date(2019, 1, 1), new Date(2019, 1, 20), 30);
        a1.setComplete(true);
        Assignment a2 = new Assignment("Corsework 2",
                new Date(2019, 1, 1), new Date(2019, 3, 11), 30);  
        Assignment a3 = new Assignment("Exam 1",
                new Date(2019, 1, 1), new Date(2019, 5, 10), 40);    
        Module m1 = new Module("Programming 2");
        Semester s1 = new Semester();         
        t1.addActivity(t1a1);
        t1.addActivity(t1a2);
        t2.addActivity(t2a1);
        t2.addActivity(t2a2);        
        a1.addTasks(t1);
        a1.addTasks(t2);        
        m1.addAssignment(a1); 
        m1.addAssignment(a2);
        m1.addAssignment(a3);
        s1.addModules(m1);
        
        Assignment a21 = new Assignment("Corsework 1",
                new Date(2019, 1, 1), new Date(2019, 1, 10), 60);
        a21.setComplete(false);
        Assignment a22 = new Assignment("Exam", 
                new Date(2019, 1, 1), new Date(2019, 4, 10), 40);        
        Module m2 = new Module("Graphics 1");
        m2.addAssignment(a21); 
        m2.addAssignment(a22);       
        s1.addModules(m2);


        Assignment a31 = new Assignment("Corsework 1",
                new Date(2019, 1, 1), new Date(2019, 1, 15), 15); 
        a31.setComplete(true);
        Assignment a32 = new Assignment("Corsework 2",
                new Date(2019, 1, 1), new Date(2019, 2, 21), 35);  
        Assignment a33 = new Assignment("Exam 1",
                new Date(2019, 1, 1), new Date(2019, 4, 10), 50);  
        Module m3 = new Module("Data Stuctures & Algorithums");
        m3.addAssignment(a31); 
        m3.addAssignment(a32);
        m3.addAssignment(a33);
        s1.addModules(m3);

        
        current_semester = s1;        
        
        
    }   

    
}
