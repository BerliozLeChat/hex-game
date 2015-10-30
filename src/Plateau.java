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
            plateau_[i][j] = false;
    }
	
	public void afficher(){
		for(int i =0; i<11;++i)
		{
			System.out.println("|"+ plateau_[i][0]+"|"+plateau_[i][1]+"|"+plateau_[i][2]+"|"+plateau_[i][3]+"|"+plateau_[i][4]+"|"+plateau_[i][5]+"|"+plateau_[i][6]+"|"+plateau_[i][7]+"|"+plateau_[i][8]+"|"+plateau_[i][9]+"|"+plateau_[i][10]+"|");
		}	
	}
}
