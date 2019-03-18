package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.EtatDuJeu;
import java.io.*;

public abstract class ConditionDeFin implements Serializable{

  private EtatDuJeu etat;

  public ConditionDeFin(EtatDuJeu etatDuJeu){
    etat=etatDuJeu;
  }

  public EtatDuJeu getEtatConditionVerifiee(){
    return etat;
  }

  public abstract EtatDuJeu verifierCondition();
}
