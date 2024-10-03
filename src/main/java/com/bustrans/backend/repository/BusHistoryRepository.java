package com.bustrans.backend.repository;

import com.bustrans.backend.model.BusHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusHistoryRepository extends JpaRepository<BusHistory, Long> {

    // Rechercher l'historique des trajets par adresse MAC
    List<BusHistory> findByMacAddress(String macAddress);
}
