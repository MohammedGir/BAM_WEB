package bam.web.demo.Entities;

public class Region {
    private Long id;
    private String nom;

    public Region() {
    }

    public Region(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
