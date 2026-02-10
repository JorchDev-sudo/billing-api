package com.saas.billing.billing_api.entities;

import com.saas.billing.billing_api.entities.internal.BillStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(
        name = "bills",
        indexes = {
                @Index(name = "idx_bill_number", columnList = "bill_number"),
                @Index(name = "idx_bill_status", columnList = "status"),
                @Index(name = "idx_bill_hacienda_key", columnList = "hacienda_key")
        },
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_bill_sequence",
                        columnNames = {"sequence"}
                )
        }
)
public class Bill {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "bill_number", nullable = false, length = 50)
    private String billNumber;

    @Column(name = "sequence", nullable = false, length = 20)
    private String sequence;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private BillStatus status;

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "customer_name", nullable = false, length = 150)
    private String customerName;

    @Column(name = "customer_tax_id", nullable = false, length = 30)
    private String customerTaxId;

    @Column(name = "subtotal", nullable = false, precision = 18, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "tax_amount", nullable = false, precision = 18, scale = 2)
    private BigDecimal taxAmount;

    @Column(name = "discount_amount", precision = 18, scale = 2)
    private BigDecimal discountAmount;

    @Column(name = "total", nullable = false, precision = 18, scale = 2)
    private BigDecimal total;

    @Column(name = "currency", nullable = false, length = 5)
    private String currency;

    @Column(name = "exchange_rate", precision = 18, scale = 6)
    private BigDecimal exchangeRate;
/*
    A futuro:
    @Enumerated(EnumType.STRING)
    @Column(name = "tax_type", nullable = false, length = 20)
    private TaxType taxType;
 */
    @Column(name = "tax_rate", precision = 5, scale = 2)
    private BigDecimal taxRate;

    @Column(name = "hacienda_key", length = 50)
    private String haciendaKey;
/*
    A futuro:
    @Enumerated(EnumType.STRING)
    @Column(name = "hacienda_status", length = 20)
    private HaciendaStatus haciendaStatus;
*/
    @Column(name = "hacienda_message", length = 500)
    private String haciendaMessage;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
