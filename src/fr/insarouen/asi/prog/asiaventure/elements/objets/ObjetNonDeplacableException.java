package fr.insarouen.asi.prog.asiaventure.elements.objets;

/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetException;

public class ObjetNonDeplacableException extends ObjetException{

/**
 * Constructeur de ObjetNonDeplacableException.
 *
 * @param msg Message d'erreur.
 */

  public ObjetNonDeplacableException(String msg){
    super(msg);
  }

/**
 * Constructeur de ObjetNonDeplacableException.
 */

  public ObjetNonDeplacableException(){
  }
}
