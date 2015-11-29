package hexgame;

import java.util.*;

/**
 * Classe hexgame.Plateau.
 * Défini le plateau de jeu sur lequel repose les pions
 * @author François Hallereau & Sullivan Pineau
 */
public class Plateau {

    /**
     * tableau à double entrée contenant les pions
     */
    private char[][] plateau_;

    /**
     * Contructeur de la classe hexgame.Plateau
     */
    public Plateau(){
        plateau_ = new char[11][11];
        for(int i = 0;i<11;++i){
            for(int j= 0;j<11;++j){
                plateau_[i][j] = 'o';
            }
        }
    }

    /**
     * Accesseur de l'attribut #plateau_
     * @return le plateau
     */
    public char[][] getPlateau_() {
        return plateau_;
    }

    /**
     * Retourne la valeur du propriétaire de la case
     * @param i l'indice de la ligne
     * @param j l'indice de la colonne
     * @return o si la case est disponible sinon un char réprésentant un joueur
     */
    public char estDispo(int i, int j){
        return plateau_[i][j];
    }

    /**
     * Attribue une case à un joueur
     * @param i l'indice de la ligne
     * @param j l'indice de la colonne
     * @param nom le caractère représentant le joueur
     */
    public void setDispo(int i, int j, char nom){
            plateau_[i][j] = nom;
    }

    /**
     * Méthode qui affiche le plateau
     */
	public void afficher(){
        int w;
        int j;
        StringBuilder build = new StringBuilder();
        for(int i =0; i<11;++i)
		{
            for(w=0;w<i;++w)
                build.append(" ");
            build.append("|");
            for(j=0;j<11;++j) {
                build.append(plateau_[i][j]);
                build.append("|");

            }
            build.append("\n");
        }
        System.out.println(build.toString());
	}

    /**
     * Calcul le plus court chemin entre deux pions d'un même joueur
     * @param x1 indice de la ligne du pion 1
     * @param y1 indice de la colonne du pion 1
     * @param x2 indice de la ligne du pion 2
     * @param y2 indice de la colonne du pion 2
     * @param nom le caractère représentant le joueur
     * @param j le joueur
     * @return
     */
    public int calculDistance(int x1, int y1,int x2,int y2, char nom, Joueur j){
        boolean[] marqueur = new boolean[123];
        boolean trouve = false;
        int pion = 0;
        for(int q = 0;q<123;++q)
            marqueur[q]=false;
        LinkedList<Integer> fileEnCours = new LinkedList<Integer>();
        LinkedList<Integer> fileAvenir = new LinkedList<Integer>();
        fileEnCours.add(coordToCase(x1,y1));
        marqueur[coordToCase(x1,y1)] = true;
        int i;
        if(j.getdirection())
        {
           do{
                while(!fileEnCours.isEmpty()&&!trouve)
                {
                    int s = fileEnCours.poll();
                    for(int v : voisin(s /11,s%11)){//pour tout les voisins d'une case
                   System.out.println("voisin de : "+v);
                        if(v<122 && (!marqueur[v] && (plateau_[v%11][v/11]=='o'||plateau_[v%11][v/11]==nom ) ) ) {//il n'a pas déjà été visité
                            if(v<11)
                            {
                                i=0;
                                while(!trouve&&i<12)
                                {
                                    if(!marqueur[i])
                                    {
                                        fileAvenir.add(i);
                                    }
                                    marqueur[i] = true;
                                    if(i==x2*11+y2)//on vérifie qu'il appartient à la composante d'arrivée
                                    {
                                        trouve = true;//c'est le cas donc on a trouvé le plus court chemin
                                        pion--;
                                    }
                                    ++i;
                                }
                                pion++;
                            }else if(v>110)
                            {
                               i=110;
                                while(!trouve&&i<122)
                                {
                                    if(!marqueur[i])
                                    {
                                        fileAvenir.add(i);
                                    }
                                    marqueur[i] = true;
                                    if(i==x2*11+y2)//on vérifie qu'il appartient à la composante d'arrivée
                                    {
                                        trouve = true;//c'est le cas donc on a trouvé le plus court chemin
                                        pion--;
                                    }
                                    ++i;
                                } 
                                pion++;
                            }else
                            {
                                if(plateau_[v/11][v%11]==nom)
                                {
                                    fileEnCours.add(v);
                                }else
                                {
                                    fileAvenir.add(v);
                                }
                                marqueur[v] = true;
                                if(v==x2*11+y2)//on vérifie qu'il appartient à la composante d'arrivée
                                {
                                    trouve = true;//c'est le cas donc on a trouvé le plus court chemin
                                }
                            }
                        }
                    }
                }
               if(!trouve) {
                    fileEnCours.addAll(fileAvenir);
                    fileAvenir.clear();
                    pion++;
                }
           } while( !fileEnCours.isEmpty() && !trouve);
       }else
       {
             do{
                while(!fileEnCours.isEmpty()&&!trouve)
                {
                    int s = fileEnCours.poll();
                    for(int v : voisin(s / 11,s%11)){//pour tout les voisins d'une case
                        System.out.println("voisin de : "+v);
                        if(v<122&&(!marqueur[v] && (plateau_[v/11][v%11]=='o'||plateau_[v%11][v/11]==nom))){//il n'a pas déjà été visité
                            if(v % 11 == 0)
                            {
                                i=0;
                                while(!trouve&&i<12)
                                {
                                    if(!marqueur[i])
                                    {
                                        fileAvenir.add(i*11);
                                    }
                                    marqueur[i*11] = true;
                                    if(i*11==x2*11+y2)//on vérifie qu'il appartient à la composante d'arrivée
                                    {
                                        trouve = true;//c'est le cas donc on a trouvé le plus court chemin
                                        pion--;
                                    }
                                    ++i;
                                }
                                pion++;
                            }else if(v%11 == 10)
                            {
                               i=0;
                                while(!trouve&&i<12)
                                {
                                    if(!marqueur[i])
                                    {
                                        fileAvenir.add(i*11+10);
                                    }
                                    marqueur[i*11+10] = true;
                                    if(i*11+10==x2*11+y2)//on vérifie qu'il appartient à la composante d'arrivée
                                    {
                                        trouve = true;//c'est le cas donc on a trouvé le plus court chemin
                                        pion--;
                                    }
                                    ++i;
                                } 
                                pion++;
                            }else
                                {
                                    if(plateau_[v/11][v%11]==nom)
                                    {
                                        fileEnCours.add(v);
                                    }else
                                    {
                                        fileAvenir.add(v);
                                    }
                                    marqueur[v] = true;
                                    if(v==x2*11+y2)//on vérifie qu'il appartient à la composante d'arrivée
                                    {
                                        trouve = true;//c'est le cas donc on a trouvé le plus court chemin
                                    }
                                }
                        }
                    }
                }
               if(!trouve) {
                    fileEnCours.addAll(fileAvenir);
                    fileAvenir.clear();
                    pion++;
                }
           } while( !fileEnCours.isEmpty() && !trouve);
       }
       return pion-1;
    }

    /**
     * Retourne la liste des voisins d'un pion
     * @param x indice de la ligne
     * @param y indice de la colonne
     * @return la liste des voisins
     */
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
        return v;
    }

    /**
     * convertit une coordonnée en numéro de case
     * @param x indice de la ligne
     * @param y indice de la colonne
     * @return le numéro de la case
     */
    public int coordToCase(int x,int y){
        return x*11+y;
    }
}
