import hexgame.Joueur;
import hexgame.Plateau;

import java.util.Scanner;

public class HumainvsHumain {
    public static void main(String [] args) {
        Plateau plateau = new Plateau();
        Joueur joueura = new Joueur(0, "Sullivan",true);
        Joueur joueurb = new Joueur(1, "François",false);
        joueDeuxHumains(joueura,joueurb,plateau);

    }

    public static boolean verificationCoordonnees(int x,int y){
        return x>=-1&&x<11 && y>=-1&&y<11;
    }

    public static int saisie(Scanner scan){
        int a;
            while(!scan.hasNextInt()){
                System.out.println("Un entier est attendu");
                scan.next();
            }
            a = scan.nextInt();
        return a;
    }



    public static void joueDeuxHumains(Joueur joueura, Joueur joueurb, Plateau plateau){
        plateau.afficher();
        while( !joueura.fini() && !joueurb.fini())
        {
            System.out.println(joueura.getNom_()+", c'est à vous de jouer, veuillez saisir les coordonnées x et y ");
            int x,y;
            Scanner saisieUtilisateur = new Scanner(System.in);
            x = saisie(saisieUtilisateur);
            y = saisie(saisieUtilisateur);
            while( !verificationCoordonnees(x,y) || !( plateau.estDispo(x,y)=='o'))
            {
                System.out.println("La case n'est pas disponible veuillez redonner des coordonnées !!!");
                x = saisie(saisieUtilisateur);
                y = saisie(saisieUtilisateur);
            }
            int z= x*11 + y;
            joueura.ajoutePion(z);
            joueura.existeCheminCotes();
            plateau.setDispo(x,y,'A');
            plateau.afficher();
            System.out.println(plateau.calculDistance(11,0,0,0,'B',joueurb));
            if( !joueura.fini())
            {
                System.out.println(joueurb.getNom_()+", c'est à vous de jouer, veuillez saisir les coordonnées x et y ");
                x = saisie(saisieUtilisateur);
                y = saisie(saisieUtilisateur);
                while(!verificationCoordonnees(x,y) || !( plateau.estDispo(x,y)=='o'))
                {
                    System.out.println("La case n'est pas disponible veuillez redonner des coordonnées !!!");
                    x = saisie(saisieUtilisateur);
                    y = saisie(saisieUtilisateur);
                }
                z= x + y*11;
                joueurb.ajoutePion(z);
                joueurb.existeCheminCotes();
                plateau.setDispo(x,y,'B');
                plateau.afficher();
            }
        }
        if(joueura.fini())
        {
            System.out.println(joueura.getNom_()+" a gagné !! ");
        }else{
            System.out.println(joueurb.getNom_()+" a gagné !! ");
        }
    }
}
