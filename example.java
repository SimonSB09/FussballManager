import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.Event;
import javafx.scene.text.*;
import javafx.scene.text.Font;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 13.10.2025
 * @author 
 */

public class example extends Application {
  // start attributes
  private MenuButton menuButton1 = new MenuButton();
    private Menu menuButton1_Copy = new Menu("Copy");
      private MenuItem menuButton1_Copy_Numbered = new MenuItem("Numbered");
      private MenuItem menuButton1_Copy_RTF = new MenuItem("RTF");
    private SeparatorMenuItem menuButton1_Separator1 = new SeparatorMenuItem();
    private MenuItem menuButton1_Print = new MenuItem("Print");
    private MenuItem menuButton1_Save = new MenuItem("Save");
  // end attributes
  
  public void start(Stage primaryStage) { 
    Pane root = new Pane();
    Scene scene = new Scene(root, 284, 262);
    // start components
    
    menuButton1.setLayoutX(32);
    menuButton1.setLayoutY(40);
    menuButton1.setPrefHeight(24);
    menuButton1.setPrefWidth(80);
    menuButton1.setFont(Font.font("Dialog", 11));
    root.getChildren().add(menuButton1);
    menuButton1.getItems().add(menuButton1_Copy);
    menuButton1_Copy.getItems().add(menuButton1_Copy_Numbered);
    menuButton1_Copy.getItems().add(menuButton1_Copy_RTF);
    menuButton1.getItems().add(menuButton1_Separator1);
    menuButton1.getItems().add(menuButton1_Print);
    menuButton1.getItems().add(menuButton1_Save);
    menuButton1_Copy_Numbered.setOnAction(
      (event) -> {menuButton1_Copy_Numbered_Action(event);} 
    );
    menuButton1_Copy_RTF.setOnAction(
      (event) -> {menuButton1_Copy_RTF_Action(event);} 
    );
    menuButton1_Print.setOnAction(
      (event) -> {menuButton1_Print_Action(event);} 
    );
    menuButton1_Save.setOnAction(
      (event) -> {menuButton1_Save_Action(event);} 
    );
    // end components
    
    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("example");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public example
  
  // start methods
  
  public static void main(String[] args) {
    launch(args);
  } // end of main
  

  public void menuButton1_Copy_Numbered_Action(Event evt) {
    // TODO add your code here

  } // end of menuButton1_Copy_Numbered_Action

  public void menuButton1_Copy_RTF_Action(Event evt) {
    // TODO add your code here

  } // end of menuButton1_Copy_RTF_Action

  public void menuButton1_Print_Action(Event evt) {
    // TODO add your code here

  } // end of menuButton1_Print_Action

  public void menuButton1_Save_Action(Event evt) {
    // TODO add your code here

  } // end of menuButton1_Save_Action
  // end methods
} // end of class example
