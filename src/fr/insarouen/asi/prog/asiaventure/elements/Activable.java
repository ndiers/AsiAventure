package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;


public interface Activable{

  public boolean activableAvec(Objet obj);
  public void activer() throws ActivationException;
  public void activerAvec(Objet obj) throws ActivationException;
}
