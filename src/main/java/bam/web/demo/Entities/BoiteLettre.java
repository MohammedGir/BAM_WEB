package bam.web.demo.Entities;

public class BoiteLettre {
    private Long id;
    private String adresse;
    private String type;
    private int cp ;
    private boolean etat;

    public BoiteLettre() {
    }

    public BoiteLettre(String adresse, String type, int cp, boolean etat) {
        this.adresse = adresse;
        this.type = type;
        this.cp = cp;
        this.etat = etat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
}
