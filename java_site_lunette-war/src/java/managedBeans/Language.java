package managedBeans;

import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean (name="language")
@SessionScoped
public class Language implements Serializable{

    private Locale locale = new Locale("en");
    private int id=2; //libelle des produit traduits correspond aux id dans la bd
    private boolean boolfr = false;
    private boolean boolen = true;
    

    /**
     * Creates a new instance of language
     */
    public Language() {
    }
    
    //GETTER / SETTER
    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
   
    
    /**
     *
     * @return
     */
    public Locale getLocale () {
        return locale;
    }
    
    
    /**
     * Mettre en anglais
     */
    public void setToEnglish() {
        locale = new Locale("en");
        this.setId(2);
        this.boolen = true;
        this.boolfr = false;
    }
    /**
     * Mettre en francais
     */
    public void setToFrench() {
        locale = new Locale("fr");
        this.setId(1);
        this.boolen = false;
        this.boolfr = true;
    }
    
    
    /**
     *
     * @return
     */
    public String setSelectFr () {
        if (boolfr)
            return "lang-selected";
        else
            return "";
    }
     /**
     *
     * @return
     */
    public String setSelectEn () {
          if (boolen)
            return "lang-selected";
        else
            return "";
    }

    
}