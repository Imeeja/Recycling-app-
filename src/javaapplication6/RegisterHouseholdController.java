package javaapplication6;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author merve
 */
public class RegisterHouseholdController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField address;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void register() {
//        loadHouseholdsFromFile();
        String setId = id.getText();
        if (storeData.households.containsKey(setId)) {
                JOptionPane.showMessageDialog(
    null,
    "This household ID already exists!",
    "Registration Error",
    JOptionPane.ERROR_MESSAGE
);
            return;
            }
        String setName= name.getText();
        String setAddress = address.getText();
        Household household = new Household( setName, setId, setAddress);
            storeData.households.put(setId, household);
        id.clear();
        name.clear();
        address.clear();
        JOptionPane.showMessageDialog(
    null,
    "Household registered successfully on " + household.getJdate(),
    "Success",
    JOptionPane.INFORMATION_MESSAGE
);
        
    }
    @FXML
private void goBack(ActionEvent event) throws IOException {
    SceneSwitcher.switchScene(event, "hpage.fxml");
}
    
}
