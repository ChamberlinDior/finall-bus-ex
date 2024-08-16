package com.bustrans.backend.model;

import jakarta.persistence.*;


import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(nullable = false)
    private Double montant;

    @Column(nullable = false)
    private String terminalId;

    @Column(nullable = false)
    private String lieu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carte_id")
    private Carte carte;

    // Constructeurs, getters, setters
    public Transaction() {}

    public Transaction(Date date, Double montant, String terminalId, String lieu, Carte carte) {
        this.date = date;
        this.montant = montant;
        this.terminalId = terminalId;
        this.lieu = lieu;
        this.carte = carte;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }

    public String getTerminalId() { return terminalId; }
    public void setTerminalId(String terminalId) { this.terminalId = terminalId; }

    public String getLieu() { return lieu; }
    public void setLieu(String lieu) { this.lieu = lieu; }

    public Carte getCarte() { return carte; }
    public void setCarte(Carte carte) { this.carte = carte; }
}
