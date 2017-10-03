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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "site_id")
    private Site site;

    public Cyclo() {
    }

    public Cyclo(String matricule, Date dateCarteGrise, Date datePU, String reference, Site site) {
        this.matricule = matricule;
        this.dateCarteGrise = dateCarteGrise;
        this.datePU = datePU;
        this.reference = reference;
        this.site = site;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}
