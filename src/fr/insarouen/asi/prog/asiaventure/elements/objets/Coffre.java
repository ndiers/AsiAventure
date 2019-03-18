package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Etat;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;



public class Coffre extends Objet implements Activable{

  private Etat etat;

  public Coffre (String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
    etat = Etat.FERME;

  }

  public boolean estDeplacable(){
    return false;
  }

  public boolean activableAvec(Objet obj){
    return false;
  }

  public void activer() throws ActivationException{
    if (etat==Etat.FERME){
      etat = Etat.OUVERT;
    }
    else{
      etat = Etat.FERME;
    }
  }

  public void activerAvec(Objet obj) throws ActivationException{

  }

  public Etat getEtat(){
    return etat;
  }
}
