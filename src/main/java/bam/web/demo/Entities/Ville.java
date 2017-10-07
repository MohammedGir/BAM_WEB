package bam.web.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "ville", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Site> sites;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id")
    private Region region;



    public Ville() {
    }

    public Ville(String nom, Region region) {
        this.nom = nom;
        this.region = region;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
