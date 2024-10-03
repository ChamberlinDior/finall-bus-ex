package com.bustrans.backend.service;

import com.bustrans.backend.model.Bus;
import com.bustrans.backend.model.BusHistory;
import com.bustrans.backend.repository.BusHistoryRepository;
import com.bustrans.backend.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private BusHistoryRepository busHistoryRepository;

    // Récupérer tous les bus
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    // Enregistrer un bus
    public Bus saveBus(Bus bus) {
        return busRepository.save(bus);
    }

    // Récupérer un bus par son adresse MAC
    public Bus getBusByMacAddress(String macAddress) {
        return busRepository.findByMacAddress(macAddress);
    }

    // Mettre à jour le chauffeur et la destination
    public Bus updateChauffeurAndDestinationByMacAddress(String macAddress, String lastDestination, String chauffeurNom, String chauffeurUniqueNumber) {
        Bus bus = busRepository.findByMacAddress(macAddress);
        if (bus != null) {
            bus.setLastDestination(lastDestination);
            bus.setChauffeurNom(chauffeurNom);
            bus.setChauffeurUniqueNumber(chauffeurUniqueNumber);
            return busRepository.save(bus);
        }
        return null;
    }

    // Démarrer un trajet
    public Bus startTrip(String macAddress, String lastDestination) {
        Bus bus = busRepository.findByMacAddress(macAddress);
        if (bus != null) {
            bus.setDebutTrajet(new Date());
            bus.setLastDestination(lastDestination);
            Bus updatedBus = busRepository.save(bus);

            // Enregistrer l'historique du trajet
            BusHistory busHistory = new BusHistory();
            busHistory.setBus(updatedBus);
            busHistory.setChauffeurNom(updatedBus.getChauffeurNom());
            busHistory.setChauffeurUniqueNumber(updatedBus.getChauffeurUniqueNumber());
            busHistory.setLastDestination(updatedBus.getLastDestination());
            busHistory.setNiveauBatterie(updatedBus.getNiveauBatterie());
            busHistory.setCharging(updatedBus.isCharging());
            busHistory.setTimestamp(new Date());
            busHistoryRepository.save(busHistory);  // Enregistrement de l'historique

            return updatedBus;
        }
        return null;
    }

    // Terminer un trajet
    public Bus endTrip(String macAddress) {
        Bus bus = busRepository.findByMacAddress(macAddress);
        if (bus != null) {
            bus.setFinTrajet(new Date());
            Bus updatedBus = busRepository.save(bus);

            // Enregistrer l'historique de fin de trajet
            BusHistory busHistory = new BusHistory();
            busHistory.setBus(updatedBus);
            busHistory.setChauffeurNom(updatedBus.getChauffeurNom());
            busHistory.setChauffeurUniqueNumber(updatedBus.getChauffeurUniqueNumber());
            busHistory.setLastDestination(updatedBus.getLastDestination());
            busHistory.setNiveauBatterie(updatedBus.getNiveauBatterie());
            busHistory.setCharging(updatedBus.isCharging());
            busHistory.setTimestamp(new Date());
            busHistoryRepository.save(busHistory);  // Enregistrement de l'historique

            return updatedBus;
        }
        return null;
    }

    // Mettre à jour le niveau de batterie et l'état de charge
    public Bus updateBatteryLevel(String macAddress, Integer niveauBatterie, boolean isCharging) {
        Bus bus = busRepository.findByMacAddress(macAddress);
        if (bus != null) {
            bus.setNiveauBatterie(niveauBatterie);
            bus.setCharging(isCharging);  // Mise à jour de l'état de charge
            return busRepository.save(bus);
        }
        return null;
    }
}
