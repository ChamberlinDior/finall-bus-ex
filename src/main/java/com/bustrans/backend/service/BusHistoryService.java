package com.bustrans.backend.service;

import com.bustrans.backend.model.BusHistory;
import com.bustrans.backend.repository.BusHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusHistoryService {

    @Autowired
    private BusHistoryRepository busHistoryRepository;

    // Enregistrer un nouveau trajet
    public BusHistory saveHistory(BusHistory history) {
        return busHistoryRepository.save(history);
    }

    // Mettre à jour un trajet existant
    public BusHistory updateHistory(BusHistory history) {
        return busHistoryRepository.save(history);
    }

    // Récupérer l'historique d'un bus par adresse MAC
    public List<BusHistory> getHistoryByMacAddress(String macAddress) {
        return busHistoryRepository.findByMacAddress(macAddress);
    }
}
