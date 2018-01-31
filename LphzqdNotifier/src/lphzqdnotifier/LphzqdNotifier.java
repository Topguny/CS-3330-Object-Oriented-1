/*
Lukas Heading
18131083
LPHZQD
9/13/16
 */
package lphzqdnotifier;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author lukas
 */
public class LphzqdNotifier extends Application {
    public String appName = "Notifier";
    public int width = 400;
    public int height = 250;
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        
        root.setAlignment(Pos.CENTER);
        
        TextField display = new TextField();
        
        Button button = new Button();
        button.setText("Say 'Notify'");
        button.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                display.setText("You have been notified!");
            }
        });
        
        Button button2 = new Button();
        button2.setText("Say 'Clear'");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                display.setText("");
            }
        });
        
        GridPane.setColumnIndex(display, 0);
        GridPane.setRowIndex(display, 0);
        root.getChildren().add(display);
        
        GridPane.setColumnIndex(button, 1);
        GridPane.setRowIndex(button, 0);
        root.getChildren().add(button);
        
        GridPane.setColumnIndex(button2, 1);
        GridPane.setRowIndex(button2, 1);
        root.getChildren().add(button2);
        
        Scene scene = new Scene(root, width, height);
        
        primaryStage.setTitle("Notifier");
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
