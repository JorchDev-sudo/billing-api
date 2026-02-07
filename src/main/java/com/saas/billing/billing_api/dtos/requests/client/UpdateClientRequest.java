package com.saas.billing.billing_api.dtos.requests.client;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateClientRequest {
    public String name;
    public String email;
    public String identification;

}
