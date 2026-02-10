package com.saas.billing.billing_api.repositories;

import com.saas.billing.billing_api.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    boolean existsByEmail(String email);
    Optional<Client> findByEmail(String email);

    boolean existsByIdentification(String identification);
    boolean existsById(UUID uuid);

}
