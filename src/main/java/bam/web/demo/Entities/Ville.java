package bam.web.demo.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "ville", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Site> sites;

    public Ville() {
    }

    public Ville(String nom, Region region, Set<Site> sites) {
        this.nom = nom;
        this.region = region;
        this.sites = sites;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Set<Site> getSites() {
        return sites;
    }

    public void setSites(Set<Site> sites) {
        this.sites = sites;
    }
}
