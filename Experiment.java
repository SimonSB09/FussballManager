import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.Event;
import je.NumberField;
import javafx.scene.text.*;
import javafx.scene.text.Font;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 15.10.2025
 * @author 
 */

public class Experiment extends Application {
  // start attributes
  private NumberField numberField1 = new NumberField();
  // end attributes
  
  public void start(Stage primaryStage) { 
    Pane root = new Pane();
    Scene scene = new Scene(root, 284, 262);
    // start components
    
    numberField1.setLayoutX(32);
    numberField1.setLayoutY(48);
    numberField1.setPrefHeight(24);
    numberField1.setPrefWidth(80);
    numberField1.setFont(Font.font("Dialog", 11));
    root.getChildren().add(numberField1);
    // end components
    
    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("Experiment");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public Experiment
  
  // start methods
  
  public static void main(String[] args) {
    launch(args);
  } // end of main
  


  // end methods
} // end of class Experiment
