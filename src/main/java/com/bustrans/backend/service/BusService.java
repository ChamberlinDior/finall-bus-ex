package com.bustrans.backend.service;

import com.bustrans.backend.model.Bus;
import com.bustrans.backend.model.BusChangeLog;
import com.bustrans.backend.repository.BusRepository;
import com.bustrans.backend.repository.BusChangeLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private BusChangeLogRepository busChangeLogRepository;

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

    // Mettre à jour le chauffeur et la destination et enregistrer dans le log
    public Bus updateChauffeurAndDestinationByMacAddress(String macAddress, String lastDestination, String chauffeurNom, String chauffeurUniqueNumber) {
        Bus bus = busRepository.findByMacAddress(macAddress);
        if (bus != null) {
            bus.setLastDestination(lastDestination);
            bus.setChauffeurNom(chauffeurNom);
            bus.setChauffeurUniqueNumber(chauffeurUniqueNumber);
            Bus updatedBus = busRepository.save(bus);

            // Enregistrer le changement dans le log
            BusChangeLog changeLog = new BusChangeLog();
            changeLog.setBusMacAddress(macAddress);
            changeLog.setChauffeurNom(chauffeurNom);
            changeLog.setChauffeurUniqueNumber(chauffeurUniqueNumber);
            changeLog.setDestination(lastDestination);
            changeLog.setDateChange(new Date());
            busChangeLogRepository.save(changeLog);

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
            return busRepository.save(bus);
        }
        return null;
    }

    // Terminer un trajet
    public Bus endTrip(String macAddress) {
        Bus bus = busRepository.findByMacAddress(macAddress);
        if (bus != null) {
            bus.setFinTrajet(new Date());
            return busRepository.save(bus);
        }
        return null;
    }

    // Mettre à jour le niveau de batterie et l'état de charge
    public Bus updateBatteryLevel(String macAddress, Integer niveauBatterie, boolean isCharging) {
        Bus bus = busRepository.findByMacAddress(macAddress);
        if (bus != null) {
            bus.setNiveauBatterie(niveauBatterie);
            bus.setCharging(isCharging);
            return busRepository.save(bus);
        }
        return null;
    }

    // Récupérer l'historique des changements de chauffeur et de destination
    public List<BusChangeLog> getBusChangeLog() {
        return busChangeLogRepository.findAll();
    }
}
