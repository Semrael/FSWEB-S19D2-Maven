package com.workintech.s18d4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="account",schema = "bank")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="account_name")
    private String accountName;
    @Column(name="money_amount")
    private Double moneyAmount;
    @ManyToOne
    @JoinColumn(name="customer_id",nullable = false)
    private Customer customer;


}
