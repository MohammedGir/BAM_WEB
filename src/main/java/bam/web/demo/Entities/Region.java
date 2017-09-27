package bam.web.demo.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private Set<Ville> villes;

    public Region() {
    }

    public Region(String nom, Set<Ville> villes) {
        this.nom = nom;
        this.villes = villes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @OneToMany(mappedBy = "region",cascade = CascadeType.ALL)
    public Set<Ville> getVilles() {
        return villes;
    }

    public void setVilles(Set<Ville> villes) {
        this.villes = villes;
    }
}
