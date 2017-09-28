package bam.web.demo.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Facteur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String matricule;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "facteur", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Tournee> tournees;

    public Facteur() {
    }

    public Facteur(String matricule, String nom, String prenom, Set<Tournee> tournees) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tournees = tournees;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Set<Tournee> getTournees() {
        return tournees;
    }

    public void setTournees(Set<Tournee> tournees) {
        this.tournees = tournees;
    }
}
