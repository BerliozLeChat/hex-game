package hexgame;

/**
 * Classe hexgame.Joueur
 * @author François Hallereau & Sullivan Pineau
 */
public class Joueur {
    /**
     * le type de joueur
     */
    private int type_;

    /**
     * le nom du joueur
     */
    private String nom_;

    /**
     * la classe union du joueur
     */
    private ClasseUnion ClasseUnion_;

    /**
     * la condition de victoire du joueur
     */
	private boolean fini_;

    /**
     * vrai si le joueur doit faire un chemin vertical, faux sinon
     */
    private boolean direction_;

    /**
     * constructeur de la classe joueur
     * @param type le type du joueur
     * @param nom le nom du joueur
     * @param direction la direction du joueur
     */
    public Joueur(int type, String nom, boolean direction){
        type_ = type;
        nom_ = nom;
        direction_=direction; // true vertical 
		fini_ = false;
		ClasseUnion_ = new ClasseUnion();
    }

    /**
     * Accesseur de l'attribut #type_
     * @return le type
     */
    public int getType_() {
        return type_;
    }

    /**
     * Accesseur de l'attribut #direction_
     * @return la direction
     */
    public boolean getdirection(){
        return direction_;
    }

    /**
     * Accesseur de l'attribut #nom_
     * @return le nom
     */
    public String getNom_() {
        return nom_;
    }

    /**
     * Accesseur de l'attribut #fini_
     * @return la condition de victoire
     */
    public boolean fini(){
        return fini_;
    }

    /**
     * Méthode qui ajoute un pion dans la structure #ClasseUnion_ du joueur
     * @param c1 le numéro de la case où est posé le pion
     */
	public void ajoutePion(int c1){
		ClasseUnion_.unionAdjacentes(c1);
	}

    /**
     * stocke dans l'attribut #fini_ si il existe un chemin entre les deux extrémités du plateau
     */
    public void existeCheminCotes(){
        fini_ = ClasseUnion_.existeCheminCotes();
    }

    /**
     * Teste si il existe un chemin entre deux cases
     * @param c1 le numéro de la case
     * @param c2 le numéro de l'autre case
     * @return vrai si un chemin existe faux sinon
     */
    public boolean existeCheminCase(int c1,int c2){
        return ClasseUnion_.existeCheminCases(c1,c2);
    }

    /**
     * Accesseur de l'attribut #ClasseUnion_
     * @return la classe union
     */
    public ClasseUnion getClasseUnion(){
        return ClasseUnion_;
    }
}
