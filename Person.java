public class Person{
  // Eigenschaften einer Person:
  private String name;
  private int alter;
  
  // Konstruktoren
  public Person(String n, int a){
    name  = n;
    alter = a;
  }
  
  // Funktionen (get und set):
  public String getName(){
    return name;
  }
  
  public void setName(String n){
    name = n;
  }  
  
  public int getAlter(){
    return alter;
  }
  
  public void setAlter(int a){
    alter = a;
  }  
}