package bam.web.demo.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String type;
    private int cp;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ville_id")
    private Ville ville;

    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Tournee> tournees;

    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Quartier> quartiers;

    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Facteur> facteurs;

    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Cyclo> cyclos;

    public Site() {
    }


    public Site(String nom, int cp, String type, Ville ville) {
        this.nom = nom;
        this.type = type;
        this.ville = ville;
        this.cp = cp;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Tournee> getTournees() {
        return tournees;
    }

    public void setTournees(Set<Tournee> tournees) {
        this.tournees = tournees;
    }

    public Set<Quartier> getQuartiers() {
        return quartiers;
    }

    public void setQuartiers(Set<Quartier> quartiers) {
        this.quartiers = quartiers;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        type = type;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public Set<Facteur> getFacteurs() {
        return facteurs;
    }

    public void setFacteurs(Set<Facteur> facteurs) {
        this.facteurs = facteurs;
    }

    public Set<Cyclo> getCyclos() {
        return cyclos;
    }

    public void setCyclos(Set<Cyclo> cyclos) {
        this.cyclos = cyclos;
    }
}
