package com.saas.billing.billing_api.mappers;

import com.saas.billing.billing_api.dtos.requests.bill.CreateBillRequest;
import com.saas.billing.billing_api.dtos.responses.BillResponse;
import com.saas.billing.billing_api.entities.Bill;

public class BillMapper {
    public Bill toEntity(CreateBillRequest request){
        Bill newBill = new Bill();
        newBill.setCustomerId(request.getCustomerId());
        newBill.setIssueDate(request.getIssueDate());
        newBill.setDueDate(request.getDueDate());
        newBill.setCurrency(request.getCurrency());
        newBill.setExchangeRate(request.getExchangeRate());
        newBill.setDiscountAmount(request.getDiscountAmount());

        return newBill;
    }

    public BillResponse toResponse(Bill bill){
        return new BillResponse(
                bill.getId(),
                bill.getBillNumber(),
                bill.getStatus(),
                bill.getTotal(),
                bill.getIssueDate());
    }
}
