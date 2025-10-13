import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.event.Event;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 13.10.2025
 * @author 
 */

public class Experiment extends Application {
  // start attributes
  // end attributes
  
  public void start(Stage primaryStage) { 
    Pane root = new Pane();
    Scene scene = new Scene(root, 284, 262);
    // start components
    

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
