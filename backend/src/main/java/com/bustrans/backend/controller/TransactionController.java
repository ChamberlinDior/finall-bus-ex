package com.bustrans.backend.controller;

import com.bustrans.backend.dto.TransactionDTO;
import com.bustrans.backend.model.Carte;
import com.bustrans.backend.model.Transaction;
import com.bustrans.backend.service.CarteService;
import com.bustrans.backend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CarteService carteService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Transaction transaction = transactionService.getTransactionById(id);
        if (transaction != null) {
            return ResponseEntity.ok(transaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transactionDTO) {
        Carte carte = carteService.getCarteById(transactionDTO.getCarteId());
        if (carte == null) {
            return ResponseEntity.badRequest().build();
        }
        Transaction transaction = new Transaction(new Date(), transactionDTO.getMontant(),
                transactionDTO.getTerminalId(), transactionDTO.getLieu(), carte);
        Transaction savedTransaction = transactionService.saveTransaction(transaction);
        return ResponseEntity.ok(savedTransaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody TransactionDTO transactionDTO) {
        Transaction transaction = transactionService.getTransactionById(id);
        if (transaction != null) {
            transaction.setMontant(transactionDTO.getMontant());
            transaction.setTerminalId(transactionDTO.getTerminalId());
            transaction.setLieu(transactionDTO.getLieu());
            Transaction updatedTransaction = transactionService.saveTransaction(transaction);
            return ResponseEntity.ok(updatedTransaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
