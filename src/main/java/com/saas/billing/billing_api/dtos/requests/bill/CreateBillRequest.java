package com.saas.billing.billing_api.dtos.requests.bill;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class CreateBillRequest {
    @NotNull
    private UUID customerId;

    @NotNull
    private LocalDate issueDate;

    private LocalDate dueDate;

    @NotBlank
    private String currency;

    private BigDecimal exchangeRate;

    /* A futuro:
    @NotEmpty
    private List<CreateItemRequest> items;
     */
    private BigDecimal discountAmount;
}