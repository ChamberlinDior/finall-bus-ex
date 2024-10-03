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
        Bus savedBus = busRepository.save(bus);
        // Enregistrer l'historique après avoir sauvegardé le bus
        saveBusHistory(savedBus);
        return savedBus;
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
            Bus updatedBus = busRepository.save(bus);
            // Enregistrer l'historique après avoir mis à jour le bus
            saveBusHistory(updatedBus);
            return updatedBus;
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
            // Enregistrer l'historique après avoir démarré le trajet
            saveBusHistory(updatedBus);
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
            // Enregistrer l'historique après avoir terminé le trajet
            saveBusHistory(updatedBus);
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
            Bus updatedBus = busRepository.save(bus);
            // Enregistrer l'historique après la mise à jour de la batterie
            saveBusHistory(updatedBus);
            return updatedBus;
        }
        return null;
    }

    // Enregistrer l'historique d'un bus dans la table bus_history
    private void saveBusHistory(Bus bus) {
        BusHistory busHistory = new BusHistory();
        busHistory.setBus(bus);
        busHistory.setChauffeurNom(bus.getChauffeurNom());
        busHistory.setChauffeurUniqueNumber(bus.getChauffeurUniqueNumber());
        busHistory.setLastDestination(bus.getLastDestination());
        busHistory.setNiveauBatterie(bus.getNiveauBatterie());
        busHistory.setCharging(bus.isCharging());
        busHistory.setTimestamp(new Date());  // Enregistrer l'heure actuelle comme horodatage
        busHistoryRepository.save(busHistory);  // Enregistrer l'historique dans la base de données
    }
}
