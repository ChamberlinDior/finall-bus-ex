package com.bustrans.backend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class BusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modele;

    @Column(nullable = false)
    private String matricule;

    @Column(nullable = false)
    private String marque;

    @Column(nullable = false)
    private String chauffeurNom;

    @Column(nullable = false)
    private String chauffeurUniqueNumber;

    @Column(nullable = false)
    private String lastDestination;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date debutTrajet;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date finTrajet;

    @Column(name = "mac_address", nullable = false, unique = true)
    private String macAddress;

    @Column(nullable = true)
    private Integer niveauBatterie;

    @Column(name = "is_charging", nullable = false)
    private boolean isCharging;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getChauffeurNom() {
        return chauffeurNom;
    }

    public void setChauffeurNom(String chauffeurNom) {
        this.chauffeurNom = chauffeurNom;
    }

    public String getChauffeurUniqueNumber() {
        return chauffeurUniqueNumber;
    }

    public void setChauffeurUniqueNumber(String chauffeurUniqueNumber) {
        this.chauffeurUniqueNumber = chauffeurUniqueNumber;
    }

    public String getLastDestination() {
        return lastDestination;
    }

    public void setLastDestination(String lastDestination) {
        this.lastDestination = lastDestination;
    }

    public Date getDebutTrajet() {
        return debutTrajet;
    }

    public void setDebutTrajet(Date debutTrajet) {
        this.debutTrajet = debutTrajet;
    }

    public Date getFinTrajet() {
        return finTrajet;
    }

    public void setFinTrajet(Date finTrajet) {
        this.finTrajet = finTrajet;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Integer getNiveauBatterie() {
        return niveauBatterie;
    }

    public void setNiveauBatterie(Integer niveauBatterie) {
        this.niveauBatterie = niveauBatterie;
    }

    public boolean isCharging() {
        return isCharging;
    }

    public void setCharging(boolean isCharging) {
        this.isCharging = isCharging;
    }
}
