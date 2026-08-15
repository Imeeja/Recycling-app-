/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication6;

import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

/**
 *
 * @author merve
 */
public class JavaApplication6 extends Application{
    
    /**
     * @param args the command line arguments
     */
    
public void start(Stage stage) throws IOException {

    try {
        storeData.loadData();
        System.out.println("Data loaded successfully.");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("No saved data found. Starting with empty data.");
    }

    Parent root = FXMLLoader.load(
            getClass().getResource("hpage.fxml")
    );

    Scene scene = new Scene(root);

    stage.setTitle("Home page");
    stage.setScene(scene);
    stage.show();
}
    public static void main(String[] args) {
        launch();
    }
    
}
