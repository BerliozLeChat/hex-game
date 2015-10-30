/**
 * Created by E115986X on 15/10/15.
 */
public class Joueur {
    private int type_;
    private String nom_;

    public Joueur(int type, String nom){
        type_ = type;
        nom_ = nom;
    }

    public int getType_() {
        return type_;
    }

    public String getNom_() {
        return nom_;
    }
}
