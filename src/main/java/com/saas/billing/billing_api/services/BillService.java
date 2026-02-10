package com.saas.billing.billing_api.services;

import com.saas.billing.billing_api.dtos.requests.bill.CreateBillRequest;
import com.saas.billing.billing_api.dtos.responses.BillResponse;
import com.saas.billing.billing_api.entities.Bill;
import com.saas.billing.billing_api.entities.internal.BillStatus;
import com.saas.billing.billing_api.mappers.BillMapper;
import com.saas.billing.billing_api.repositories.BillRepository;
import com.saas.billing.billing_api.utils.UtilService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    private final UtilService utilService;
    private final BillRepository billRepository;
    private final BillMapper billMapper;

    public BillService(BillRepository billRepository, BillMapper billMapper, UtilService utilService){
        this.billRepository = billRepository;
        this.billMapper = billMapper;
        this.utilService = utilService;
    }

    public BillResponse create (CreateBillRequest request){
        if (!utilService.existsClientById(request.getCustomerId())){
            throw  new EntityNotFoundException();
        }

        Bill newBill = billMapper.toEntity(request);
        Bill savedBill = billRepository.save(newBill);
        return billMapper.toResponse(savedBill);
    }

    public BillResponse get (String billNumber){
        Bill bill = billRepository.findByBillNumber(billNumber)
                .orElseThrow(EntityNotFoundException::new);

        return billMapper.toResponse(bill);
    }

    public BillResponse update (BillStatus status, String billNumber){
        Bill bill = billRepository.findByBillNumber(billNumber)
                .orElseThrow(EntityNotFoundException::new);

        billRepository.save(bill);
        billMapper.toUpdate(status, bill);

        return billMapper.toResponse(bill);
    }
}
