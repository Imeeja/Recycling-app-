package javaapplication6;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * FXML Controller class
 *
 * @author merve
 */
public class HpageController implements Initializable {
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @FXML
    private void registerHousehold(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("registerHousehold.fxml"));
                Scene s = new Scene(root);
                Stage ss = new Stage();
                ss.setScene(s);
                ss.show();
                ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    }
    @FXML 
    private void logEvent (ActionEvent event) throws IOException {
            TextInputDialog dialog = new TextInputDialog();

    dialog.setTitle("Log Recycling Event");
    dialog.setHeaderText("Enter Household ID");
    dialog.setContentText("Household ID:");
String hhId = "";

    Optional<String> result = dialog.showAndWait();
    
    if (result.isPresent()) {
        hhId= result.get().trim();
    }    else {return;}
    
    if (!storeData.households.containsKey(hhId)) {
                JOptionPane.showMessageDialog(null, "Household with this ID doesn't exist.");
                return;
            } else {
    Household household = storeData.households.get(hhId);
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("logEvent.fxml"));

Parent root = loader.load();

LogEventController controller = loader.getController();

controller.setHousehold(household);
                Scene s = new Scene(root);
                Stage ss = new Stage();
                ss.setScene(s);
                ss.show();
                ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    
    } }
    @FXML
private void displayHouseholds(ActionEvent event) {

    if (storeData.households.isEmpty()) {

        JOptionPane.showMessageDialog(
                null,
                "No households have been registered yet.",
                "Households",
                JOptionPane.INFORMATION_MESSAGE
        );

        return;
    }

    StringBuilder message = new StringBuilder();

    message.append("REGISTERED HOUSEHOLDS\n\n");

    for (Household household : storeData.households.values()) {

        message.append("Household ID: ")
               .append(household.getId())
               .append("\n");

        message.append("Name: ")
               .append(household.getName())
               .append("\n");

        message.append("Address: ")
               .append(household.getAddress())
               .append("\n");

        message.append("Registration Date: ")
               .append(household.getJdate())
               .append("\n");

        message.append("Total Recycled: ")
               .append(household.getTotalWeight())
               .append(" KG\n");

        message.append("EcoPoints: ")
               .append(household.getTotal())
               .append("\n");

        message.append("=========================\n");
    }

    JOptionPane.showMessageDialog(
            null,
            message.toString(),
            "Registered Households",
            JOptionPane.INFORMATION_MESSAGE
    );
}
@FXML
private void displayEvents(ActionEvent event) {

    TextInputDialog dialog = new TextInputDialog();

    dialog.setTitle("Display Recycling Events");
    dialog.setHeaderText("Enter Household ID");
    dialog.setContentText("Household ID:");

    Optional<String> result = dialog.showAndWait();

    if (result.isEmpty()) {
        return;
    }

    String hhId = result.get().trim();

    if (!storeData.households.containsKey(hhId)) {

        JOptionPane.showMessageDialog(
                null,
                "Household with this ID doesn't exist.",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );

        return;
    }

    Household household = storeData.households.get(hhId);

    if (household.getEvents().isEmpty()) {

        JOptionPane.showMessageDialog(
                null,
                "This household has no recycling events yet.",
                "Recycling Events",
                JOptionPane.INFORMATION_MESSAGE
        );

        return;
    }

    StringBuilder message = new StringBuilder();

    message.append("RECYCLING EVENTS\n");
    message.append("Household: ").append(household.getName()).append("\n");
    message.append("ID: ").append(household.getId()).append("\n\n");

    for (RecyclingEvent recyclingEvent : household.getEvents()) {

        message.append("Material: ")
               .append(recyclingEvent.getMaterial())
               .append("\n");

        message.append("Weight: ")
               .append(recyclingEvent.getKg())
               .append(" KG\n");

        message.append("Date: ")
               .append(recyclingEvent.getRdate())
               .append("\n");

        message.append("EcoPoints: ")
               .append(recyclingEvent.getEcoPoints())
               .append("\n");

        message.append("-------------------------\n");
    }

    JOptionPane.showMessageDialog(
            null,
            message.toString(),
            "Recycling Events",
            JOptionPane.INFORMATION_MESSAGE
    );
}
@FXML
private void generateReports(ActionEvent event) {

    int householdCount = storeData.households.size();

    int eventCount = 0;
    double totalWeight = 0;
    double totalPoints = 0;

    for (Household household : storeData.households.values()) {

        eventCount += household.getEvents().size();
        totalWeight += household.getTotalWeight();
        totalPoints += household.getTotal();
    }

    String report =
            "ECO-POINTS REPORT\n\n"
            + "Households registered: " + householdCount + "\n"
            + "Recycling events logged: " + eventCount + "\n"
            + "Total recycled weight: " + totalWeight + " KG\n"
            + "Total EcoPoints: " + totalPoints;

    JOptionPane.showMessageDialog(
            null,
            report,
            "Eco-Points Report",
            JOptionPane.INFORMATION_MESSAGE
    );
}
@FXML
private void saveAndExit(ActionEvent event) {

    try {

        ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream("households.dat")
                );

        out.writeObject(storeData.households);

        out.close();

        JOptionPane.showMessageDialog(
                null,
                "Data saved successfully!",
                "Save Successful",
                JOptionPane.INFORMATION_MESSAGE
        );

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.close();

    } catch (IOException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error saving data: " + e.getMessage(),
                "Save Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
}
