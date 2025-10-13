import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.Event;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.scene.input.KeyCombination;
import javafx.cene.*;
import javafx.geometry.Insets;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 10.10.2025
 * @author 
 */

public class Renderer extends Application {
  // start attributes
  
  Fussballfreundschaftsspiel game;
  private Mannschaft teamA;
  private Mannschaft teamB;
  private Spieler currentPlayer;
  
  private MenuItem[] teamAItems;
  private MenuItem[] teamBItems;
  
  private MenuButton teamADropDown = new MenuButton();
  private MenuButton teamBDropDown = new MenuButton();
  private Label playerCardA = new Label();
  private Label playerCardB = new Label();
  
  // end attributes
  @Override
  public void start(Stage primaryStage) { 
    Pane root = new Pane();
    Scene scene = new Scene(root, 443, 518);
    // start components
    
    teamADropDown.setLayoutX(300);
    teamADropDown.setLayoutY(80);
    teamADropDown.setFont(Font.font("Dialog", 11));
    teamADropDown.setText(teamA.getName());
    
    teamBDropDown.setLayoutX(10);
    teamBDropDown.setLayoutY(80);
    teamBDropDown.setFont(Font.font("Dialog", 11));
    teamBDropDown.setText(teamB.getName());
        
    playerCardA.setLayoutX(10);
    playerCardA.setLayoutY(200);
    playerCardA.setFont(Font.font("Dialog", 11));
    playerCardA.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0), new CornerRadii(1.0f), new Insets(1.0f))));
    playerCardA.setText("[NO PLAYE SELECTED YET]");
     
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
         currentPlayer = teamA.getKader()[j];
         updatePlayerCard(currentPlayer, playerCardA);
        });
    }   
    for (int i = 0; i < teamBItems.length; ++i) 
    {
        final int j = i;
        teamBItems[i].setOnAction((event) ->
        {
         currentPlayer = teamB.getKader()[j];
         updatePlayerCard(currentPlayer, playerCardB);
        });
    } 
        
    root.getChildren().add(teamADropDown);
    root.getChildren().add(teamBDropDown);
    root.getChildren().add(currentPlayerCard);
        
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
  
  public void updatePlayerCard(Spieler newPlayer, Label playerCard)
  {
     String text = "";
     text += "Name: " + newPlayer.getName() + "\n";
     text += "Alter: " + newPlayer.getAlter() + "\n";
     text += "Stärke: " + Integer.toString(newPlayer.getStaerke()) + "\n";
     text += "Torschuss: " + Integer.toString(newPlayer.getTorschuss()) + "\n";
     text += "Motivation: " + Integer.toString(newPlayer.getMotivation()) + "\n";
     playerCard.setText(text);
  }

   // end methods
} // end of class Renderer
