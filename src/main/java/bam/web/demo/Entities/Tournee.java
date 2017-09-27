package bam.web.demo.Entities;

import java.util.Date;

public class Tournee {
    private Long id;
    private long numero;
    private Date dateTournee;
    private  double trajetLongeur;
    private  double MntIndemnite;

    public Tournee() {
    }

    public Tournee(long numero, Date dateTournee, double trajetLongeur, double mntIndemnite) {
        this.numero = numero;
        this.dateTournee = dateTournee;
        this.trajetLongeur = trajetLongeur;
        MntIndemnite = mntIndemnite;
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
}
