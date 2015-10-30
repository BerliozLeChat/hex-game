/**
 * Created by E115986X on 15/10/15.
 */
public class ClasseUnion {
    private Arbre[] classes_;
    private static Arbre NON_ATTRIBUE = null;
    private static int EXTREME1 = 121;
    private static int EXTREME2 = 122;

    public ClasseUnion() {
        classes_ = new Arbre[123];
        for (int i = 0; i < 121; ++i)
            classes_[i] = null;
        classes_[121] = new Arbre(null,121);
        classes_[122] = new Arbre(null,122);
    }

    public void unionAdjacentes(int c1){
        classes_[c1] = new Arbre(null,c1);
        //test des cases adjacentes puis si arbre présent

    }

    public void union(int c1, int c2) {

    }

    public int classe(int c){
        Arbre ac = classes_[c];
        while(ac.getPere_!=null) {
            ac = ac.getPere_;
        }
        return ac.getElt_;
    }
}
