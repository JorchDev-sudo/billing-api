package com.saas.billing.billing_api.mappers;

import com.saas.billing.billing_api.dtos.requests.ClientCreateRequest;
import com.saas.billing.billing_api.dtos.responses.ClientResponse;
import com.saas.billing.billing_api.entities.Client;

public class ClientMapper {
    public Client toEntity(ClientCreateRequest request){
        Client client = new Client();

        client.setName(request.name);
        client.setEmail(request.email);
        client.setIdentification(request.identification);

        return client;
    }

    public ClientResponse toResponse(Client client){
        return new ClientResponse(client.getName(), client.getEmail());
    }
}
