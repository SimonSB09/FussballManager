import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.Event;
import je.NumberField;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 15.10.2025
 * @author 
 */

public class Experiment extends Application {
  // start attributes
  private Button button1 = new Button();
  // end attributes
  
  public void start(Stage primaryStage) { 
    Pane root = new Pane();
    Scene scene = new Scene(root, 284, 262);
    // start components
    
    button1.setLayoutX(64);
    button1.setLayoutY(56);
    button1.setPrefHeight(24);
    button1.setPrefWidth(80);
    button1.setText("Button");
    button1.setOnAction(
      (event) -> {button1_Action(event);} 
    );
    button1.setFont(Font.font("Dialog", 11));
    root.getChildren().add(button1);
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
  




  public void button1_Action(Event evt) {
    // TODO add your code here
    
  } // end of button1_Action

  // end methods
} // end of class Experiment
