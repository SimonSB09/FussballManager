public class FussballTestKlasse{
  public static void main(String[] args){
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
    
    Mannschaft m1  = new Mannschaft("Deutschland WM 2006", t1, tw1, sp1);
    Mannschaft m2  = new Mannschaft("Brasilien WM 2006", t2, tw2, sp2);
    Fussballfreundschaftsspiel f1 = new Fussballfreundschaftsspiel();
    
    System.out.println("------------------------------------------------------------------------------");
    System.out.println("Start des Freundschaftspiels zwischen");
    System.out.println();
    System.out.println(m1.getName());
    System.out.println("   Trainer: "+m1.getTrainer().getName());
    System.out.println();
    System.out.println("   und");
    System.out.println();
    System.out.println(m2.getName());
    System.out.println("   Trainer: "+m2.getTrainer().getName());
    System.out.println("------------------------------------------------------------------------------");
    
    f1.starteSpiel(m1, m2);
    
    System.out.println();
    System.out.println("------------------------------------------------------------------------------");
    System.out.println(f1.getErgebnisText());
    System.out.println("------------------------------------------------------------------------------");
  }
}