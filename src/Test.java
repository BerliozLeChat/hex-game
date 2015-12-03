import hexgame.Joueur;
import hexgame.Plateau;

import java.util.Scanner;

public class Test {
    public static void main(String [] args) {
        Plateau plateau = new Plateau();
        Joueur joueura = new Joueur(0, "Sullivan",true);
        Joueur joueurb = new Joueur(1, "François",false);
        AjoutPion(plateau,joueura);
        afficheComposante(plateau,joueura);
        calculDistance(plateau,joueura,joueurb);
    }

    public static void AjoutPion(Plateau plateau,Joueur joueura){
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Test de l'ajout d'un pion");
        System.out.println("Le joueur A place un pion en (0,5)");
        plateau.setDispo(0,5,'A');
        joueura.ajoutePion(5);
        plateau.afficher();
        System.out.println("----------------------------------------------------------------------");
    }

    public static void afficheComposante(Plateau plateau,Joueur joueura){
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Test de l'affichage d'une composante");
        System.out.println("Le joueur A place un pion en (1,5)");
        plateau.setDispo(1,5,'A');
        joueura.ajoutePion(16);
        System.out.println("Le joueur A place un pion en (3,5)");
        plateau.setDispo(3,5,'A');
        joueura.ajoutePion(38);
        plateau.afficher();
        //Cette composante devrai contenir le pion 16 et 121 (121, le bord supérieur du plateau)
        for(int i : joueura.getClasseUnion().afficheComposante(5))
            System.out.println(i);
        System.out.println("----------------------------------------------------------------------");
    }

    public static void calculDistance(Plateau plateau, Joueur joueura, Joueur joueurb){
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Test de calculDistance");
        System.out.println("Le joueur B place un pion en (2,5)");
        plateau.setDispo(2,5,'B');
        joueurb.ajoutePion(27);
        plateau.afficher();
        System.out.println(plateau.calculDistance(0, 5, 3, 5, 'A', joueura));
    }
}
