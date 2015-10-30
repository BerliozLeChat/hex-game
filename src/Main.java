import java.util.Scanner; 

public class Main {
    public static void main(String [] args) {
        Plateau plateau = new Plateau();
        Joueur joueura = new Joueur(0, "Sullivan");
        Joueur joueurb = new Joueur(1, "François");
		while( joueura.fini()!=true && joueurb.fini()!=true)
		{
			System.out.println(joueura.getNom_()+", c'est a vous de jouer, veuillez donner une coordonnée x et y ");
			int x,y;
			Scanner saisieUtilisateur = new Scanner(System.in); 
 			x = saisieUtilisateur.nextInt(); 
			y = saisieUtilisateur.nextInt();
			while(!( plateau.estDispo(x,y)=='o'))
			{
				System.out.println("La casse n'est pas disponible veuillez redonner des coordonés !!!"); 
 				x = saisieUtilisateur.nextInt(); 
				y = saisieUtilisateur.nextInt();
			}
			int z= x*11 + y;
			joueura.jouer(z);
			plateau.setDispo(x,y,'A');
			plateau.afficher();
			if( joueura.fini()!=true )
			{
				System.out.println(joueurb.getNom_()+", c'est a vous de jouer, veuillez donner une coordonnée x et y ");
				x = saisieUtilisateur.nextInt(); 
				y = saisieUtilisateur.nextInt();
				while(!( plateau.estDispo(x,y)=='o' ))
				{
					System.out.println("La casse n'est pas disponible veuillez redonner des coordonés !!!"); 
					x = saisieUtilisateur.nextInt(); 
					y = saisieUtilisateur.nextInt();
				}
				z= x + y*11;
				joueurb.jouer(z);
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
