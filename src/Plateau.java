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
   /* public int calculDistance(int x1, int y1,int x2,int y2, char nom, Joueur j){
        boolean[] marqueur = new boolean[123];
        ArrayList<Integer> composante = j.getClasseUnion().afficheComposante(coordToCase(x2,y2));//à vérifier dans le cas ou les coordonnés sont inversé
        boolean trouve = false;
        int pion = 0;
        for(int i = 0;i<123;++i)
            marqueur[i]=false;
        LinkedList<Integer> file = new LinkedList<Integer>();
        file.add(coordToCase(x1,y1));
        marqueur[coordToCase(x1,y1)] = true;
        while( !file.isEmpty() && !trouve){
            int s = file.poll();
            for(int v : voisin(s % 11,s/11)){//pour tout les voisins d'une case
                if(!marqueur[v] && plateau_[v%11][v/11]=='o' && plateau_[v%11][v/11]==nom){//il n'a pas déjà été visité
                    file.add(v);
                    marqueur[v] = true;
                    if(composante.contains(v))//on vérifie qu'il appartient à la composante d'arrivée
                        trouve=true;//c'est le cas donc on a trouvé le plus court chemin
                }
            }
            pion++;
        }
        return pion;
    }*/
    public int calculDistance(int x1, int y1,int x2,int y2, char nom, Joueur j){
        ArrayList<Integer> list= new ArrayList<Integer>();
        list.add(coordToCase(x1,y1));
        int coor = x2*11+y2;
        int min=126;
        calculDistanceR(list, coor, 0, min, nom, j);
        return min;
    }

    private void calculDistanceR(ArrayList<Integer> list ,int coor ,int i, int min,char nom, Joueur j) {
        if (i < min) {
            ArrayList<Integer> listvoisin = new ArrayList<Integer>();
            if (list.contains(coor)) {
                i = i + 1;
                if (i < min) {
                    min = i;
                }
            } else {
                for (int q : list) {
                    for (int v : voisin(q % 11, q / 11)) {
                        if (plateau_[v / 11][v % 11] == nom) {
                            calculDistanceR(voisin(v / 11, v % 11), coor, i, min, nom, j);
                        } else {
                            calculDistanceR(voisin(v / 11, v % 11), coor, i + 1, min, nom, j);
                        }
                    }
                }
            }
        }
    }



    public ArrayList<Integer> voisin(int x, int y){
        ArrayList<Integer> v = new ArrayList<Integer>();
        int nouvellecoor;
        if (y!=0) {
            nouvellecoor = x * 11 + (y - 1);
            v.add(nouvellecoor);
        }
        if(y!=10){
            nouvellecoor = x * 11 + (y + 1);
            v.add(nouvellecoor);
        }
        if(y!=10&&x!=0){
            nouvellecoor = (x-1) * 11 + (y + 1);
            v.add(nouvellecoor);
        }
        if(y!=0&&x!=10){
            nouvellecoor = (x+1) * 11 + (y - 1);
            v.add(nouvellecoor);
        }
        if(x!=0){
            nouvellecoor = (x-1)* 11 + y;
            v.add(nouvellecoor);
        }
        if(x!=10){
            nouvellecoor = (x+1) * 11 + y;
            v.add(nouvellecoor);
        }
        System.out.println("la longueur de v est :"+v.size());
        return v;
    }

    public int coordToCase(int x,int y){
        return x*11+y;
    }
}
