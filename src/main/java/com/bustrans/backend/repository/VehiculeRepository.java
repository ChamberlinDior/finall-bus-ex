package com.bustrans.backend.repository;

import com.bustrans.backend.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    Vehicule findByImmatriculation(String immatriculation);
    Vehicule findByMacAddress(String macAddress);  // Nouvelle méthode pour rechercher par macAddress
}
