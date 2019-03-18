package fr.insarouen.asi.prog.asiaventure.elements;

/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;

public class ActivationImpossibleAvecObjetException extends ActivationImpossibleException{

/**
 * Constructeur de ActivationImpossibleAvecObjetException.
 *
 * @param msg Message d'erreur.
 */

  public ActivationImpossibleAvecObjetException(String msg){
    super(msg);
  }

/**
 * Constructeur de ActivationImpossibleAvecObjetException.
 */

  public ActivationImpossibleAvecObjetException(){
  }
}
