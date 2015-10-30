/**
 * Created by E115986X on 15/10/15.
 */
public class Arbre {
    private Arbre pere_;

    public Arbre(Arbre pere){
        pere_ = pere;
    }

    public Arbre getPere_() {
        return pere_;
    }

    public void setPere_(Arbre pere_) {
        this.pere_ = pere_;
    }
}
