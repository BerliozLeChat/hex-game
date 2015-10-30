/**
 * Created by E115986X on 12/10/15.
 */
public class Plateau {

    private boolean[][] plateau_;

    public Plateau(){
        plateau_ = new boolean[11][11];
        for(int i = 0;i<11;++i){
            for(int j= 0;j<11;++j){
                plateau_[i][j] = true;
                //Classe(Case)
            }
        }
    }

    public boolean[][] getPlateau_() {
        return plateau_;
    }

    public boolean estDispo(int i, int j, boolean inverse){
        return (inverse ? plateau_[j][i] : plateau_[i][j]);
    }

    public void setDispo(int i, int j, boolean inverse){
        if(inverse)
            plateau_[j][i] = false;
        else
            plateau_[i][j] = false;
    }
}
