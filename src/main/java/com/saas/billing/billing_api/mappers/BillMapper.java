package com.saas.billing.billing_api.mappers;

import com.saas.billing.billing_api.configs.MapStructConfig;
import com.saas.billing.billing_api.dtos.requests.bill.CreateBillRequest;
import com.saas.billing.billing_api.dtos.responses.BillResponse;
import com.saas.billing.billing_api.entities.Bill;
import com.saas.billing.billing_api.entities.internal.BillStatus;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapStructConfig.class)
public abstract class BillMapper {
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

    public abstract void toUpdate(
            BillStatus status,
            @MappingTarget Bill bill
    );

    public BillResponse toResponse(Bill bill){
        return new BillResponse(
                bill.getId(),
                bill.getBillNumber(),
                bill.getStatus(),
                bill.getTotal(),
                bill.getIssueDate());
    }
}
