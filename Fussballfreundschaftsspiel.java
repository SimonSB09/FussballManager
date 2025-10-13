import java.util.Random;

public class Fussballfreundschaftsspiel implements Freundschaftsspiel{
  private String nameHeimMannschaft;
  private String nameGastMannschaft;
  private int punkteHeim;
  private int punkteGast;    
  
  // Konstruktor
  public Fussballfreundschaftsspiel(){
    punkteHeim  = 0;
    punkteGast  = 0;
  }
  
  // Methoden des Interface, die implementiert werden müssen:
  public String getHeimMannschaft(){
    return nameHeimMannschaft;
  }
  
  public String getGastMannschaft(){
    return nameGastMannschaft;
  }
  
  public int getHeimPunkte(){
    return punkteHeim;
  }
  
  public int getGastPunkte(){
    return punkteGast;
  }
  
  // Ein Fussballfreundschaftsspiel zwischen beiden Mannschaften wird gestartet.
  void starteSpiel(Mannschaft m1, Mannschaft m2){
    nameHeimMannschaft   = m1.getName();
    nameGastMannschaft   = m2.getName();
    punkteHeim           = 0;
    punkteGast           = 0;
    
    // jetzt starten wir das Spiel und erzeugen für die 90 Minuten Spiel- plus
    // Nachspielzeit die verschiedenen Aktionen (wahrscheinlichkeitsbedingt) für
    // das Freundschaftsspiel
    Random r = new Random();
    
    boolean spiellaeuft  = true;
    int spieldauer       = 90 + r.nextInt(5);
    int zeit             = 1;
    int naechsteAktion;
    
    // solange das Spiel laeuft, koennen Torchancen entstehen...
    while (spiellaeuft){
      naechsteAktion = r.nextInt(15)+1;
      
      // Ist das Spiel schon zu Ende?
      if ((zeit + naechsteAktion>spieldauer)||(zeit>spieldauer)){
        spiellaeuft = false;
        break;
      }
      
      // ***************************************************************************
      // Eine neue Aktion findet statt...
      zeit = zeit + naechsteAktion;
      
      // Nun müssen wir entscheiden, wer einen Torschuss abgibt, wie stark er schiesst und
      // ob der Torwart den Ball hält. Das berechnen wir nach folgender Wahrscheinlichkeitsverteilung:
      
      // 1. wähle eine Mannschaft für eine Torchance aus, als Kriterien dienen Stärke und Motivation
      //    der Mannschaft sowie die Erfahrung des Trainers. Nach Berechnung aller Einflüsse hat die 
      //    bessere Mannschaft eine grössere Torchance.
      
      // Einfluss der Motivation auf die Stärke:
      float staerke_1 = (m1.getStaerke()/2.0f) + ((m1.getStaerke()/2.0f) * (m1.getMotivation()/10.0f));
      float staerke_2 = (m2.getStaerke()/2.0f) + ((m2.getStaerke()/2.0f) * (m2.getMotivation()/10.0f));
      
      // Einfluss des Trainers auf die Stärke ():
      int abweichung = r.nextInt(2);      
      if (staerke_1 > m1.getTrainer().getErfahrung())
      abweichung = -abweichung;           
      staerke_1 = Math.max(1, Math.min(10, staerke_1 + abweichung)); 
      
      abweichung = r.nextInt(2);    
      if (staerke_2 > m2.getTrainer().getErfahrung())
      abweichung = -abweichung;        
      staerke_2 = Math.max(1, Math.min(10, staerke_2 + abweichung));          
      
      // 2. wähle zufällig einen Spieler aus dieser Mannschaft, berechne den Torschuss und
      //    gib dem Torwart der anderen Mannschaft die Möglichkeit diesen Ball zu halten ...
      int schuetze   = r.nextInt(10);
      
      if ((r.nextInt(Math.round(staerke_1 + staerke_2))-staerke_1) <= 0){     
        Spieler s      = m1.getKader()[schuetze];
        Torwart t      = m2.getTorwart();               
        int torschuss  = s.schiesstAufTor();
        boolean tor    = !t.haeltDenSchuss(torschuss); // haelt er den Schuss?
        
        System.out.println();
        System.out.println(zeit+".Minute: ");
        System.out.println("   Chance fuer "+m1.getName()+" ...");
        System.out.println("   "+s.getName()+" zieht ab");
        
        if (tor) {
          punkteHeim++;
          s.addTor();
          System.out.println("   TOR!!!     "+punkteHeim+":"+punkteGast+" "+s.getName()+"("+s.getTore()+")");               
        } else {
          System.out.println("   "+m2.getTorwart().getName()+" pariert glanzvoll.");
        }
      } else{
        Spieler s      = m2.getKader()[schuetze];
        Torwart t      = m1.getTorwart();               
        int torschuss  = s.schiesstAufTor();
        boolean tor    = !t.haeltDenSchuss(torschuss);
        
        System.out.println();
        System.out.println(zeit+".Minute: ");
        System.out.println("   Chance fuer "+m2.getName()+" ...");
        System.out.println("   "+s.getName()+" zieht ab");
        
        if (tor) {
          punkteGast++;
          s.addTor();
          System.out.println("   TOR!!!     "+punkteHeim+":"+punkteGast+" "+s.getName()+"("+s.getTore()+")");               
        } else {
          System.out.println("   "+m1.getTorwart().getName()+" pariert glanzvoll.");
        }
      }
      // ***************************************************************************
    }
  }
  
  public String getErgebnisText(){
    return  "Das Freundschaftsspiel endete \n\n"+nameHeimMannschaft+" - "+nameGastMannschaft+" "+punkteHeim+":"+punkteGast+".";
  }
}