package com.example.Banking3.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock private ClientRepository clientRepository;
    private ClientService underTest;




    @Test
    void getUsers() {
        //when
        underTest.getUsers();

        //then
        verify(clientRepository).findAll();


    }

    @Test
    void addNewClient() {
        String email = "kamil@Gmail.com";
        String email2 = "slimak@Gmail.com";
        // given
        Client client = new Client("Kamil","kamil@Gmail.com", LocalDate.of(2000, 8, 25));

        // when
        underTest.addNewClient(client);

        //then
        ArgumentCaptor<Client> clientArgumentCaptor =
                ArgumentCaptor.forClass(Client.class);

        verify(clientRepository).save(clientArgumentCaptor.capture());

        Client captureClient = clientArgumentCaptor.getValue();

        assertThat(captureClient).isEqualTo(client);
    }

    @Test
    @Disabled
    void deleteClient() {
    }

    @Test
    @Disabled
    void updateStudent() {
    }
}