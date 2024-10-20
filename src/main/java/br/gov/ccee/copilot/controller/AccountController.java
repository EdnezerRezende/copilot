package br.gov.ccee.copilot.controller;

import br.gov.ccee.copilot.model.Account;
import br.gov.ccee.copilot.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{accountNumber}/balance")
    public Double getAccountBalance(@PathVariable String accountNumber) {
        final Account account = accountService.getAccountByNumber(accountNumber);
        return account.getBalance();
    }

    @PostMapping
    public Account createAccount(@Valid @RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PostMapping("/{accountNumber}/deposit")
    public Account deposit(@PathVariable String accountNumber, @RequestParam Double amount) {
        return accountService.deposit(accountNumber, amount);
    }

    @PostMapping("/{accountNumber}/withdraw")
    public Account withdraw(@PathVariable String accountNumber, @RequestParam Double amount) {
        return accountService.withdraw(accountNumber, amount);
    }

}
