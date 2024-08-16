package com.bustrans.backend.repository;

import com.bustrans.backend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // Custom query methods can be added here if needed
}
