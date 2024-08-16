package com.bustrans.backend.dto;

public class TransactionDTO {
    private Long id;
    private String date;
    private Double montant;
    private String terminalId;
    private String lieu;
    private Long carteId;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }

    public String getTerminalId() { return terminalId; }
    public void setTerminalId(String terminalId) { this.terminalId = terminalId; }

    public String getLieu() { return lieu; }
    public void setLieu(String lieu) { this.lieu = lieu; }

    public Long getCarteId() { return carteId; }
    public void setCarteId(Long carteId) { this.carteId = carteId; }
}
