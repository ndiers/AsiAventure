package fr.insarouen.asi.prog.asiaventure;



public class Main{

  public static void main(String[] args){
    System.out.println("--- Menu ---");
    System.out.println("1/ jouer");
    System.out.println("2/ charger un fichier de description");
    System.out.println("3/ sauver la partie actuelle");
    System.out.println("4/ charger une partie");
    System.out.println("5/ quitter");
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    Monde monde = new Monde("monde");
    Simulateur simulateur = new Simulateur(monde);
    switch (x){
      case 1 : break;
      case 2 : chargerFichier();
      break;
      case 3 : sauver();
      break;
      case 4 : chargerPartie();
      break;
      case 5 : break;
      break;
    }
  }

  private void chargerFichier(){
    System.out.println("Entrez le fichier à charger :");
    Scanner sc2 = new Scanner(System.in);
    Reader reader = sc2.next();

  }

  private void sauver(){
    System.out.println("5/ quitter");
  }

  private void chargerPartie(){
    System.out.println("5/ quitter");
  }
}
