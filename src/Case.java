/**
 * Created by E115986X on 12/10/15.
 */

@Deprecated
public class Case {

    private int i_; // la ligne
    private int j_; // la colonne
    private boolean dispo_; // vrai si disponible

    /**
     *
     * @param i
     * @param j
     */
    public Case(int i,int j{
        i_=i;
        j_=j;
        dispo_=true;
    }

    public int getJ_() {
        return j_;
    }

    public boolean estDispo_() {
        return dispo_;
    }

    public void setDispo_(boolean dispo_) {
        this.dispo_ = dispo_;
    }

    public int getI_() {

        return i_;
    }

}
