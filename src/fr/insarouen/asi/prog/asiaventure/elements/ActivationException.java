package fr.insarouen.asi.prog.asiaventure.elements;

/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

public class ActivationException extends ASIAventureException{

/**
 * Constructeur de ActivationException.
 *
 * @param msg Message d'erreur.
 */

  public ActivationException(String msg){
    super(msg);
  }

/**
 * Constructeur de ActivationException.
 */

  public ActivationException(){
  }
}
