package fr.insarouen.asi.prog.asiaventure.elements.structure;

/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;

public class ObjetAbsentDeLaPieceException extends PieceException{

/**
 * Constructeur de ObjetAbsentDeLaPieceException.
 *
 * @param msg Message d'erreur.
 */

  public ObjetAbsentDeLaPieceException(String msg){
    super(msg);
  }

/**
 * Constructeur de ObjetAbsentDeLaPieceException.
 */

  public ObjetAbsentDeLaPieceException(){
  }
}
