package com.saas.billing.billing_api.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientUpdateRequest {
    public String name;
    public String email;
    public String identification;

}
