package ua.com.alevel.service;

import ua.com.alevel.dao.AccountDao;
import ua.com.alevel.entity.Account;

import java.util.List;

public class AccountService {
    private final AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void createAccount(Account account) {
        accountDao.save(account);
    }

    public Account findAccountById(Long id) {
        return accountDao.findById(id).orElse(null);
    }

    public void updateAccount(Account account) {
        accountDao.save(account);
    }

    public void deleteAccount(Account account) {
        accountDao.delete(account);
    }

    public List<Account> getAllAccounts() {
        return accountDao.findAll();
    }
}
