package ua.com.alevel.dao;

import ua.com.alevel.entity.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class AccountDaoImpl implements AccountDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Account account) {
        if (account.getId() == null) {
            entityManager.persist(account);
        } else {
            entityManager.merge(account);
        }
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Account.class, id));
    }

    @Override
    public void delete(Account account) {
        entityManager.remove(account);
    }

    @Override
    public List<Account> findAll() {
        TypedQuery<Account> query = entityManager.createQuery("SELECT a FROM Account a", Account.class);
        return query.getResultList();
    }

    @Override
    public List<Account> findByUserId(Long userId) {
        TypedQuery<Account> query = entityManager.createQuery(
                "SELECT a FROM Account a WHERE a.user.id = :userId", Account.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public void update(Account account) {
        entityManager.merge(account);
    }


}
