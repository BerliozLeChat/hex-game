/** 
 * Created by E115986X on 15/10/15.
 */
public class Arbre {
    private Arbre pere_;
    private int elt_;

    public Arbre(Arbre pere, int elt){
        elt_ = elt;
        pere_ = pere;
    }
	

    public Arbre getPere_() {
        return pere_;
    }

    public void setPere_(Arbre pere) {
        pere_ = pere;
    }

    public int getElt_() {
        return elt_;
    }
}
