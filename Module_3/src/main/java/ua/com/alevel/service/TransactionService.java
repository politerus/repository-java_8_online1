package ua.com.alevel.service;

import ua.com.alevel.dao.TransactionDao;
import ua.com.alevel.entity.Transaction;

import java.util.List;

public class TransactionService {
    private final TransactionDao transactionDao;

    public TransactionService(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public void createTransaction(Transaction transaction) throws IllegalArgumentException {
        if (transaction.getAmount() == 0) {
            throw new IllegalArgumentException("Операції з нульовим оборотом неприпустимі");
        }
        if (transaction.getCategory() == null) {
            throw new IllegalArgumentException("Операції без категорії неприпустимі");
        }
        transactionDao.save(transaction);
    }
    public Transaction findTransactionById(Long id) {
        return transactionDao.findById(id).orElse(null);
    }

    public void updateTransaction(Transaction transaction) {
        transactionDao.save(transaction);
    }

    public void deleteTransaction(Transaction transaction) {
        transactionDao.delete(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionDao.findAll();
    }
}
