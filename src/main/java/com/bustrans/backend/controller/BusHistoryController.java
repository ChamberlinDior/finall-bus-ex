package com.bustrans.backend.controller;

import com.bustrans.backend.dto.BusHistoryDTO;
import com.bustrans.backend.model.BusHistory;
import com.bustrans.backend.service.BusHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus-history")
public class BusHistoryController {

    @Autowired
    private BusHistoryService busHistoryService;

    // Convertir un DTO en modèle BusHistory
    private BusHistory convertToEntity(BusHistoryDTO dto) {
        BusHistory busHistory = new BusHistory();
        busHistory.setModele(dto.getModele());
        busHistory.setMatricule(dto.getMatricule());
        busHistory.setMarque(dto.getMarque());
        busHistory.setChauffeurNom(dto.getChauffeurNom());
        busHistory.setChauffeurUniqueNumber(dto.getChauffeurUniqueNumber());
        busHistory.setLastDestination(dto.getLastDestination());
        busHistory.setDebutTrajet(dto.getDebutTrajet());
        busHistory.setFinTrajet(dto.getFinTrajet());
        busHistory.setMacAddress(dto.getMacAddress());
        busHistory.setNiveauBatterie(dto.getNiveauBatterie());
        busHistory.setCharging(dto.isCharging());
        return busHistory;
    }

    // Enregistrer un nouveau trajet
    @PostMapping("/create")
    public ResponseEntity<BusHistory> createBusHistory(@RequestBody BusHistoryDTO busHistoryDTO) {
        BusHistory newHistory = busHistoryService.saveHistory(convertToEntity(busHistoryDTO));
        return ResponseEntity.ok(newHistory);
    }

    // Mettre à jour un trajet
    @PutMapping("/update")
    public ResponseEntity<BusHistory> updateBusHistory(@RequestBody BusHistoryDTO busHistoryDTO) {
        BusHistory updatedHistory = busHistoryService.updateHistory(convertToEntity(busHistoryDTO));
        return ResponseEntity.ok(updatedHistory);
    }

    // Récupérer l'historique d'un bus par adresse MAC
    @GetMapping("/{macAddress}")
    public ResponseEntity<List<BusHistory>> getBusHistory(@PathVariable String macAddress) {
        List<BusHistory> historyList = busHistoryService.getHistoryByMacAddress(macAddress);
        return ResponseEntity.ok(historyList);
    }
}
