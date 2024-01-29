package ua.com.alevel.dao;

import ua.com.alevel.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountDao {
    void save(Account account);

    Optional<Account> findById(Long id);

    void delete(Account account);

    List<Account> findAll();

    List<Account> findByUserId(Long userId);

    void update(Account account);

}
