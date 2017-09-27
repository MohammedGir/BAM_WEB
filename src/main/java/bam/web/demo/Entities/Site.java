package bam.web.demo.Entities;

public class Site {
    private Long id;
    private String nom;
    private String Type;

    public Site() {
    }

    public Site(String nom, String type) {
        this.nom = nom;
        Type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
