import java.util.*;

/**
 * Created by E115986X on 12/10/15.
 */
public class Plateau {

    private char[][] plateau_;

    public Plateau(){
        plateau_ = new char[11][11];
        for(int i = 0;i<11;++i){
            for(int j= 0;j<11;++j){
                plateau_[i][j] = 'o';
            }
        }
    }

    public char[][] getPlateau_() {
        return plateau_;
    }

    public char estDispo(int i, int j){
        return plateau_[i][j];
    }

    public void setDispo(int i, int j, char nom){
            plateau_[i][j] = nom;
    }
	
	public void afficher(){
		for(int i =0; i<11;++i)
		{
			System.out.println("|"+ plateau_[i][0]+"|"+plateau_[i][1]+"|"+plateau_[i][2]+"|"+plateau_[i][3]+"|"+plateau_[i][4]+"|"+plateau_[i][5]+"|"+plateau_[i][6]+"|"+plateau_[i][7]+"|"+plateau_[i][8]+"|"+plateau_[i][9]+"|"+plateau_[i][10]+"|");
		}	
	}

    //calculDistance dans plateau car il est nécessaire d'avoir la vision d'ensemble de celui ci. cad on a besoin de savoir a qui appartiennent les cases.
    public void calculDistance(int x1, int y1,int x2,int y2, char nom){
        /*
          f = CreerFile();
          f.enfiler(s);
          marquer(s);
          TANT-QUE NON f.vide() FAIRE
              s = f.defiler();
              afficher(s);
              POUR TOUT voisin de s FAIRE
                   SI voisin non marqué FAIRE
                        f.enfiler(voisin);
                        marquer(voisin);
                   FIN SI
              FIN POUR TOUT
          FIN TANT QUE
        */
        boolean[] marqueur = new boolean[123];
        for(int i = 0;i<123;++i)
            marqueur[i]=false;
        LinkedList<Integer> file = new LinkedList<Integer>();
        file.add(coordToCase(x1,y1));
        marqueur



    }

    public ArrayList<Integer> voisin(int x, int y){
        ArrayList<Integer> v = new ArrayList<Integer>();
        return v;
    }

    public int coordToCase(int x,int y){
        return x*11+y;
    }
}
