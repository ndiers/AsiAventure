package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import java.util.*;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;



/**
 *
 * @author N. DIERS, M. LIVNEY
 * @version 0.1
 */

public abstract class Vivant extends Entite {

  /**
	 * Nombre de point de vie du Vivant.
	 */
  private int pointVie;

  /**
	 * Nombre de point de force du Vivant.
	 */
  private int pointForce;

  /**
	 * Piece dans laquelle se situe le Vivant.
	 */
  private Piece piece;

  /**
	 * Tableau des Objets détenus par le Vivant "inventaire".
	 */
  private Map<String,Objet> objets;

  /**
	 * Constructeur de Vivant.
	 *
	 * @param nom Nom du Vivant.
	 * @param monde Monde dans lequel se situe le Vivant.
	 * @param pointVie Nombre de points de vie du Vivant.
	 * @param pointForce Nombre de points de force du Vivant.
	 * @param piece Piece dans laquelle se situe le Vivant.
	 * @param objets Tableau regroupant les objets que détient le Vivant : "inventaire".
	 *
	 * @throws NomDEntiteDejaUtiliseDansLeMondeException
	 * Si le nom de l'entite est deja present dans le monde.
	 */
  public Vivant(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet... nvObjets) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom, monde);
    this.pointVie = pointVie;
    this.pointForce = pointForce;
    objets = new HashMap<String,Objet>();
    for (Objet obj:nvObjets) {
      objets.put(obj.getNom(),obj);
    };
    this.piece = piece;
    piece.entrer(this);
  }



  private boolean contientObjet(String nomObj){
    return objets.containsKey(nomObj);
  }

  /**
	 * Permet de tester si un <code>Objet</code> est présent dans l'inventaire.
	 *
	 * @param obj Objet a tester
	 * @return Est contenu dans l'inventaire ou non.
	 */
  public boolean possede(Objet obj){
    return contientObjet(obj.getNom());
  }

  /**
	 * Permet au Vivant de déposer un de ses <code>Objets</code> depuis son nom dans la <code>Piece</code> dans laquelle il se trouve.
	 *
	 * @param nomObj Nom de l'<code>Objet</code> a déposer.
	 *
	 * @throws ObjetNonPossedeParLeVivantException
	 * Si le vivant ne poss�de pas l'objet.
	 */
  public Objet deposer(String nomObj) throws ObjetNonPossedeParLeVivantException{
    if (!(contientObjet(nomObj))){
      throw new ObjetNonPossedeParLeVivantException("l'objet "+nomObj+" n'est pas possédé par le vivant");
    }
    Objet res=objets.remove(nomObj);
    piece.deposer(res);
    return res;
  }

  /**
	 * Permet au Vivant de déposer un de ses <code>Objets</code> dans la <code>Piece</code> dans laquelle il se trouve.
	 *
	 * @param obj <code>Objet</code> a déposer.
	 *
	 * @throws ObjetNonPossedeParLeVivantException
	 * Si le vivant ne poss�de pas l'objet.
	 */
  public Objet deposer(Objet obj) throws ObjetNonPossedeParLeVivantException{
    return deposer(obj.getNom());
  }

  public void prendre(String nomObj) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
      objets.put(nomObj, piece.retirer(nomObj));
  }

  /**
	 * Permet de récupérer un Objet de la Piece, l'enlever de la Piece et de l'ajouter dans l'inventaire.
	 *
	 * @param obj Objet a ajouter à l'inventaire et à retirer de la Piece.
	 *
	 * @throws ObjetAbsentDeLaPieceException
	 * Si l'objet n'est pas dans la piece.
	 *
	 * @throws ObjetNonDeplacableException
	 * Si l'objet n'est pas deplacable.
	 */
  public void prendre(Objet obj) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
    prendre(obj.getNom());
  }

  /**
	 * Permet de tester si il reste des pointVie au Vivant
	 *
	 * @return PointVie vallent 0
	 */
  public boolean estMort(){
    return(pointVie==0);
  }

  /**
	 * Permet d'obtenir les objets du Vivant
	 */
  public Map<String,Objet> getObjets(){
    return objets;
  }

  /**
	 * Permet d'obtenir les pointVie du Vivant
	 */
  public  int getPointVie (){
    return pointVie;
  }

  public void setPointsDeVie(int pointVie){
   this.pointVie=pointVie;
 }

  /**
	 * Permet d'obtenir les pointForce du Vivant
	 */
  public  int getPointForce (){
    return pointForce;
  }

  /**
	 * Permet d'obtenir la Piece où se situe le Vivant
	 */
  public Piece getPiece(){
    return piece;
  }

  /**
	 * Permet de récupérer un <code>Objet</code> de l'inventaire du <code>Vivant</code> depuis le nom de cet <code>Objet</code>.
	 *
	 * @param nomObjet Nom de l'<code>Objet</code> a récupérer.
	 * @return <code>Objet</code> récupérer depuis le paramètre.
	 */
  public Objet getObjet(String nomObjet){
    return objets.get(nomObjet);
  }

  public String toString(){
    String res = this.getNom();
    res = String.format("%s,%s,%d,%d,%s",res,getMonde().getNom(),pointVie,pointForce,getPiece().getNom());
    for (String str:objets.keySet()) {
      res=String.format("%s,%s",res,str);
    }
    return res;
  }

  public void franchir(String nomPorte){
    try{
      piece.sortir(getNom());
    }
    catch(VivantAbsentDeLaPieceException e){
      e.printStackTrace();
    }
    this.piece=piece.getPorte(nomPorte).getPieceAutreCote(piece);
    this.piece.entrer(this);
  }

  public void franchir(Porte porte) throws VivantAbsentDeLaPieceException{
    franchir(porte.getNom());
  }


}
