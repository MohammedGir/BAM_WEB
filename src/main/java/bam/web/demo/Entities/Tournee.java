package bam.web.demo.Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Tournee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long numero;
    private Date dateTournee;
    private  double trajetLongeur;
    private  double MntIndemnite;

    @OneToMany(mappedBy = "tournee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BoiteLettre> boiteLettres;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cyclo_id")
    private Cyclo cyclo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "facteur_id")
    private Facteur facteur;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "site_id")
    private Site site;

    public Tournee() {
    }

    public Tournee(long numero, Date dateTournee, double trajetLongeur, double mntIndemnite,
                   Site site) {
        this.numero = numero;
        this.dateTournee = dateTournee;
        this.trajetLongeur = trajetLongeur;
        this.MntIndemnite = mntIndemnite;
        this.site = site;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Date getDateTournee() {
        return dateTournee;
    }

    public void setDateTournee(Date dateTournee) {
        this.dateTournee = dateTournee;
    }

    public double getTrajetLongeur() {
        return trajetLongeur;
    }

    public void setTrajetLongeur(double trajetLongeur) {
        this.trajetLongeur = trajetLongeur;
    }

    public double getMntIndemnite() {
        return MntIndemnite;
    }

    public void setMntIndemnite(double mntIndemnite) {
        MntIndemnite = mntIndemnite;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Facteur getFacteur() {
        return facteur;
    }

    public void setFacteur(Facteur facteur) {
        this.facteur = facteur;
    }

    public Cyclo getCyclo() {
        return cyclo;
    }

    public void setCyclo(Cyclo cyclo) {
        this.cyclo = cyclo;
    }

    public Set<BoiteLettre> getBoiteLettres() {
        return boiteLettres;
    }

    public void setBoiteLettres(Set<BoiteLettre> boiteLettres) {
        this.boiteLettres = boiteLettres;
    }
}
