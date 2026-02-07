package com.saas.billing.billing_api.services;

import com.saas.billing.billing_api.repositories.BillRepository;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    private final BillRepository billRepository;

    public BillService(BillRepository billRepository){
        this.billRepository = billRepository;
    }

}
