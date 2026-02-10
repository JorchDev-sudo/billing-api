package com.saas.billing.billing_api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "client_name", length = 100, nullable = false)
    private String name;

    @Column(name = "client_email", unique = true, nullable = false)
    private String email;

    @Column(name = "client_identification", unique = true, nullable = false)
    private String identification;

    public Client(){}
}
