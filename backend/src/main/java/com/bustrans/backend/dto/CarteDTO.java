package com.bustrans.backend.dto;

import java.util.Date;

public class CarteDTO {
    private Long id;
    private String numCarte;
    private Date dateDelivrance;  // Utilisation du type Date
    private Date dateFinValidite;  // Utilisation du type Date
    private String nomAgentDelivrance;
    private String statut;
    private Long clientId;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumCarte() { return numCarte; }
    public void setNumCarte(String numCarte) { this.numCarte = numCarte; }

    public Date getDateDelivrance() { return dateDelivrance; }
    public void setDateDelivrance(Date dateDelivrance) { this.dateDelivrance = dateDelivrance; }

    public Date getDateFinValidite() { return dateFinValidite; }
    public void setDateFinValidite(Date dateFinValidite) { this.dateFinValidite = dateFinValidite; }

    public String getNomAgentDelivrance() { return nomAgentDelivrance; }
    public void setNomAgentDelivrance(String nomAgentDelivrance) { this.nomAgentDelivrance = nomAgentDelivrance; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }
}
