package com.saas.billing.billing_api.services;

import com.saas.billing.billing_api.dtos.requests.ClientCreateRequest;
import com.saas.billing.billing_api.dtos.responses.ClientResponse;
import com.saas.billing.billing_api.entities.Client;
import com.saas.billing.billing_api.mappers.ClientMapper;
import com.saas.billing.billing_api.repositories.ClientRepository;
import com.saas.billing.billing_api.utils.UtilService;
import jakarta.persistence.EntityExistsException;
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

    public ClientResponse create(ClientCreateRequest request){
        if (clientRepository.existsByEmail(request.email)) {
            throw new EntityExistsException("Client with email: " + request.email + " exists");
        }
        if (clientRepository.existsByIdentification(request.identification)){
            throw new EntityExistsException("Client with identification: " + request.identification + "exists");
        }

        Client newClient = clientMapper.toEntity(request);
        Client savedClient = clientRepository.save(newClient);

        return clientMapper.toResponse(savedClient);
    }
}
