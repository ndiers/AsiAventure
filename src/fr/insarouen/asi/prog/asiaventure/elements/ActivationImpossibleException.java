package fr.insarouen.asi.prog.asiaventure.elements;

/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;

public class ActivationImpossibleException extends ActivationException{

/**
 * Constructeur de ActivationImpossibleException.
 *
 * @param msg Message d'erreur.
 */

  public ActivationImpossibleException(String msg){
    super(msg);
  }

/**
 * Constructeur de ActivationImpossibleException.
 */

  public ActivationImpossibleException(){
  }
}
