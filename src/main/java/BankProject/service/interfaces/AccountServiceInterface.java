package BankProject.service.interfaces;

import BankProject.domain.entity.dto.AccountDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


public interface AccountServiceInterface {

    List<AccountDTO> findAll();

    AccountDTO findById(int id);

    AccountDTO saveAccount(AccountDTO account);

    void deleteAccount(AccountDTO account);

    void deleteAccountById(int id);

    BigDecimal getBalance(AccountDTO account);

    void deposit(AccountDTO account, BigDecimal amount);

    void withdraw(AccountDTO account, BigDecimal amount);

    void transfer(AccountDTO from, AccountDTO to, BigDecimal amount);

//    void updateAccount(
//            UUID id,
//            Client client,
//            Product product,
//            String name,
//            AccountStatus status,
//            AccountType type,
//            BigDecimal balance,
//            Currency currency,
//            Timestamp createdAt,
//            Timestamp updatedAt
//            );


}
