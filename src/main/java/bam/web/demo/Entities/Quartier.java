package bam.web.demo.Entities;

import javax.persistence.*;

@Entity
public class Quartier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String nom;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "site_id")
    private Site site;

    public Quartier() {
    }

    public Quartier(String nom, Site site) {
        this.nom = nom;
        this.site = site;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}
