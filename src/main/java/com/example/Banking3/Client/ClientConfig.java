package com.example.Banking3.Client;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.AUGUST;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository){
        return args -> {
           Client Wojciech = new Client(
                    "Wojciech",
                    "MAIL@GMAIL.com" ,
                    LocalDate.of(2000, AUGUST, 25)

            );
            Client Adam = new Client(
                    "Adam",
                    "Adam@GMAIL.com" ,
                    LocalDate.of(1999, AUGUST, 25)

            );

            repository.saveAll(List.of(Wojciech,Adam));
        };
    }
}
