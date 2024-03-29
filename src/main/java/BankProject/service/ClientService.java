package BankProject.service;

import BankProject.domain.entity.dto.ClientDTO;
import BankProject.repository.ClientRepository;
import BankProject.service.interfaces.ClientServiceInterface;
import BankProject.service.mapping.ClientMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService implements ClientServiceInterface {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientMappingService clientMappingService;
    @Override
    public List<ClientDTO> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientMappingService::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getById(int id) {
        return clientMappingService.mapToDTO(
                clientRepository.findById(id)
                        .isPresent() ? clientRepository.findById(id).get() : null);
    }

    @Override
    public void saveClient(ClientDTO client) {
        clientRepository.save(clientMappingService.mapToEntity(client));
    }

    @Override
    public void deleteClient(ClientDTO client) {
        clientRepository.delete(clientMappingService.mapToEntity(client));
    }

    public void deleteClientById(int id) {
        clientRepository.deleteById(id);
    }

}
