import java.util.Random;

public class Spieler extends Person{
  // Zusätzliche Eigenschaften eines Spielers:
  private int staerke;      // von 1 (schlecht) bis 10 (super)
  private int torschuss;    // von 1 (schlecht) bis 10 (super)
  private int motivation;   // von 1 (schlecht) bis 10 (super)
  private int tore;
  
  // Konstruktoren
  public Spieler(String n, int a, int s, int t, int m){
    super(n, a);
    staerke     = s;
    torschuss   = t;
    motivation  = m;
    tore        = 0;
  }
  
  // Funktionen (get und set):
  public int getStaerke(){
    return staerke;
  }
  
  public void setStaerke(int s){
    staerke = s;
  }  
  
  public int getTorschuss(){
    return torschuss;
  }
  
  public void setTorschuss(int t){
    torschuss = t;
  }     
  
  public int getMotivation(){
    return motivation;
  }
  
  public void setMotivation(int m){
    motivation = m;
  }     
  
  public int getTore(){
    return tore;
  }
  
  public void addTor(){
    tore++;
  }     
  
  // Spielerfunktionen:
  
  // eine Zahl von 1-10 liefert die Qualität des Torschusses mit einem kleinen
  // Zufallswert +1 oder -1
  public int schiesstAufTor(){     
    Random r = new Random();
    // Entfernungspauschale :)
    torschuss = Math.max(1, Math.min(10, torschuss - r.nextInt(3)));
    int ret = Math.max(1, Math.min(10, torschuss + r.nextInt(3)-1));  // +-1 ist hier die Varianz
    return ret;
  }
}