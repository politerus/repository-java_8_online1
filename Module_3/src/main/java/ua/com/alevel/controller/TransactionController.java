package ua.com.alevel.controller;

import ua.com.alevel.entity.Transaction;
import ua.com.alevel.service.TransactionService;

import java.util.List;
import java.util.Optional;

public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void createTransaction(Transaction transaction) {
        transactionService.createTransaction(transaction);
    }

    public Optional<Transaction> findTransactionById(Long id) {
        return Optional.ofNullable(transactionService.findTransactionById(id));
    }

    public void updateTransaction(Transaction transaction) {
        transactionService.updateTransaction(transaction);
    }

    public void deleteTransaction(Transaction transaction) {
        transactionService.deleteTransaction(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
}
