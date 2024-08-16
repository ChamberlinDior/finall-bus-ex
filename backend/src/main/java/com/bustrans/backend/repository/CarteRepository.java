package com.bustrans.backend.repository;

import com.bustrans.backend.model.Carte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteRepository extends JpaRepository<Carte, Long> {
    // Custom query methods can be added here if needed
}
