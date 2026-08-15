package javaapplication6;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author merve
 */
public class LogEventController implements Initializable {

    @FXML
    private TextField material;
    @FXML
    private TextField weight;
    @FXML
    private Label pointsLabel;
    
      private Household household;

    public void setHousehold(Household household) {
        this.household = household;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        SceneSwitcher.switchScene(event, "hpage.fxml");
    }

    @FXML
    private void storeEvent(ActionEvent event) {
        String Rmaterial = material.getText();
        double kg = 0.00;
        while (true) {
                 try {
                    kg = Double.parseDouble(weight.getText());
                    if (kg <= 0) {
                        throw new IllegalArgumentException();
                    } 
                        break;
                    
                } 
                catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "incorrect number format", "Error:", JOptionPane.INFORMATION_MESSAGE);
            return;
                }
             catch (IllegalArgumentException e) {
                 JOptionPane.showMessageDialog(null, "number should be positive!");
            return;
             } 
    }
        RecyclingEvent recyclingEvent = new RecyclingEvent(Rmaterial, kg);
            household.addEvent(recyclingEvent);
        pointsLabel.setText("Recycling event logged! your EcoPoints are: " + kg * 10 );
        material.clear();
        weight.clear();
    }

}
