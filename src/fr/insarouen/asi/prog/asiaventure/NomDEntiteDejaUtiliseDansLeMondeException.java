package fr.insarouen.asi.prog.asiaventure;

/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

import fr.insarouen.asi.prog.asiaventure.MondeException;

public class NomDEntiteDejaUtiliseDansLeMondeException extends MondeException{

/**
 * Constructeur de NomDEntiteDejaUtiliseDansLeMondeException.
 *
 * @param msg Message d'erreur.
 */

  public NomDEntiteDejaUtiliseDansLeMondeException(String msg){
    super(msg);
  }

/**
 * Constructeur de NomDEntiteDejaUtiliseDansLeMondeException.
 */

  public NomDEntiteDejaUtiliseDansLeMondeException(){
  }
}
