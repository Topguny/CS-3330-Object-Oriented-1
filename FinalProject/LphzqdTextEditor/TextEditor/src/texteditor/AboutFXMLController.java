/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.*;

/**
 * FXML Controller class
 *
 * @author lukas
 */
public class AboutFXMLController extends Switchable implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO'
        label.setText("Creator: Lukas Heading\n"
                + "This Application allows you to edit text as well as change font size, style, and decoration.\n It also allows you to print.");
    }  
    
    @FXML
    private Label label; 
    
    
    
    
    @FXML
    private void handleBack(ActionEvent event) {
        Switchable.switchTo("HTMLEditorFXML");
    }
}
