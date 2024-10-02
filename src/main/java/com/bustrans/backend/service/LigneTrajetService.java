package com.bustrans.backend.service;

import com.bustrans.backend.model.LigneTrajet;
import com.bustrans.backend.repository.LigneTrajetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneTrajetService {

    @Autowired
    private LigneTrajetRepository ligneTrajetRepository;

    public List<LigneTrajet> getAllLignes() {
        return ligneTrajetRepository.findAll();
    }

    public LigneTrajet saveLigne(LigneTrajet ligneTrajet) {
        return ligneTrajetRepository.save(ligneTrajet);
    }

    public LigneTrajet getLigneById(Long id) {
        return ligneTrajetRepository.findById(id).orElse(null);
    }

    public void deleteLigne(Long id) {
        ligneTrajetRepository.deleteById(id);
    }
}
