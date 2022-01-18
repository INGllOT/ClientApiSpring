package com.example.Banking3.Client;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


@Entity
@Table
@Data
@NoArgsConstructor
public class Client {

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;
    //private String password;
    //private String cardNumber;


    public Client(Long id,
                  String name,
                  String email,
                  LocalDate dob
                  ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public Client(String name,
                  String email,
                  LocalDate dob
                  ) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
