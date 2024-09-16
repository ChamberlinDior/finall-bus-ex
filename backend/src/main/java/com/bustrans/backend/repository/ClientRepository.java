package com.bustrans.backend.repository;

import com.bustrans.backend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    // Rechercher un client par RFID
    Client findByRfid(String rfid);

    // Rechercher un client par numéro de client
    Client findByNumClient(String numClient);
}
