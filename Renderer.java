import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.Event;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.scene.input.KeyCombination;
import javafx.scene.*;
import javafx.collections.*;

//all this just to set the damn fucking background color
import javafx.scene.paint.Color;         
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.geometry.Insets;
import javafx.scene.layout.CornerRadii;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 10.10.2025
 * @author 
 */

public class Renderer extends Application 
{
  
  // start attributes
  Fussballfreundschaftsspiel game;
  private Mannschaft teamA;
  private Mannschaft teamB;
  
  private Color playerCardColor = Color.rgb(166, 177, 181);
  private float dropDownsY = 80.0f;
  private float dropDownAX = 10.0f;
  private float dropDownBX = 300.0f;
  private float playerCardsY = 200.0f;
  
  private MenuButton teamADropDown = new MenuButton();
  private MenuButton teamBDropDown = new MenuButton();
  
  private MenuItem[] teamAItems;
  private MenuItem[] teamBItems;
  
  private VBox playerCardA = new VBox();
  private VBox playerCardB = new VBox();
  
  private MenuButton menuButton1 = new MenuButton();
  private Spinner<Integer> spinner1 = new Spinner<>(0, 10, 0, 1);
  // end attributes
  @Override
  public void start(Stage primaryStage) { 
    Pane root = new Pane();
    Scene scene = new Scene(root, 443, 518);
    // start components
    
    teamADropDown.setLayoutX(dropDownAX);
    teamADropDown.setLayoutY(dropDownsY);
    teamADropDown.setFont(Font.font("Dialog", 11));
    teamADropDown.setText(teamA.getName());
    
    teamBDropDown.setLayoutX(dropDownBX);
    teamBDropDown.setLayoutY(dropDownsY);
    teamBDropDown.setFont(Font.font("Dialog", 11));
    teamBDropDown.setText(teamB.getName());
        
    playerCardA.setLayoutX(dropDownAX);
    playerCardA.setLayoutY(playerCardsY);
    playerCardA.setBackground(new Background(new BackgroundFill(playerCardColor, new CornerRadii(0.0f), new Insets(0.0f))));
    playerCardA.setSpacing(10);
    playerCardA.setPadding(new Insets(15));
    
    updatePlayerCard(teamA.getKader()[0], playerCardA);
    
    
    playerCardB.setLayoutX(dropDownBX);
    playerCardB.setLayoutY(playerCardsY);
    playerCardB.setBackground(new Background(new BackgroundFill(playerCardColor, new CornerRadii(0.0f), new Insets(0.0f))));
    playerCardB.setSpacing(10);
    playerCardB.setPadding(new Insets(15));

    updatePlayerCard(teamB.getKader()[0], playerCardB);
     
    for (int i = 0; i < teamAItems.length; ++i)
    {                                                                                                                                           
        teamADropDown.getItems().add(teamAItems[i]);
    }
    for (int i = 0; i < teamBItems.length; ++i)
    {
        teamBDropDown.getItems().add(teamBItems[i]);
    }
    
    for (int i = 0; i < teamAItems.length; ++i) 
    {
        final int j = i;
        teamAItems[i].setOnAction((event) ->
        {
         updatePlayerCard(teamA.getKader()[j], playerCardA);
        });
    }   
    for (int i = 0; i < teamBItems.length; ++i) 
    {
        final int j = i;
        teamBItems[i].setOnAction((event) ->
        {
         updatePlayerCard(teamB.getKader()[j], playerCardB);
        });
    } 
        
    root.getChildren().add(teamADropDown);
    root.getChildren().add(teamBDropDown);
    root.getChildren().add(playerCardA);
    root.getChildren().add(playerCardB);
    
    
    // end components
    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("Renderer");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public Renderer
  
  
  
  // start methods
  @Override
  public void init()
  {
   System.out.println("Calling init!");
   
   // **********************************************************************
    // Mannschaft 1
    Trainer t1     = new Trainer("Juergen Klinsmann", 34, 9);
    Torwart tw1    = new Torwart("J. Lehmann", 36, 8, 1, 9, 7);
    
    Spieler[] sp1  = new Spieler[10];
    sp1[0]         = new Spieler("P. Lahm", 23, 9, 5, 9);
    sp1[1]         = new Spieler("C. Metzelder", 25, 8, 2, 7);
    sp1[2]         = new Spieler("P. Mertesacker", 22, 9, 2, 8);
    sp1[3]         = new Spieler("M. Ballack", 29, 7, 5, 8);
    sp1[4]         = new Spieler("T. Borowski", 26, 9, 8, 9);
    sp1[5]         = new Spieler("D. Odoknor", 22, 7, 5, 8);
    sp1[6]         = new Spieler("B. Schweinsteiger", 22, 2, 3, 2);
    sp1[7]         = new Spieler("L. Podolski", 21, 7, 8, 9);
    sp1[8]         = new Spieler("M. Klose", 28, 10, 9, 7);
    sp1[9]         = new Spieler("O. Neuville", 33, 8, 8, 7);
    // **********************************************************************
    
    // **********************************************************************
    // Mannschaft 2
    Trainer t2     = new Trainer("Carlos Alberto Parreira", 50, 3);
    Torwart tw2    = new Torwart("Dida", 25, 9, 1, 6, 8);
    
    Spieler[] sp2  = new Spieler[10];
    sp2[0]         = new Spieler("Cafu", 33, 8, 4, 6);
    sp2[1]         = new Spieler("R. Carlos", 32, 9, 9, 2);
    sp2[2]         = new Spieler("Lucio", 29, 10, 9, 9);
    sp2[3]         = new Spieler("Ronaldinho", 25, 10, 9, 5);
    sp2[4]         = new Spieler("Zé Roberto", 27, 7, 7, 4);
    sp2[5]         = new Spieler("Kaká", 22, 10, 8, 10);
    sp2[6]         = new Spieler("Juninho", 26, 7, 10, 3);
    sp2[7]         = new Spieler("Adriano", 23, 8, 8, 4);
    sp2[8]         = new Spieler("Robinho", 19, 9, 8, 9);
    sp2[9]         = new Spieler("Ronaldo", 28, 4, 10, 2);
    // **********************************************************************
    
    teamA  = new Mannschaft("Deutschland WM 2006", t1, tw1, sp1);
    teamB  = new Mannschaft("Brasilien WM 2006", t2, tw2, sp2);
    game = new Fussballfreundschaftsspiel();
    
    teamAItems = new MenuItem[teamA.getKader().length];
    for (int i = 0; i < teamA.getKader().length; ++i) 
    {
        teamAItems[i] = new MenuItem();
        Spieler crntSpieler = teamA.getKader()[i];
        teamAItems[i].setText(crntSpieler.getName());  
    } 
    
    teamBItems = new MenuItem[teamB.getKader().length];
    for (int i = 0; i < teamB.getKader().length; ++i) 
    {
        teamBItems[i] = new MenuItem();
        Spieler crntSpieler = teamB.getKader()[i];
        teamBItems[i].setText(crntSpieler.getName());  
    }
  }
  public static void main(String[] args) {
    launch(args);
  } // end of main
  
  public void updatePlayerCard(Spieler newPlayer, VBox playerCard)
  {
         HBox nameBox = new HBox();
         nameBox.setSpacing(10);
         nameBox.setPadding(new Insets(15));
         Label nameLabel = new Label("Alter");
         TextField nameInput = new TextField(newPlayer.getName());
         nameBox.getChildren().addAll(nameLabel, nameInput);
         
         HBox alterBox = new HBox();
         nameBox.setSpacing(10);
         nameBox.setPadding(new Insets(15));
         Label alterLabel = new Label("Alter");
         TextField alterInput = new TextField(Integer.toString(newPlayer.getAlter()));
         alterBox.getChildren().addAll(alterLabel, alterInput);
         
         //HBox nameBox = new HBox();
         //nameBox.setSpacing(10);
         //nameBox.setPadding(new Insets(15));
         //Label nameLabel = new Label("Name");
         //TextField nameInput = new TextField(newPlayer.getName());
         //nameBox.getChildren().addAll(nameLabel, nameInput);
         //
         //HBox nameBox = new HBox();
         //nameBox.setSpacing(10);
         //nameBox.setPadding(new Insets(15));
         //Label nameLabel = new Label("Name");
         //TextField nameInput = new TextField(newPlayer.getName());
         //nameBox.getChildren().addAll(nameLabel, nameInput);
         //
         //HBox nameBox = new HBox();
         //nameBox.setSpacing(10);
         //nameBox.setPadding(new Insets(15));
         //Label nameLabel = new Label("Name");
         //TextField nameInput = new TextField(newPlayer.getName());
         //nameBox.getChildren().addAll(nameLabel, nameInput);
                  
         //String text = "";
         //text += "Name: " + newPlayer.getName() + "\n";
         //text += "Alter: " + newPlayer.getAlter() + "\n";
         //text += "Stärke: " + Integer.toString(newPlayer.getStaerke()) + "\n";
         //text += "Torschuss: " + Integer.toString(newPlayer.getTorschuss()) + "\n";
         //text += "Motivation: " + Integer.toString(newPlayer.getMotivation()) + "\n";
         //label.setText(text);
         
         playerCard.getChildren().clear();        //TODO: make this more efficient
         playerCard.getChildren().add(nameBox);
         playerCard.getChildren().add(alterBox);
  }


  // end methods
}
