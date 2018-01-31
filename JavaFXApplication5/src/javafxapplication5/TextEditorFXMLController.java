/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import static javafx.scene.text.Font.font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import texteditor.Switchable;

/**
 * FXML Controller class
 *
 * @author lukas
 */
public class TextEditorFXMLController extends Switchable implements Initializable {
    
    
    
    @FXML
    private Parent root = super.getRoot();
   
    @FXML
    private TextArea textArea;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
    @FXML
    public void handleOpen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        
        Stage stage = (Stage) root.getScene().getWindow();
        
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Text files","*.txt", "*.html", "*.c"));
        
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            
            BufferedReader bufferedReader = null;
                    
            try {
                bufferedReader = new BufferedReader(new FileReader(file));

                String document = "";
                String line = "";
                
                while ( (line = bufferedReader.readLine()) != null) {
                    document += line + "\n";
                }
                
                textArea.setText(document);
                
            } catch (FileNotFoundException fnfex) {
                displayExceptionAlert(fnfex);
            } catch (IOException ioex) {
                displayExceptionAlert(ioex);
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception ex) {
                        displayExceptionAlert(ex);
                    }
                }
            }
        }

    }
    
    @FXML
    public void handleSave(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) root.getScene().getWindow();
        
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Text files","*.txt", "*.html", "*.c"));
        
        File file = fileChooser.showSaveDialog(stage);
        
        FileWriter writer = null;
        
        if (file != null) {
            try {
            
                writer = new FileWriter(file);
                writer.write(textArea.getText());
            
            } catch (IOException ioex) {
                displayExceptionAlert(ioex);
            } catch (Exception ex) {
                displayExceptionAlert(ex);
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (Exception ex) {
                        displayExceptionAlert(ex);
                    }
                }
            }

        }

    }
    
    public String getText(){
        String text = textArea.getText();
        return text;
    }
    
    @FXML
    private void handleAbout(ActionEvent event) {
        Switchable.switchTo("AboutFXML");
    }
    
    @FXML
    private void handlePrint(ActionEvent event) {
        print(textArea);
    }
    
    private void print(Node node) {
        try{
            PrinterJob job = PrinterJob.createPrinterJob();
            if (job != null && job.showPrintDialog(node.getScene().getWindow())){
                boolean success = job.printPage(node);
                if (success) {
                    job.endJob();
                }
            }  
        } catch(Exception ex){
            System.out.println("Error loading Printer" + ex);
        }
    }
    
    int fontsize = 14;
    String font = "";
    String Pos = "";
    
    @FXML
    private void handleFontSizeSmall(ActionEvent event) {
        changeFontSizeSmall();
    }
    
    private void changeFontSizeSmall() {
       textArea.setFont(Font.font (font,8));
       fontsize = 8;
    }
    
    @FXML
    private void handleFontSizeNormal(ActionEvent event) {
        changeFontSizeNormal();
    }
    
    private void changeFontSizeNormal() {
       textArea.setFont(Font.font (font,12));
       fontsize = 12;
    }
    
    @FXML
    private void handleFontSizeLarge(ActionEvent event) {
        changeFontSizeLarge();
    }
    
    private void changeFontSizeLarge() {
       textArea.setFont(Font.font (font,16));
       fontsize = 16;
    }
    
    @FXML
    private void handleFontSizeHuge(ActionEvent event) {
        changeFontSizeHuge();
    }
    
    private void changeFontSizeHuge() {
       textArea.setFont(Font.font (font,20));
       fontsize = 20;
    }
    
    @FXML
    private void handleFontArial(ActionEvent event) {
        changeFontArial();
    }
    
    private void changeFontArial() {
       textArea.setFont(Font.font ("Arial",fontsize));
       font = "Arial";
    }
    
    @FXML
    private void handleFontSerif(ActionEvent event) {
        changeFontSerif();
    }
    
    private void changeFontSerif() {
       textArea.setFont(Font.font ("Serif",fontsize));
       font = "Serif";
    }
    
    @FXML
    private void handleFontComicSans(ActionEvent event) {
        changeFontComicSans();
    }
    
    private void changeFontComicSans() {
       textArea.setFont(Font.font ("ComicSansMS",fontsize));
       font = "ComicSansMS";
    }
    
    @FXML
    private void handleFontConsolas(ActionEvent event) {
        changeFontConsolas();
    }
    
    private void changeFontConsolas() {
       textArea.setFont(Font.font ("Consolas",fontsize));
       font = "Consolas";
    }
     
    @FXML
    private void handleDecorBold(ActionEvent event) {
        changeDecorBold();
    }
    
    private void changeDecorBold() {
       textArea.setFont(Font.font(font,FontWeight.BOLD,fontsize));
       Pos = "FontWeight.BOLD";
    }
    
    @FXML
    private void handleDecorItalic(ActionEvent event) {
        changeDecorItalic();
    }
    
    private void changeDecorItalic() {
       textArea.setFont(Font.font(font,FontPosture.ITALIC,fontsize));
       Pos = "FontPosture.ITALIC";
    }
    
    @FXML
    private void handleDecorPlain(ActionEvent event) {
        changeDecorPLain();
    }
    
    private void changeDecorPLain() {
       textArea.setFont(Font.font(font,fontsize));
       Pos = "";
    }
    
    
    
    private void displayExceptionAlert(Exception ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText("Exception!");
        alert.setContentText(ex.getMessage());
        
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }
    
    
}
