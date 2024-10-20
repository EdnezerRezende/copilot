package br.gov.ccee.copilot.service;

import br.gov.ccee.copilot.controller.exceptions.AccountNotFoundException;
import br.gov.ccee.copilot.controller.exceptions.InsufficientFundsException;
import br.gov.ccee.copilot.model.Account;
import br.gov.ccee.copilot.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountByNumber(final String accountNumber) {
        final Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException(accountNumber);
        }
        return account;
    }

    public Account createAccount(final Account account) {
        return accountRepository.save(account);
    }

    public Account deposit(final String accountNumber, final Double amount) {
        Account account = getAccountByNumber(accountNumber);
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

    public Account withdraw(final String accountNumber, final Double amount) {
        Account account = getAccountByNumber(accountNumber);
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            return accountRepository.save(account);
        } else {
            throw new InsufficientFundsException(accountNumber);
        }
    }

}
