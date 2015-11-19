import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Plateau plateau = new Plateau();
        Joueur joueura = new Joueur(0, "Sullivan");
        Joueur joueurb = new Joueur(1, "François");

        int z= 0*11 + 5;
        joueura.ajoutePion(z);
        plateau.setDispo(0,5,'A');

        z= 0*11 + 6;
        joueura.ajoutePion(z);
        plateau.setDispo(0,6,'A');

        z= 1*11 + 5;
        joueura.ajoutePion(z);
        plateau.setDispo(1,5,'A');

        z= 4*11 + 5;
        joueura.ajoutePion(z);
        plateau.setDispo(4,5,'A');

        System.out.println(plateau.calculDistance(1,5,4,5,'A',joueura));

        plateau.afficher();
        ArrayList<Integer> list = joueura.getClasseUnion().afficheComposante(5);
        /*for(Integer i : list)
            System.out.println(Integer.toString(i));*/

        for(int i : plateau.voisin(1,1))
            System.out.println(Integer.toString(i));
        //joueDeuxHumains(joueura,joueurb,plateau);

    }

    public static boolean verificationCoordonnees(int x,int y){
        return x>=-1&&x<11 && y>=-1&&y<11?true:false;
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
        while( joueura.fini()!=true && joueurb.fini()!=true)
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
            if( joueura.fini()!=true )
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
        if(joueura.fini()==true)
        {
            System.out.println(joueura.getNom_()+" a gagné !! ");
        }else{
            System.out.println(joueurb.getNom_()+" a gagné !! ");
        }
    }
}
