package com.bustrans.backend.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class BusChangeLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bus_mac_address", nullable = false)
    private String busMacAddress;

    @Column(name = "chauffeur_nom", nullable = false)
    private String chauffeurNom;

    @Column(name = "chauffeur_unique_number", nullable = false)
    private String chauffeurUniqueNumber;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_change", nullable = false)
    private Date dateChange;

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusMacAddress() {
        return busMacAddress;
    }

    public void setBusMacAddress(String busMacAddress) {
        this.busMacAddress = busMacAddress;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDateChange() {
        return dateChange;
    }

    public void setDateChange(Date dateChange) {
        this.dateChange = dateChange;
    }
}
