package bam.web.demo.Entities;

public class Zone {
    private Long id;
    private String nom;
    private String etat;

    public Zone() {
    }

    public Zone(String nom, String etat) {
        this.nom = nom;
        this.etat = etat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
