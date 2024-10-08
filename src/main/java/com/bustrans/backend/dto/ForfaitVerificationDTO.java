package com.bustrans.backend.dto;

public class ForfaitVerificationDTO {
    private String nomClient;
    private String rfid;
    private String statutForfait;
    private String androidId;
    private String roleUtilisateur;
    private String nomUtilisateur;  // Nom de l'utilisateur qui effectue la vérification
    private boolean forfaitActiverParClient;  // **Nouvelle propriété**

    public ForfaitVerificationDTO() {
    }

    public ForfaitVerificationDTO(String nomClient, String rfid, String statutForfait, String androidId, String roleUtilisateur, String nomUtilisateur, boolean forfaitActiverParClient) {
        this.nomClient = nomClient;
        this.rfid = rfid;
        this.statutForfait = statutForfait;
        this.androidId = androidId;
        this.roleUtilisateur = roleUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.forfaitActiverParClient = forfaitActiverParClient;
    }

    // Getters et Setters pour la nouvelle propriété
    public boolean isForfaitActiverParClient() {
        return forfaitActiverParClient;
    }

    public void setForfaitActiverParClient(boolean forfaitActiverParClient) {
        this.forfaitActiverParClient = forfaitActiverParClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getStatutForfait() {
        return statutForfait;
    }

    public void setStatutForfait(String statutForfait) {
        this.statutForfait = statutForfait;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public String getRoleUtilisateur() {
        return roleUtilisateur;
    }

    public void setRoleUtilisateur(String roleUtilisateur) {
        this.roleUtilisateur = roleUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }
}
