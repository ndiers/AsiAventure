package fr.insarouen.asi.prog.asiaventure;

import java.io.*;

public class Test {
  public static void main(String[] args) throws FileNotFoundException, IOException, NomDEntiteDejaUtiliseDansLeMondeException, Throwable{
    Simulateur sim = new Simulateur(new FileReader("Config.txt"));
    sim.executerJusquALaFin();
  }
}
