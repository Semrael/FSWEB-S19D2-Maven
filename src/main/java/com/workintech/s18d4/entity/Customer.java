package com.workintech.s18d4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="customer",schema = "bank")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="salary")
    private Double salary;


    @OneToOne
    @JoinColumn(name="address_id",referencedColumnName ="id")
    private Address address;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Account> accounts;
}
