package com.bustrans.backend.model;
import java.util.Date;

public class ForfaitStatus {
    private boolean isActive;
    private String typeForfait;
    private Date expirationDate;

    // Constructeur
    public ForfaitStatus(boolean isActive, String typeForfait, Date expirationDate) {
        this.isActive = isActive;
        this.typeForfait = typeForfait;
        this.expirationDate = expirationDate;
    }

    // Getter pour isActive
    public boolean isActive() {
        return isActive;
    }

    // Setter pour isActive
    public void setActive(boolean active) {
        isActive = active;
    }

    // Getter pour typeForfait
    public String getTypeForfait() {
        return typeForfait;
    }

    // Setter pour typeForfait
    public void setTypeForfait(String typeForfait) {
        this.typeForfait = typeForfait;
    }

    // Getter pour expirationDate
    public Date getExpirationDate() {
        return expirationDate;
    }

    // Setter pour expirationDate
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
