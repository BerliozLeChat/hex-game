/**
 * Structure Classe-Union
 * @author François Hallereau & Sullivan Pineau
 */
public class ClasseUnion {
    /**
     * le tableau des classes
     */
    private Arbre[] classes_;

    /**
     * valeur fixe dans le cas où le joueur n'a pas posé de pion sur cette case
     */
    private static Arbre NON_ATTRIBUE = null;

    /**
     * valeur de la classe qui correspond à l'une des extrémité du plateau de jeu
     */
    private static int EXTREME1 = 121;

    /**
     * valeur de la classe qui correspond à l'autre extrémité du plateau de jeu
     */
    private static int EXTREME2 = 122;

    /**
     * Constructeur de la structure classe union
     */
    public ClasseUnion() {
        classes_ = new Arbre[123];
        for (int i = 0; i < 121; ++i)
            classes_[i] = NON_ATTRIBUE;
        classes_[EXTREME1] = new Arbre(null,EXTREME1);
        classes_[EXTREME2] = new Arbre(null,EXTREME2);
    }

    /**
     * réalise l'ensemble des unions entre le pion qui vient d'être posé et les pions adjacents à celui-ci
     * @param c1 le pion posé
     */
    public void unionAdjacentes(int c1){
			classes_[c1] = new Arbre(null,c1);
		if(c1>-1&&c1<11){
			union(c1,EXTREME1);
			if(!(c1 == 0)){
				union(c1,c1+10);
			}
			union(c1,c1+11);		
		}else if (c1>109&&c1<121){
			union(c1,EXTREME2);
			if(!(c1 == 120)){
				union(c1,c1-10);
			}
			union(c1,c1-11);		
		}else{
			if( c1 mod 11 == 1)
			{  
				if(classes_[c1-10]!=NON_ATTRIBUE)
				{
					union(c1,c1-10);
				}
				if(classes_[c1+1]!=NON_ATTRIBUE)
				{
					union(c1,c1+1);
				}
				
			}else if( c1 mod 11 ==0 )
			{
				if(classes_[c1-1]!=NON_ATTRIBUE)
				{
					union(c1,c1-1);
				}
				if(classes_[c1+10]!=NON_ATTRIBUE)
				{
					union(c1,c1+10);
				}
			}else
			{
				if(classes_[c1-10]!=NON_ATTRIBUE)
				{
					union(c1,c1-10);
				}
				if(classes_[c1-1]!=NON_ATTRIBUE)
				{
					union(c1,c1-1);
				}
				if(classes_[c1+1]!=NON_ATTRIBUE)
				{
					union(c1,c1+1);
				}
				if(classes_[c1+10]!=NON_ATTRIBUE)
				{
					union(c1,c1+10);
				}
			}
			if(classes_[c1-11]!=NON_ATTRIBUE)
			{
				union(c1,c1-11);
			}
			if(classes_[c1+11]!=NON_ATTRIBUE)
			{
				union(c1,c1+11);
			}	
		}	
    }

    /**
     * union entre deux pions
     * @param c1 pion 1
     * @param c2 pion 2
     */
    public void union(int c1, int c2) {
        c1 = classe(c1);
        c2 = classe(c2);
        if(c1 != c2){
            classes_[c1].setPere(classes_[c2]);
        }
    }

    /**
     * retourne la classe d'un pion
     * @param c le pion
     * @return la classe de ce pion
     */
    public int classe(int c){
        Arbre ac = classes_[c];
        while(ac.getPere_!=null) {
            ac = ac.getPere_;
        }
        return ac.getElt_;
    }
}
