package com.bustrans.backend.controller;

import com.bustrans.backend.dto.ForfaitDTO;
import com.bustrans.backend.model.Client;
import com.bustrans.backend.model.Forfait;
import com.bustrans.backend.service.ClientService;
import com.bustrans.backend.service.ForfaitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/api/forfaits")
public class ForfaitController {

    @Autowired
    private ForfaitService forfaitService;

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Forfait> createForfait(@RequestBody ForfaitDTO forfaitDTO) {
        Client client = clientService.getClientById(forfaitDTO.getClientId());
        if (client == null) {
            return ResponseEntity.badRequest().build();
        }

        Date dateActivation = new Date();
        Date dateExpiration = calculateExpirationDate(forfaitDTO.getTypeForfait(), dateActivation);

        Forfait forfait = new Forfait(forfaitDTO.getTypeForfait(), dateActivation, dateExpiration, client);
        Forfait savedForfait = forfaitService.saveForfait(forfait);
        return ResponseEntity.ok(savedForfait);
    }

    private Date calculateExpirationDate(String typeForfait, Date dateActivation) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateActivation);
        switch (typeForfait) {
            case "jour":
                cal.add(Calendar.DAY_OF_MONTH, 1);
                break;
            case "semaine":
                cal.add(Calendar.DAY_OF_MONTH, 7);
                break;
            case "mois":
                cal.add(Calendar.MONTH, 1);
                break;
        }
        return cal.getTime();
    }
}
