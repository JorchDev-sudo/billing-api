package com.saas.billing.billing_api.controllers;

import com.saas.billing.billing_api.dtos.requests.ClientCreateRequest;
import com.saas.billing.billing_api.dtos.responses.ClientResponse;
import com.saas.billing.billing_api.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientResponse> postClient(ClientCreateRequest request){
        return ResponseEntity.status(201).body(clientService.create(request));

    }
}
