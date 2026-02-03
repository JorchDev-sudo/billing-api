package com.saas.billing.billing_api.utils;

import com.saas.billing.billing_api.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class UtilService {
    private final ClientRepository clientRepository;

    public UtilService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
}
