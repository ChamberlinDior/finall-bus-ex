package com.bustrans.backend.service;

import com.bustrans.backend.model.Carte;
import com.bustrans.backend.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteService {

    @Autowired
    private CarteRepository carteRepository;

    public List<Carte> getAllCartes() {
        return carteRepository.findAll();
    }

    public Carte getCarteById(Long id) {
        return carteRepository.findById(id).orElse(null);
    }

    public Carte saveCarte(Carte carte) {
        return carteRepository.save(carte);
    }

    public void deleteCarte(Long id) {
        carteRepository.deleteById(id);
    }
}
