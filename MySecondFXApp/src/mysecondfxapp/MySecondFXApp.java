/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysecondfxapp;

import java.awt.Desktop.Action;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Lukas
 */
public class MySecondFXApp extends Application {
    
    public String appName = "My Second App";
    public int width = 600;
    public int height = 400;
    
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane root = new GridPane();
        
        Label infoLabel = new Label();      
        Button button = new Button("Hello World!");
        
        button.setOnAction((ActionEvent event) -> {
         infoLabel.setText("Hello World!");
        });
        
        root.add(infoLabel),
        
        Scene scene = new Scene(root, width, height);
        
        primaryStage.setTitle(appName);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
