package com.saas.billing.billing_api.services;

import com.saas.billing.billing_api.dtos.requests.client.CreateClientRequest;
import com.saas.billing.billing_api.dtos.requests.client.UpdateClientRequest;
import com.saas.billing.billing_api.dtos.responses.ClientResponse;
import com.saas.billing.billing_api.entities.Client;
import com.saas.billing.billing_api.mappers.ClientMapper;
import com.saas.billing.billing_api.repositories.ClientRepository;
import com.saas.billing.billing_api.utils.UtilService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final UtilService utilService;

    public ClientService(
            ClientRepository clientRepository,
            UtilService utilService,
            ClientMapper clientMapper)
    {
        this.clientRepository = clientRepository;
        this.utilService = utilService;
        this.clientMapper = clientMapper;
    }

    public ClientResponse create(CreateClientRequest request){
        if (clientRepository.existsByEmail(request.email) ||
                clientRepository.existsByIdentification(request.identification)) {
            throw new EntityExistsException();
        }

        Client newClient = clientMapper.toEntity(request);
        Client savedClient = clientRepository.save(newClient);

        return clientMapper.toResponse(savedClient);
    }

    public ClientResponse update(String email, UpdateClientRequest request) {
        Client client = clientRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(email));;

        clientMapper.toUpdate(request, client);

        Client updated = clientRepository.save(client);

        return clientMapper.toResponse(updated);
    }

    public void delete(Client client){
        clientRepository.delete(client);
    }
}
