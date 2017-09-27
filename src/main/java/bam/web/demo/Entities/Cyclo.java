package bam.web.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Cyclo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String matricule;
    private Date dateCarteGrise;
    private Date datePU;
    private String reference;

    public Cyclo() {
    }

    public Cyclo(String matricule, Date dateCarteGrise, Date datePU, String reference) {
        this.matricule = matricule;
        this.dateCarteGrise = dateCarteGrise;
        this.datePU = datePU;
        this.reference = reference;
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
}
