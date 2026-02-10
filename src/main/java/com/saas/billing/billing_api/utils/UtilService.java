package com.saas.billing.billing_api.utils;

import com.saas.billing.billing_api.entities.Client;
import com.saas.billing.billing_api.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtilService {
    private final ClientRepository clientRepository;

    public UtilService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public boolean existsClientById(UUID id){
        return clientRepository.existsById(id);
    }
}
