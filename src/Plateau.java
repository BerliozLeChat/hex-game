/**
 * Created by E115986X on 12/10/15.
 */
public class Plateau {

    private Case[][] plateau_;

    public Plateau(){
        plateau_ = new Case[11][11];
        for(int i = 0;i<11;++i){
            for(int j= 0;j<11;++j){
                plateau_[i][j] = new Case(i,j);
            }
        }
    }

    public Case[][] getPlateau_() {
        return plateau_;
    }

    public Case getCase(int i,int j){
        return plateau_[i][j];
    }
}
