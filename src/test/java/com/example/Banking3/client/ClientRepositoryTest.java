package com.example.Banking3.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ClientRepositoryTest {

    @Autowired
    private  ClientRepository underTest;



    @Test
    void itShouldSelectIfClientExistByEmail() {
        //given
        String email = "kamil@Gmail.com";
        String email2 = "slimak@Gmail.com";

        Client client = new Client("Kamil","kamil@Gmail.com", LocalDate.of(2000, 8, 25));
        underTest.save(client);

        //when
        boolean exist = underTest.existsByEmail(email);

        //then
        assertThat(exist).isTrue();

    }

    @Test
    void itShouldCheckIfClientEmailExist() {
        //given
        String email = "kamil@Gmail.com";
        String email2 = "slimak@Gmail.com";

        //when
        boolean exist = underTest.existsByEmail(email);

        //then
        assertThat(exist).isFalse();

    }
}