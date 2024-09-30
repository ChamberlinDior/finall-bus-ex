package com.bustrans.backend.repository;


import com.bustrans.backend.model.GestionTerminals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestionTerminalsRepository extends JpaRepository<GestionTerminals, Long> {
}
