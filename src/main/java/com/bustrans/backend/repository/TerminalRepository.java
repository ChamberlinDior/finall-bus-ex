package com.bustrans.backend.repository;

import com.bustrans.backend.model.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Long> {
    Terminal findByMacAddress(String macAddress);
}
