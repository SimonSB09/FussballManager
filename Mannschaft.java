public class Mannschaft{
  // Eigenschaften einer Mannsch:
  private String name;
  private Trainer trainer;
  private Torwart torwart;
  private Spieler[] kader;
  
  // Konstruktoren
  public Mannschaft(String n, Trainer t, Torwart tw, Spieler[] s){
    name     = n;
    trainer  = t;
    torwart  = tw;
    kader    = s;
  }
  
  // Funktionen (get und set):
  public String getName(){
    return name;
  }
  
  public void setName(String n){
    name = n;
  }  
  
  public Trainer getTrainer(){
    return trainer;
  }
  
  public void setTrainer(Trainer t){
    trainer = t;
  }  
  
  public Torwart getTorwart(){
    return torwart;
  }
  
  public void setTorwart(Torwart tw){
    torwart = tw;
  }  
  
  public Spieler[] getKader(){
    return kader;
  }
  
  public void setSpieler(Spieler[] s){
    kader = s;
  }  
  
  // Mannschaftsfunktionen:
  
  // liefert die durchschnittliche Mannschaftsstaerke
  public int getStaerke(){
    int summ = 0;
    for (int i=0; i<10; i++)
    summ += kader[i].getStaerke();
    return summ/10;
  }
  
  // liefert die durchschnittliche Mannschaftsmotivation
  public int getMotivation(){
    int summ = 0;
    for (int i=0; i<10; i++)
    summ += kader[i].getMotivation();
    return summ/10;
  }  
}