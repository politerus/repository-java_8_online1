package ua.com.alevel.dao;

import ua.com.alevel.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionDao {
    void save(Transaction transaction);

    Optional<Transaction> findById(Long id);

    void delete(Transaction transaction);

    List<Transaction> findAll();

    List<Transaction> findByAccountId(Long accountId);


}
