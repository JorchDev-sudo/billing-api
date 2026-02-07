package com.saas.billing.billing_api.dtos.requests.client;

public class CreateClientRequest {
    public String name;
    public String email;
    public String identification;

    public CreateClientRequest(
            String name,
            String email,
            String identification){

        this.name = name;
        this.email = email;
        this.identification = identification;
    }
}
