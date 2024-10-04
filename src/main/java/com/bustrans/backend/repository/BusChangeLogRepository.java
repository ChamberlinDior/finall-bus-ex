package com.bustrans.backend.repository;

import com.bustrans.backend.model.BusChangeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusChangeLogRepository extends JpaRepository<BusChangeLog, Long> {
}
