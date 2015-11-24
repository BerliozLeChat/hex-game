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

    //calculDistance dans plateau car il est nécessaire d'avoir la vision d'ensemble de celui ci. cad on a besoin de savoir a qui appartiennent les cases.
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

    public int calculDistance2(int x1, int y1,int x2,int y2, char nom, Joueur j){
        ArrayList<Integer> list= new ArrayList<Integer>();
        list.add(coordToCase(x1,y1));
        int coor = x2*11+y2;
        int min=126;
        calculDistanceR2(list, coor, 0, min, nom, j);
        return min;
    }

    private void calculDistanceR2(ArrayList<Integer> list ,int coor ,int i, int min,char nom, Joueur j) {
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
                            calculDistanceR2(voisin(v / 11, v % 11), coor, i, min, nom, j);
                        } else {
                            calculDistanceR2(voisin(v / 11, v % 11), coor, i + 1, min, nom, j);
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
        return v;
    }

    public int coordToCase(int x,int y){
        return x*11+y;
    }
}
