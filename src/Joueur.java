/**
 * Created by E115986X on 15/10/15.
 */
public class Joueur {
    private int type_;
    private String nom_;
    private ClasseUnion ClasseUnion_;
	private boolean fini_;

    public Joueur(int type, String nom){
        type_ = type;
        nom_ = nom;
		fini_ = false;
		ClasseUnion ClasseUnionbis = new ClasseUnion();
		ClasseUnion_ = ClasseUnionbis;
    }

    public int getType_() {
        return type_;
    }

    public String getNom_() {
        return nom_;
    }

    public boolean fini(){
        return fini_;
    }

	public void ajoutePion(int c1){
		ClasseUnion_.unionAdjacentes(c1);
	}

    public void existeCheminCotes(){
        fini_ = ClasseUnion_.existeCheminCotes();
    }

    public boolean existeCheminCase(int c1,int c2){
        return ClasseUnion_.existeCheminCases(c1,c2);
    }
}
