package ua.com.alevel.dao;

import ua.com.alevel.entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class TransactionDaoImpl implements TransactionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Transaction transaction) {
        if (transaction.getId() == null) {
            entityManager.persist(transaction);
        } else {
            entityManager.merge(transaction);
        }
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Transaction.class, id));
    }

    @Override
    public void delete(Transaction transaction) {
        entityManager.remove(entityManager.contains(transaction) ? transaction : entityManager.merge(transaction));
    }

    @Override
    public List<Transaction> findAll() {
        TypedQuery<Transaction> query = entityManager.createQuery("SELECT t FROM Transaction t", Transaction.class);
        return query.getResultList();
    }

    @Override
    public List<Transaction> findByAccountId(Long accountId) {
        TypedQuery<Transaction> query = entityManager.createQuery(
                "SELECT t FROM Transaction t WHERE t.account.id = :accountId", Transaction.class);
        query.setParameter("accountId", accountId);
        return query.getResultList();
    }


}
