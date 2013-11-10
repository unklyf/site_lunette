package managedBeans;

import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class language {

    private Locale locale = new Locale("en");
    private boolean boolfr = false;
    private boolean boolen = true;
    
    public Locale getLocale () {
        return locale;
    }
    
    /**
     * Creates a new instance of language
     */
    public language() {
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
    
    
    public String setBoldFr () {
        if (boolfr)
            return "lang-selected";
        else
            return "";
    }
     public String setBoldEn () {
          if (boolen)
            return "lang-selected";
        else
            return "";
    }
    
}