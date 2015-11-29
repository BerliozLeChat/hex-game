import hexgame.Joueur;
import hexgame.Plateau;

import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Plateau plateau = new Plateau();
        Joueur joueura = new Joueur(0, "Sullivan",true);
        Joueur joueurb = new Joueur(1, "François",false);

        int z;/*= 4*11 + 5;
        joueura.ajoutePion(z);
        plateau.setDispo(4,5,'A');*/

        /*z= 3*11 + 6;
        joueura.ajoutePion(z);
        plateau.setDispo(3,5,'A');*/

        /*z= 0*11 + 0 ;
        joueura.ajoutePion(z);
        plateau.setDispo(0,0,'A');

        z= 3*11 + 10 ;
        joueura.ajoutePion(z);
        plateau.setDispo(3,10,'A');

        z= 10*11 + 10;
        joueura.ajoutePion(z);
        plateau.setDispo(10,10,'A');*/
/*
        z= 9*11 + 10;
        joueura.ajoutePion(z);
        plateau.setDispo(9,10,'A');
        

        z= 8*11 + 10;
        joueura.ajoutePion(z);
        plateau.setDispo(8,10,'A');
        
        z= 7*11 + 10;
        joueura.ajoutePion(z);
        plateau.setDispo(7,10,'A');
        
        z= 6*11 + 10;
        joueura.ajoutePion(z);
        plateau.setDispo(6,10,'A');
        
        z= 5*11 + 10;
        joueura.ajoutePion(z);
        plateau.setDispo(5,10,'A');
        

        z= 4*11 + 10;
        joueura.ajoutePion(z);
        plateau.setDispo(4,10,'A');
        */

        /*plateau.afficher();
        /*for(int i : plateau.voisin(4,5))
            System.out.println(Integer.toString(i));*/
       // System.out.println(plateau.calculDistance(0,0,0,0,'A',joueura));


       /* ArrayList<Integer> list = plateau.voisin(1,1);//joueura.classe(0);//getClasseUnion().afficheComposante(0);
        for(Integer i : list)
            System.out.println(Integer.toString(i));*/


        //joueDeuxHumains(joueura,joueurb,plateau);
        joueOrdiHumain(joueura,plateau);
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

    public static int evaluerPionZ(Joueur ordi, Joueur joueur, Plateau plateau, int pion){
        int estimation = 50;
        int distance_droite = plateau.calculDistance(pion/11, pion%11,0,0, 'B', ordi);
        int distance_gauche = plateau.calculDistance(pion/11, pion%11,10,10, 'B', ordi);
        estimation= estimation+distance_gauche+distance_droite;
        int distance_haut_autre = plateau.calculDistance(pion/11, pion%11,0,0, 'A', joueur);
                 System.out.println("entré x : "+pion);
        int distance_bas_autre = plateau.calculDistance(pion/11, pion%11,10,10, 'A', joueur); 
        if(distance_haut_autre<2&&distance_bas_autre<2)
        {
            return 0;
        }else
        {
            estimation=estimation-15+distance_haut_autre+distance_bas_autre;
        }   
        return estimation;
   }

    public static int pionleplusavantageux(Joueur ordi, Joueur joueur, Plateau plateau){
        int estimationmin=evaluerPionZ(ordi, joueur, plateau, 0);
        int pion=0;
        int estim;
        for(int i=1; i<121;i++)
        {
            if(plateau.getPlateau_()[i/11][i%11]=='o')
            {
                pion=i;
                System.out.println("pion  : "+i);
                estim= evaluerPionZ(ordi, joueur, plateau, i);
                System.out.println("estimation x : "+pion/11+" y : "+ pion%11+ " estimation "+estim);
                if(estimationmin>estim)
                {
                    estimationmin=estim;
                    pion=i;
                }
            }
        }
        return pion;
    }

    public static void joueOrdiHumain(Joueur joueura, Plateau plateau){
       Joueur joueurb = new Joueur(1, "Ordinateur",false);
       plateau.afficher();
       int pion;
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
            System.out.println(plateau.calculDistance(0,0,10,10,'B',joueurb));
            if( joueura.fini()!=true )
            {                
                pion=pionleplusavantageux(joueurb, joueura, plateau);
                joueurb.ajoutePion(pion);
                joueurb.existeCheminCotes();
                plateau.setDispo(pion/11,pion%11,'B');
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

    public static void joueDeuxHumains(Joueur joueura, Joueur joueurb, Plateau plateau){
        plateau.afficher();
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
            System.out.println(plateau.calculDistance(11,0,0,0,'B',joueurb));
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
