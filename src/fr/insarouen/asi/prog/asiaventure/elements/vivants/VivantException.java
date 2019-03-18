package fr.insarouen.asi.prog.asiaventure.elements.vivants;

/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

public class VivantException extends ASIAventureException{

/**
 * Constructeur de VivantException.
 *
 * @param msg Message d'erreur.
 */

  public VivantException(String msg){
    super(msg);
  }

/**
 * Constructeur de VivantException.
 */

  public VivantException(){
  }
}
