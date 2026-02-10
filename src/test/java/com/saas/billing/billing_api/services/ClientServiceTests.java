package com.saas.billing.billing_api.services;

import com.saas.billing.billing_api.dtos.requests.client.CreateClientRequest;
import com.saas.billing.billing_api.dtos.responses.ClientResponse;
import com.saas.billing.billing_api.entities.Client;
import com.saas.billing.billing_api.mappers.ClientMapper;
import com.saas.billing.billing_api.repositories.ClientRepository;
import jakarta.persistence.EntityExistsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTests {
    @Mock
    ClientRepository clientRepository;

    @Mock
    ClientMapper mapper;

    @InjectMocks
    ClientService clientService;

    @Test
    public void shouldCreateClient(){
        CreateClientRequest request = new CreateClientRequest(
                "example",
                "example@email.com",
                "1234");

        Client client = new Client();
        client.setName(request.name);
        client.setEmail(request.email);
        client.setIdentification(request.identification);

        when(clientRepository.existsByEmail(request.email)).thenReturn(false);
        when(clientRepository.existsByIdentification(request.identification)).thenReturn(false);
        when(clientRepository.save(client)).thenReturn(client);

        when(mapper.toEntity(request)).thenReturn(client);
        when(mapper.toResponse(client)).thenReturn(new ClientResponse(request.name, request.email));

        ClientResponse response = clientService.create(request);

        assertThat(response.name()).isEqualTo(request.name);
        assertThat(response.email()).isEqualTo(request.email);

        verify(clientRepository).existsByEmail(request.email);
        verify(clientRepository).existsByIdentification(request.identification);
        verify(clientRepository).save(client);

        verify(mapper).toEntity(request);
        verify(mapper).toResponse(client);
    }

    @Test
    void shouldThrowExceptionWhenEmailAlreadyExists() {
        CreateClientRequest request = new CreateClientRequest(
                "example",
                "example@email.com",
                "1234"
        );

        when(clientRepository.existsByEmail(request.email)).thenReturn(true);

        assertThatThrownBy(() -> clientService.create(request))
                .isInstanceOf(EntityExistsException.class);

        verify(clientRepository, never()).save(any());

        verify(mapper, never()).toEntity(any());
        verify(mapper, never()).toResponse(any());
    }

    @Test
    void shouldThrowExceptionWhenIdentificationAlreadyExists() {
        CreateClientRequest request = new CreateClientRequest(
                "example",
                "example@email.com",
                "1234"
        );

        when(clientRepository.existsByEmail(request.email)).thenReturn(false);
        when(clientRepository.existsByIdentification(request.identification)).thenReturn(true);

        assertThatThrownBy(() -> clientService.create(request))
                .isInstanceOf(EntityExistsException.class);

        verify(clientRepository).existsByEmail(request.email);
        verify(clientRepository).existsByIdentification(request.identification);

        verify(clientRepository, never()).save(any());

        verify(mapper, never()).toEntity(any());
        verify(mapper, never()).toResponse(any());
    }
}
