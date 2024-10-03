package com.bustrans.backend.controller;

import com.bustrans.backend.dto.BusHistoryDTO;
import com.bustrans.backend.service.BusHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus-history")
public class BusHistoryController {

    @Autowired
    private BusHistoryService busHistoryService;

    // Récupérer l'historique d'un bus par son id
    @GetMapping("/{busId}")
    public ResponseEntity<List<BusHistoryDTO>> getBusHistory(@PathVariable Long busId) {
        List<BusHistoryDTO> history = busHistoryService.getBusHistoryByBusId(busId);
        return ResponseEntity.ok(history);
    }
}
