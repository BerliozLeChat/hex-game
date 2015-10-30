/**
 * Created by E115986X on 15/10/15.
 */
public class ClasseUnion {
    private Arbre[] classes_;
    private static Arbre NON_ATTRIBUE = null;
    private static int RACINE = -2;

    public ClasseUnion() {
        classes_ = new Arbre[123];
        for (int i = 0; i < 123; ++i)
            classes_[i] = null;
    }

    public void preUnion(int c1){
        classes_[c1] = new Arbre(null);
        //test des cases adjacentes puis si arbre présent
    }

    public void union(int c1, int c2) {;
    }

    public int classe(int c){
        return 0;
    }
}
