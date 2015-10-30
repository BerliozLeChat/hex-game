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
			while(!( plateau.estDispo(x,y,false)))
			{
				System.out.println("La casse n'est pas disponible veuillez redonner des coordonés !!!"); 
 				x = saisieUtilisateur.nextInt(); 
				y = saisieUtilisateur.nextInt();
			}
			System.out.println(x+" "+y);
			int z= x*11 + y;
			System.out.println(z);
			joueura.jouer(z);
			System.out.println("Beuggg2ee");
			plateau.setDispo(x,y,false);
			plateau.afficher();
		}
    }
}
