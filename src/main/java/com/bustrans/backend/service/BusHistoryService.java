package com.bustrans.backend.service;

import com.bustrans.backend.dto.BusHistoryDTO;
import com.bustrans.backend.model.BusHistory;
import com.bustrans.backend.repository.BusHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusHistoryService {

    @Autowired
    private BusHistoryRepository busHistoryRepository;

    // Récupérer l'historique d'un bus sous forme de DTO
    public List<BusHistoryDTO> getBusHistoryByBusId(Long busId) {
        List<BusHistory> historyList = busHistoryRepository.findByBusId(busId);
        return historyList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Convertir un objet BusHistory en BusHistoryDTO
    private BusHistoryDTO convertToDTO(BusHistory busHistory) {
        BusHistoryDTO dto = new BusHistoryDTO();
        dto.setId(busHistory.getId());
        dto.setBusId(busHistory.getBus().getId());
        dto.setChauffeurNom(busHistory.getChauffeurNom());
        dto.setChauffeurUniqueNumber(busHistory.getChauffeurUniqueNumber());
        dto.setLastDestination(busHistory.getLastDestination());
        dto.setNiveauBatterie(busHistory.getNiveauBatterie());
        dto.setCharging(busHistory.isCharging());
        dto.setTimestamp(busHistory.getTimestamp());
        return dto;
    }
}
