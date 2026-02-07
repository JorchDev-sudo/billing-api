package com.saas.billing.billing_api.repositories;

import com.saas.billing.billing_api.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BillRepository extends JpaRepository<Bill, UUID> {
}
