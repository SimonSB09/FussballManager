import java.util.Random;

public class Torwart extends Spieler{
  // Zusätzliche Eigenschaften eines Torwarts:
  private int reaktion;
  
  // Konstruktoren
  public Torwart(String n, int a, int s, int t, int m, int r){
    super(n, a, s, t, m);
    reaktion    = r;
  }
  
  // Funktionen (get und set):
  public int getReaktion(){
    return reaktion;
  }
  
  public void setReaktion(int r){
    reaktion = r;
  }  
  
  // Torwartfunktionen:
  
  // Als Parameter erhält der Torwart die Torschussstärke und nun muss
  // entschieden werden, ob der Torwart hält oder nicht
  public boolean haeltDenSchuss(int schuss){      
    Random r = new Random();
    int ret = Math.max(1, Math.min(10, reaktion + r.nextInt(3)-1));  // +-1 ist hier die Varianz
    if (ret>=schuss)
    return true;  // gehalten
    else
    return false; // TOR!!!
  }  
}