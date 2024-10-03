package com.bustrans.backend.repository;

import com.bustrans.backend.model.BusHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusHistoryRepository extends JpaRepository<BusHistory, Long> {
    List<BusHistory> findByBusId(Long busId);
}
