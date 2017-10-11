package bam.web.demo.Entities;

import javax.persistence.*;

@Entity
public class BoiteLettre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String adresse;
    private String type;
    private int cp ;
    private String etat;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tournee_id")
    private Tournee tournee;

    public BoiteLettre() {
    }

    public BoiteLettre(String adresse, String type, int cp, String etat,Tournee tournee) {
        this.adresse = adresse;
        this.type = type;
        this.cp = cp;
        this.etat = etat;
        this.tournee = tournee;
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Tournee getTournee() {
        return tournee;
    }

    public void setTournee(Tournee tournee) {
        this.tournee = tournee;
    }
}
