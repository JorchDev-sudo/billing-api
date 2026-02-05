package com.saas.billing.billing_api.dtos.requests;

public class ClientCreateRequest {
    public String name;
    public String email;
    public String identification;

    public ClientCreateRequest(
            String name,
            String email,
            String identification){

        this.name = name;
        this.email = email;
        this.identification = identification;
    }
}
