import hexgame.Joueur;
import hexgame.Plateau;
import java.util.*;

import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Plateau plateau = new Plateau();
        Joueur joueura = new Joueur(0, "Sullivan",true);
        Joueur joueurb = new Joueur(1, "François",false);

        int z= 5*11 + 5;
        joueura.ajoutePion(z);
        plateau.setDispo(5,5,'A');

        z= 5*11 + 7;
        joueura.ajoutePion(z);
        plateau.setDispo(5,7,'A');

        z= 5*11 + 6 ;
        joueurb.ajoutePion(z);
        plateau.setDispo(5,6,'B');
/*
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

        plateau.afficher();
        System.out.println(plateau.calculDistance(5, 5,5,7, 'A', joueura));
        System.out.println(plateau.calculDistance(5, 5,6,7, 'A', joueura));
        System.out.println(plateau.calculDistance(5, 5,8,7, 'A', joueura));
        System.out.println(plateau.calculDistance(5, 5,9,7, 'A', joueura));
        System.out.println(plateau.calculDistance(5, 5,10,7, 'A', joueura));
        System.out.println(plateau.calculDistance(5, 5,5,10, 'A', joueura));






        /*for(int i : plateau.voisin(4,5))
            System.out.println(Integer.toString(i));*/
       // System.out.println(plateau.calculDistance(0,0,0,0,'A',joueura));


       /* ArrayList<Integer> list = plateau.voisin(1,1);//joueura.classe(0);//getClasseUnion().afficheComposante(0);
        for(Integer i : list)
            System.out.println(Integer.toString(i));*/


        //joueDeuxHumains(joueura,joueurb,plateau);
       // joueOrdiHumain(joueura,plateau);
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
        int distancexmin = 100;
        int distanceymin=100;
        ArrayList<Integer> bordx = new ArrayList<Integer>();
        ArrayList<Integer> bordy = new ArrayList<Integer>();
        ArrayList<Integer> bordxadver = new ArrayList<Integer>();
        ArrayList<Integer> bordyadver = new ArrayList<Integer>();
        int i;
        int y = pion%11;
        int x = (pion-y)/11;
        int y2;
        int x2;
        if(ordi.getdirection())
        {
            for(i=0; i<11;++i)
            {
                if(plateau.getPlateau_()[i/11][i]=='o')
                    bordx.add(i);
            }
            for(i=110;i<121;++i)
            {
                if(plateau.getPlateau_()[i/11][i%11]=='o')
                    bordy.add(i);
            }
            i=0;
            while(i<111)
            {
                if(plateau.getPlateau_()[i/11][i%11]=='o')
                {
                    bordxadver.add(i);
                }
                i=i+11;
            }
            i=10;
            while(i<121)
            {
                if(plateau.getPlateau_()[i/11][i%11]=='o')
                    bordyadver.add(i);
                i=i+11;
            }
        }else{
            i=0;
            while(i<111)
            {
                if(plateau.getPlateau_()[i/11][i%11]=='o')
                {
                    bordx.add(i);
                }
                i=i+11;
            }
            i=10;
            while(i<121)
            {
                if(plateau.getPlateau_()[i/11][i%11]=='o')
                    bordy.add(i);
                i=i+11;
            }
            for(i=0; i<11;++i)
            {
                if(plateau.getPlateau_()[i/11][i]=='o')
                    bordxadver.add(i);
            }
            for(i=110;i<121;++i)
            {
                if(plateau.getPlateau_()[i/11][i%11]=='o')
                    bordyadver.add(i);
            }
        }
        i=0;
        while(i<bordx.size())
        {  
            y2=bordx.get(i)%11;
            x2=(bordx.get(i)-y2)/11;
            if(distancexmin > plateau.calculDistance(x,y,x2,y2,'B',ordi))
                distancexmin = plateau.calculDistance(x,y,x2,y2,'B',ordi);
            ++i;
        }
        i=0;
        while(i<bordy.size())
        {
            y2=bordy.get(i)%11;
            x2=(bordy.get(i)-y2)/11;
            if(distanceymin > plateau.calculDistance(x,y,x2,y2,'B',ordi))
                distanceymin = plateau.calculDistance(x,y,x2,y2,'B',ordi);
            ++i;
        }

        int distance = distanceymin+distancexmin;
        //System.out.println("distancex "+distancexmin+" distancey "+distanceymin);
        if( distance == 1 )
        {
            estimation = 0;
        }
        else
        {
            estimation = estimation +distance;
            if(plateau.getPlateau_()[x][y]!='B')
                estimation=estimation-1;
        }
        int distancexminadver=100;
        int distanceyminadver=100;
        int distanceadver;
        i=0;
        while(i<bordxadver.size())
        {
            y2=bordxadver.get(i)%11;
            x2=(bordxadver.get(i)-y2)/11;
            if(distancexminadver > plateau.calculDistance(x,y,x2,y2,'A',joueur))
                distancexminadver = plateau.calculDistance(x,y,x2,y2,'A',joueur);
            ++i;
        }
        i=0;
        while(i<bordyadver.size())
        {
            y2=bordyadver.get(i)%11;
            x2=(bordyadver.get(i)-y2)/11;
            if(distanceyminadver > plateau.calculDistance(x,y,x2,y2,'A',joueur))
                distanceyminadver = plateau.calculDistance(x,y,x2,y2,'A',joueur);
            ++i;
        }
        distanceadver = distanceyminadver + distancexminadver;
        if(distanceadver==1)
        {
            estimation=2;
        }else
        {
            if(estimation!=1)
            {
                if(distanceadver<distance)
                {
                    estimation=estimation+distanceadver-20;
                    if(plateau.getPlateau_()[x][y]!='A')
                        estimation=estimation-1;
                }
            }
        }
        //System.out.println("estimation !!!"+ distance + " advers : "+ distanceadver);
        return estimation;
   }

     public static int pionleplusavantageux(Joueur ordi, Joueur joueur, Plateau plateau){
        char nom = 'B';//ordi.getnom();
        int estimationmin=1000;
        int estim;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i;
        //System.out.println("estimation !!!");
        for(i=1; i<121;i++)
        {
            if(plateau.getPlateau_()[i/11][i%11]=='o'&&plateau.getPlateau_()[i/11][i%11]!='B'&&plateau.getPlateau_()[i/11][i%11]!='A')
            {
                //System.out.println("le pion est : "+plateau.getPlateau_()[i/11][i%11]);
                //System.out.println("pion  : "+i);
                estim= evaluerPionZ(ordi, joueur, plateau, i);
                //System.out.println("estimation x : "+i/11+" y : "+ i%11+ " estimation "+estim+"estimin "+estimationmin);
                if(estimationmin>estim)
                {
                    list.clear();
                    estimationmin=estim;
                    list.add(i);
                }else if(estimationmin==estim&&i/11<list.get(0)&&i/11>list.get(0))
                    {
                        list.add(i);
                    }
            }
        }
        int pion = list.get(0);
        ArrayList<Integer> bordx = new ArrayList<Integer>();
        ArrayList<Integer> bordy = new ArrayList<Integer>();
        int distancebut1=100;
        int distancebut2=100;
        int distance =100;
        int j;
        int x2,y2,x,y;
        for(i=0; i<11;++i)
        {
            if(plateau.getPlateau_()[i/11][i]=='o')
                bordx.add(i);
        }
        for(i=110;i<121;++i)
        {
            if(plateau.getPlateau_()[i/11][i%11]=='o')
                bordy.add(i);
        }
        for(i=0;i<list.size();++i)
        {
            y=list.get(i)%11;
            x=(list.get(i)-y)/11;            
            for(j=0;j<bordx.size();++j)
            {
                y2=bordx.get(j)%11;
                x2=(bordx.get(j)-y2)/11;
                if(distancebut1 > plateau.calculDistance(x,y,x2,y2,'A',joueur))
                    distancebut1 = plateau.calculDistance(x,y,x2,y2,'A',joueur);
            }
            for(j=0;j<bordy.size();++j)
            {
                y2=bordy.get(j)%11;
                x2=(bordy.get(j)-y2)/11;
                if(distancebut2 > plateau.calculDistance(x,y,x2,y2,'A',joueur))
                    distancebut2 = plateau.calculDistance(x,y,x2,y2,'A',joueur);
            }
            if(distance>distancebut1+distancebut2)
            {
                pion = list.get(i);
            }
        }
       // System.out.println("FINAL : estimation x : "+pion/11+" y : "+ pion%11+ "estimin "+estimationmin);
        System.out.println("Le Bot vient d'ajouter le pion : "+pion/11+"-"+pion%11+".");
        return pion;
    }

    public static void joueOrdiHumain(Joueur joueura, Plateau plateau){
       Joueur joueurb = new Joueur(1, "Ordinateur",false);
       int pion;
       int x,y,z;          
        pion=5*11+5;
        joueurb.ajoutePion(pion);
        joueurb.existeCheminCotes();
        plateau.setDispo(pion/11,pion%11,'B');
        plateau.afficher();
        while( joueura.fini()!=true && joueurb.fini()!=true)
        {
            System.out.println(joueura.getNom_()+", c'est à vous de jouer, veuillez saisir les coordonnées x et y ");
            Scanner saisieUtilisateur = new Scanner(System.in);
            x = saisie(saisieUtilisateur);
            y = saisie(saisieUtilisateur);
            while( !verificationCoordonnees(x,y) || !( plateau.estDispo(x,y)=='o'))
            {
                System.out.println("La case n'est pas disponible veuillez redonner des coordonnées !!!");
                x = saisie(saisieUtilisateur);
                y = saisie(saisieUtilisateur);
            }
            z= x*11 + y;
            joueura.ajoutePion(z);
            joueura.existeCheminCotes();
            plateau.setDispo(x,y,'A');
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
