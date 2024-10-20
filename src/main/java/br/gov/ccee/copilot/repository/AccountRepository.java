package br.gov.ccee.copilot.repository;

import br.gov.ccee.copilot.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    Account findByAccountNumber(String accountNumber);
    Account saveAccount(Account account);
}
