package managedBeans;

import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean (name="language")
@SessionScoped
public class Language {

    private Locale locale = new Locale("en");
    private boolean boolfr = false;
    private boolean boolen = true;
    
    public Locale getLocale () {
        return locale;
    }
    
    /**
     * Creates a new instance of language
     */
    public Language() {
    }
    
    public void setToEnglish() {
        locale = new Locale("en");
        this.boolen = true;
        this.boolfr = false;
    }
    public void setToFrench() {
        locale = new Locale("fr");
        this.boolen = false;
        this.boolfr = true;
    }
    
    
    public String setSelectFr () {
        if (boolfr)
            return "lang-selected";
        else
            return "";
    }
     public String setSelectEn () {
          if (boolen)
            return "lang-selected";
        else
            return "";
    }
    
}