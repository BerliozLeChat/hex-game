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
        existeChemin(plateau,joueura);
        relieComposante(plateau,joueura);
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
        System.out.println("Résultat attendu : 16, 121");
        System.out.print("Résultat :");
        for(int i : joueura.getClasseUnion().afficheComposante(5))
            System.out.print(" " + i);
        System.out.println("\n----------------------------------------------------------------------");
    }

    public static void calculDistance(Plateau plateau, Joueur joueura, Joueur joueurb){
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Test de calculDistance (1,5) et (3,5)");
        System.out.println("Le joueur B place un pion en (2,5)");
        plateau.setDispo(2,5,'B');
        joueurb.ajoutePion(27);
        plateau.afficher();
        System.out.println("Le résultat attendu est 2. Résultat : " + plateau.calculDistance(0, 5, 3, 5, 'A', joueura));
    }

    public static void existeChemin(Plateau plateau, Joueur joueura){
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Test de existe chemin case (1,5) et (3,5)");
        System.out.println("Le résultat attendu est false. Résultat : " + joueura.existeCheminCase(16,38));
        System.out.println("Création d'un chemin entre (1,5) et (3,5)");
        plateau.setDispo(2, 6, 'A');
        joueura.ajoutePion(28);
        plateau.setDispo(1,6,'A');
        joueura.ajoutePion(17);
        plateau.afficher();
        System.out.println("Test de existe chemin case (1,5) et (3,5)");
        System.out.println("Le résultat attendu est true. Résultat : " + joueura.existeCheminCase(16,38));

        System.out.println("----------------------------------------------------------------------");

        System.out.println("chemin entre 2 extrémités");
        joueura.existeCheminCotes();
        System.out.println("Le résultat attendu est false. Résultat : " + joueura.fini());

        System.out.println("----------------------------------------------------------------------");
        plateau.setDispo(4, 5, 'A');
        joueura.ajoutePion(49);
        plateau.setDispo(5,5,'A');
        joueura.ajoutePion(60);
        plateau.setDispo(6,5,'A');
        joueura.ajoutePion(71);
        plateau.setDispo(7,5,'A');
        joueura.ajoutePion(82);
        plateau.setDispo(8,5,'A');
        joueura.ajoutePion(93);
        plateau.setDispo(9,5,'A');
        joueura.ajoutePion(104);
        plateau.setDispo(10,5,'A');
        joueura.ajoutePion(115);

        System.out.println("Création d'un chemin...");
        plateau.afficher();
        System.out.println("chemin entre 2 extrémités");
        joueura.existeCheminCotes();
        System.out.println("Le résultat attendu est true. Résultat : " + joueura.fini());

        System.out.println("----------------------------------------------------------------------");
    }

    public static void relieComposante(Plateau plateau, Joueur joueura){
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Test de RelieComposante");
        System.out.println("Ajout d'une composante en (5,7), (5,8) et (5,9)");

        plateau.setDispo(5,7,'A');
        joueura.ajoutePion(62);
        plateau.setDispo(5,8,'A');
        joueura.ajoutePion(63);
        plateau.setDispo(5,9,'A');
        joueura.ajoutePion(64);
        plateau.afficher();
        System.out.println("La pose d'un pion en (3,4) entraine t-elle une liaison de composante.\n Résultat attendu false. Résultat : " + joueura.getClasseUnion().relieComposantes(37));

        System.out.println("La pose d'un pion en (5,6) entraine t-elle une liaison de composante.\n Résultat attendu true. Résultat : " + joueura.getClasseUnion().relieComposantes(61));
    }
}
