package fr.insarouen.asi.prog.asiaventure.elements.objets;

/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

public class ObjetException extends ASIAventureException{

/**
 * Constructeur de ObjetException.
 *
 * @param msg Message d'erreur.
 */

  public ObjetException(String msg){
    super(msg);
  }

/**
 * Constructeur de ObjetException.
 */

  public ObjetException(){
  }
}
