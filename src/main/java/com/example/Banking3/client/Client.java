package com.example.Banking3.client;

import com.example.Banking3.shoppingCard.ShoppingCart;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


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
    private ClientType clientType = ClientType.NORMAL;
    private String name;
    private String email;
    private String password;
    private LocalDate dob;
    @Transient
    private Integer age;

    @OneToMany(targetEntity = ShoppingCart.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="cp_fk",referencedColumnName = "id")
    List<ShoppingCart> shoppingCart = new ArrayList<>() ;


    public Client(String name,
                  String email,
                  LocalDate dob
                  ) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public List<ShoppingCart> getShoppingCart() {
        return shoppingCart;
    }


}
