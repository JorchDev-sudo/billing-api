package com.saas.billing.billing_api.controllers;

import com.saas.billing.billing_api.dtos.requests.ClientCreateRequest;
import com.saas.billing.billing_api.dtos.responses.ClientResponse;
import com.saas.billing.billing_api.services.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;


@WebMvcTest(ClientController.class)
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    @MockitoBean
    private ClientService clientService;

    @Test
    void should_create_client_when_request_is_valid() throws Exception {
        ClientResponse response = new ClientResponse(
                "example",
                "example@email.com"
        );

        when(clientService.create(any(ClientCreateRequest.class)))
                .thenReturn(response);

        mockMvc.perform(post("/api/client")
                        .with(csrf())
                        .with(user("test"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                new ClientCreateRequest("example", "example@email.com", "UUID")
                        )))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("example"))
                .andExpect(jsonPath("$.email").value("example@email.com"));
    }
}
