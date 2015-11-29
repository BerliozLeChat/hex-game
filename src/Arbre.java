/**
 * Classe Arbre.
 * Représente la structure d'un arbre
 */
public class Arbre {
    /**
     * le pere de l'arbre, null si on se trouve à la racine
     */
    private Arbre pere_;

    /**
     * l'élément stocké
     */
    private int elt_;

    /**
     * Constructeur de la classe Arbre
     * @param pere le pere de l'arbre
     * @param elt l'élément de l'arbre
     */
    public Arbre(Arbre pere, int elt){
        elt_ = elt;
        pere_ = pere;
    }

    /**
     * Retourne l'attribut #pere_ de l'arbre
     * @return le pere
     */
    public Arbre getPere_() {
        return pere_;
    }

    /**
     * Mutateur de l'attribut #pere_
     * @param pere le nouveau pere
     */
    public void setPere_(Arbre pere) {
        pere_ = pere;
    }

    /**
     * Accesseur de l'attribut #elt_
     * @return l'élément
     */
    public int getElt_() {
        return elt_;
    }
}
