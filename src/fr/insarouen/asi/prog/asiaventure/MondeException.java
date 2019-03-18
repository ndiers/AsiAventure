package fr.insarouen.asi.prog.asiaventure;

/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

public class MondeException extends ASIAventureException{

/**
 * Constructeur de MondeException.
 *
 * @param msg Message d'erreur.
 */

  public MondeException(String msg){
    super(msg);
  }

/**
 * Constructeur de MondeException.
 */

  public MondeException(){
  }
}
