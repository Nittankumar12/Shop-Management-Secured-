package com.Railworld.Shop.Management.Spring.Boot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expenseId;
    private Integer expenseAmount;
    private Integer sweetQuantity;
    private Integer sweetId;

//    @OneToOne(mappedBy = "expense",cascade = CascadeType.ALL)
//    private Sweet sweet;


}
