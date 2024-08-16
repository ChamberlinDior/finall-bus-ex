package com.bustrans.backend.controller;

import com.bustrans.backend.dto.CarteDTO;
import com.bustrans.backend.model.Carte;
import com.bustrans.backend.model.Client;
import com.bustrans.backend.service.CarteService;
import com.bustrans.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/cartes")
public class CarteController {

    @Autowired
    private CarteService carteService;

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Carte> getAllCartes() {
        return carteService.getAllCartes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carte> getCarteById(@PathVariable Long id) {
        Carte carte = carteService.getCarteById(id);
        if (carte != null) {
            return ResponseEntity.ok(carte);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Carte> createCarte(@RequestBody CarteDTO carteDTO) {
        Client client = clientService.getClientById(carteDTO.getClientId());
        if (client == null) {
            return ResponseEntity.badRequest().build();
        }
        Carte carte = new Carte(
                carteDTO.getNumCarte(),
                carteDTO.getDateDelivrance(),  // Utilisation de la date fournie dans le DTO
                carteDTO.getDateFinValidite(), // Utilisation de la date fournie dans le DTO
                carteDTO.getNomAgentDelivrance(),
                carteDTO.getStatut(),
                client
        );
        Carte savedCarte = carteService.saveCarte(carte);
        return ResponseEntity.ok(savedCarte);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carte> updateCarte(@PathVariable Long id, @RequestBody CarteDTO carteDTO) {
        Carte carte = carteService.getCarteById(id);
        if (carte != null) {
            carte.setDateFinValidite(carteDTO.getDateFinValidite());  // Utilisation de la date fournie dans le DTO
            carte.setNomAgentDelivrance(carteDTO.getNomAgentDelivrance());
            carte.setStatut(carteDTO.getStatut());
            Carte updatedCarte = carteService.saveCarte(carte);
            return ResponseEntity.ok(updatedCarte);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarte(@PathVariable Long id) {
        carteService.deleteCarte(id);
        return ResponseEntity.noContent().build();
    }
}
