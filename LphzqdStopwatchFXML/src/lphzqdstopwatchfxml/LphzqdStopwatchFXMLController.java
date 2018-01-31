/*
LPHZQD
18131082
 */
package lphzqdstopwatchfxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 *
 * @author lukas
 */
public class LphzqdStopwatchFXMLController implements Initializable {
    
    @FXML
    private Label time;
    @FXML
    private ImageView dialImageView;
    @FXML
    private ImageView handImageView;
    @FXML
    private AnchorPane anchorpane;
     @FXML
    private GridPane gridpane;
    @FXML
    private StackPane stackpane;
    @FXML
    private Button start;
    @FXML
    private Button stop;
    @FXML
    private Button reset;
    
    private double tickTimeInSeconds = 1.0;  
    private double secondsElapsed = 0;
    private double angleDeltaPerSeconds = 6.0;
    private Timeline timeline;
    private KeyFrame keyFrame;
    private int minute= 0;
    private int minutes = 0;
    private int second = 0;
    private int seconds = 0;
    
    private void setupTimer() {
        boolean running = false;
        if (timeline != null) {
            if (timeline.getStatus() == Status.RUNNING) {
                running = true;
                timeline.stop();
            }
        }

        keyFrame = new KeyFrame(Duration.millis(tickTimeInSeconds * 1000), (ActionEvent event) -> {
            update();
        });
        
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE); 
        
        if (running) {
            timeline.play();
        }
        time.setText("00:00");
        time.setFont(new Font("Times New Roman", 70));
    }
    
    private void update() {
        secondsElapsed += tickTimeInSeconds;
        second += 1;
        if(second > 9){
            second = 0;
            seconds += 1;
        }
        if(seconds > 5){
            seconds = 0;
            minute += 1;
        }
        if(minute > 9){
            minute = 0;
            minutes += 1;
        }
        if(minutes > 5){
            minutes = 0;
        }
        time.setText(Integer.toString(minutes) + Integer.toString(minute) + ":" +  Integer.toString(seconds) + Integer.toString(second));
        
        double rotation = secondsElapsed * angleDeltaPerSeconds;
        handImageView.setRotate(rotation);
        
    }
    
    @FXML
    private void handlestart(ActionEvent event) {
       setupTimer();
       timeline.play();
    }
    
    @FXML
    private void handlestop(ActionEvent event) {
        timeline.stop();
    }
    
    @FXML
    private void handlereset(ActionEvent event) {
        
        timeline.stop();
        secondsElapsed = 0;
        handImageView.setRotate(0);
        minute= 0;
        minutes = 0;
        second = 0;
        seconds = 0;
        time.setText("00:00");
    }
    
    public boolean isRunning() {
        if (timeline != null) {
            if (timeline.getStatus() == Status.RUNNING) {
                return true;
            }
        } 
        return false;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
