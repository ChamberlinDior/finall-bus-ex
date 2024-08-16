package com.bustrans.backend.model;

import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@Entity
public class Carte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String numCarte;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDelivrance;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateFinValidite;

    @Column(nullable = false)
    private String nomAgentDelivrance;

    @Column(nullable = false)
    private String statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "carte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;

    // Constructeurs, getters, setters
    public Carte() {}

    public Carte(String numCarte, Date dateDelivrance, Date dateFinValidite, String nomAgentDelivrance, String statut, Client client) {
        this.numCarte = numCarte;
        this.dateDelivrance = dateDelivrance;
        this.dateFinValidite = dateFinValidite;
        this.nomAgentDelivrance = nomAgentDelivrance;
        this.statut = statut;
        this.client = client;
    }

    // Getters and Setters
    public Long getId() { return id; }

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

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public List<Transaction> getTransactions() { return transactions; }
    public void setTransactions(List<Transaction> transactions) { this.transactions = transactions; }
}
