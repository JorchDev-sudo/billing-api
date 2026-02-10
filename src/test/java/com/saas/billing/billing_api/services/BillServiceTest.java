package com.saas.billing.billing_api.services;

import com.saas.billing.billing_api.dtos.requests.bill.CreateBillRequest;
import com.saas.billing.billing_api.dtos.responses.BillResponse;
import com.saas.billing.billing_api.entities.Bill;
import com.saas.billing.billing_api.entities.internal.BillStatus;
import com.saas.billing.billing_api.mappers.BillMapper;
import com.saas.billing.billing_api.repositories.BillRepository;
import com.saas.billing.billing_api.utils.UtilService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BillServiceTest {

    @Mock
    private BillRepository billRepository;

    @Mock
    private BillMapper billMapper;

    @Mock
    private UtilService utilService;

    @InjectMocks
    private BillService billService;

    @Test
    void shouldCreateBill() {
        CreateBillRequest request = new CreateBillRequest();

        Bill bill = new Bill();
        Bill savedBill = new Bill();
        BillResponse response = new BillResponse(
                UUID.randomUUID(),
                "123",
                BillStatus.ISSUED,
                BigDecimal.ONE,
                LocalDate.now());

        when(utilService.existsClientById(any())).thenReturn(true);
        when(billMapper.toEntity(request)).thenReturn(bill);
        when(billRepository.save(bill)).thenReturn(savedBill);
        when(billMapper.toResponse(savedBill)).thenReturn(response);

        BillResponse result = billService.create(request);

        assertNotNull(result);
        verify(billRepository).save(bill);
        verify(billMapper).toEntity(request);
        verify(billMapper).toResponse(savedBill);
    }

    @Test
    void getBill_success() {
        String billNumber = "BILL-001";
        Bill bill = new Bill();
        BillResponse response = new BillResponse(
                UUID.randomUUID(),
                billNumber,
                BillStatus.ISSUED,
                BigDecimal.ONE,
                LocalDate.now());

        when(billRepository.findByBillNumber(billNumber))
                .thenReturn(Optional.of(bill));
        when(billMapper.toResponse(bill))
                .thenReturn(response);

        BillResponse result = billService.get(billNumber);

        assertNotNull(result);
        verify(billRepository).findByBillNumber(billNumber);
    }

    @Test
    void updateBill_success() {
        String billNumber = "BILL-001";
        BillStatus status = BillStatus.PAID;

        Bill bill = new Bill();
        BillResponse response = new BillResponse(
                UUID.randomUUID(),
                billNumber,
                BillStatus.ISSUED,
                BigDecimal.ONE,
                LocalDate.now());

        when(billRepository.findByBillNumber(billNumber))
                .thenReturn(Optional.of(bill));
        when(billMapper.toResponse(bill))
                .thenReturn(response);

        BillResponse result = billService.update(status, billNumber);

        assertNotNull(result);
        verify(billMapper).toUpdate(status, bill);
    }

    @Test
    void createBill_clientNotFound() {
        CreateBillRequest request = new CreateBillRequest();
        request.setCustomerId(UUID.randomUUID());

        when(utilService.existsClientById(any(UUID.class))).thenReturn(false);

        assertThrows(EntityNotFoundException.class,
                () -> billService.create(request));

        verify(billRepository, never()).save(any());
    }

    @Test
    void getBill_notFound() {
        when(billRepository.findByBillNumber("INVALID"))
                .thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class,
                () -> billService.get("INVALID"));
    }

    @Test
    void updateBill_notFound() {
        when(billRepository.findByBillNumber("INVALID"))
                .thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class,
                () -> billService.update(BillStatus.CANCELED, "INVALID"));
    }
}
