package fr.insarouen.asi.prog.asiaventure.elements.structure;

/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurelException;

public class PieceException extends ElementStructurelException{

/**
 * Constructeur de PieceException.
 *
 * @param msg Message d'erreur.
 */

  public PieceException(String msg){
    super(msg);
  }

/**
 * Constructeur de PieceException.
 */

  public PieceException(){
  }
}
