public class Trainer extends Person{
  // Zusätzliche Eigenschaften eines Trainers:
  private int erfahrung;
  
  // Konstruktoren
  public Trainer(String n, int a, int e){
    super(n,a);
    erfahrung   = e;
  }
  
  // Funktionen (get und set):
  public int getErfahrung(){
    return erfahrung;
  }
  
  public void setErfahrung(int e){
    erfahrung = e;
  }  
}