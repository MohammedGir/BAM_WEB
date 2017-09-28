package bam.web.demo.Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Cyclo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String matricule;
    private Date dateCarteGrise;
    private Date datePU;
    private String reference;

    @OneToMany(mappedBy = "cyclo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Tournee> tournees;

    public Cyclo() {
    }

    public Cyclo(String matricule, Date dateCarteGrise, Date datePU, String reference,Set<Tournee> tournees) {
        this.matricule = matricule;
        this.dateCarteGrise = dateCarteGrise;
        this.datePU = datePU;
        this.reference = reference;
        this.tournees = tournees;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Date getDateCarteGrise() {
        return dateCarteGrise;
    }

    public void setDateCarteGrise(Date dateCarteGrise) {
        this.dateCarteGrise = dateCarteGrise;
    }

    public Date getDatePU() {
        return datePU;
    }

    public void setDatePU(Date datePU) {
        this.datePU = datePU;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Set<Tournee> getTournees() {
        return tournees;
    }

    public void setTournees(Set<Tournee> tournees) {
        this.tournees = tournees;
    }
}
