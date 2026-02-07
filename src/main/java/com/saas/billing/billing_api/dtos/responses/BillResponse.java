package com.saas.billing.billing_api.dtos.responses;

import com.saas.billing.billing_api.entities.internal.BillStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record BillResponse(
        UUID id,
        String billNumber,
        BillStatus status,
        BigDecimal total,
        LocalDate issueDate) {
}
