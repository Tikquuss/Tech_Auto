/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech_auto;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Notsawo
 */
public class Tech_Auto extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        AnchorPane root = new AnchorPane();
        
        FXMLLoader loader = new FXMLLoader();
        try{
            loader.setLocation(getClass().getResource("/tech_auto/view.fxml"));
            root = (AnchorPane)loader.load();
        }catch(IOException e){
           e.printStackTrace();
        }
        
        Scene scene = new Scene(root, 600, 500);
        
        primaryStage.setTitle("Tech_Auto");
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
