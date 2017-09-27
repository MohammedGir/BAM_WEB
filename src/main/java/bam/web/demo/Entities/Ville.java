package bam.web.demo.Entities;

public class Ville {
    private Long id;
    private String nom;

    public Ville() {
    }

    public Ville(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
