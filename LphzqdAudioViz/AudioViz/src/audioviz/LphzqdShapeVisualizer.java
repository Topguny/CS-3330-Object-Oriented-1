/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audioviz;

import static java.lang.Integer.min;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;


/**
 *
 * @author lukas
 */
public class LphzqdShapeVisualizer implements Visualizer {
    
    private final String name = "Shape Vizualizer";
    
    private Integer numBands;
    private AnchorPane vizPane;
    
    private final Double bandHeightPercentage = 1.3;//1.3
    private final Double minEllipseRadius = 10.0;  // 10.0
    
    private Double width = 0.0;
    private Double height = 0.0;
    
    private Double bandWidth = 0.0;
    private Double bandHeight = 0.0;
    
    private final Double startHue = 260.0;
    
    private Polygon[] polygons;
    
    public LphzqdShapeVisualizer() {
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void start(Integer numBands, AnchorPane vizPane) {
        end();
        
        this.numBands = numBands;
        this.vizPane = vizPane;
        
        height = vizPane.getHeight();
        width = vizPane.getWidth();
        
        bandWidth = width / numBands;
        bandHeight = height * bandHeightPercentage;
        polygons = new Polygon[numBands];
        
        for (int i = 0; i < numBands; i++) {
            Polygon polygon = new Polygon((bandWidth / 2 + bandWidth * i)-150, (height / 2), 0.0, 0.0, 30.0, 0.0, 300.0, 0.0);
            polygon.setFill(Color.hsb(startHue, .75, .75, .75));
            vizPane.getChildren().add(polygon);
            polygons[i] = polygon;
        }

    }
    
    @Override
    public void end() {
         if (polygons != null) {
             for (Polygon polygon : polygons) {
                 vizPane.getChildren().remove(polygon);
             }
            polygons = null;
        } 
    }
    
    @Override
    public void update(double timestamp, double duration, float[] magnitudes, float[] phases) {
        if (polygons == null) {
            return;
        }
        
        Integer num = min(polygons.length, magnitudes.length);
        
        for (int i = 0; i < num; i++) {
            
            polygons[i].getPoints().setAll((bandWidth / 2 + bandWidth * i)-150, (height / 2), 0.0, (minEllipseRadius), 30.0, 0.0, 300.0, 0.0);
            polygons[i].setFill(Color.hsb(startHue - (magnitudes[i] * 11.0), .75, .75, .75));
        }
    }
}