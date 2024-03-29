package BankProject.service;

import BankProject.domain.entity.dto.TransactionDTO;
import BankProject.repository.TransactionRepository;
import BankProject.service.interfaces.TransactionServiceInterface;
import BankProject.service.mapping.TransactionMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService implements TransactionServiceInterface {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionMappingService transactionMappingService;

    @Override
    public List<TransactionDTO> findAll() {
        return transactionRepository.findAll()
                .stream()
                .map(transactionMappingService::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDTO getById(int id) {
        return transactionRepository.findById(id).isPresent()
                ? transactionMappingService.mapToDTO(transactionRepository.findById(id).get())
                : null;
    }

    @Override
    public void createTransaction(TransactionDTO transaction) {
        transactionRepository.save(transactionMappingService.mapToEntity(transaction));
    }

    @Override
    public void deleteTransactionById(int id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public List<TransactionDTO> getTransactionsByAccountID(int accountId, java.sql.Timestamp from, java.sql.Timestamp to) {

        return transactionRepository.findByCreditAccountIdAndCreatedAtAndCreatedAt(accountId, from, to)
                .stream()
                .map(transactionMappingService::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionDTO> getTransactionsByClientId(int clientId, Timestamp from, Timestamp to) {

        return transactionRepository.findByClientIdAndCreatedAtAndCreatedAt(clientId, from, to)
                .stream()
                .map(transactionMappingService::mapToDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<TransactionDTO> getTransactionsByTime(Timestamp from, Timestamp to) {

        return transactionRepository.findByCreatedAtAndCreatedAt(from, to)
                .stream()
                .map(transactionMappingService::mapToDTO)
                .collect(Collectors.toList());
    }
}
