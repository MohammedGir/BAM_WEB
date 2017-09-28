package bam.web.demo.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String Type;

    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Tournee> tournees;

    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Quartier> quartiers;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ville_id")
    private Ville ville;


    public Site() {
    }

    public Site(String nom, String type, Set<Quartier> quartiers,Ville ville, Set<Tournee> tournees) {
        this.nom = nom;
        Type = type;
        this.quartiers = quartiers;
        this.ville = ville;
        this.tournees = tournees;
    }

    public Set<Tournee> getTournees() {
        return tournees;
    }

    public void setTournees(Set<Tournee> tournees) {
        this.tournees = tournees;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
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
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
