package ua.com.alevel.controller;

import ua.com.alevel.entity.Account;
import ua.com.alevel.service.AccountService;

import java.util.List;
import java.util.Optional;

public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public void createAccount(Account account) {
        accountService.createAccount(account);
    }

    public Optional<Account> findAccountById(Long id) {
        return Optional.ofNullable(accountService.findAccountById(id));
    }

    public void updateAccount(Account account) {
        accountService.updateAccount(account);
    }

    public void deleteAccount(Account account) {
        accountService.deleteAccount(account);
    }

    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }
}
