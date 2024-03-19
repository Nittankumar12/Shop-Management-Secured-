package com.Railworld.Shop.Management.Spring.Boot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oId;
    private Integer oValue;
    @Temporal(TemporalType.DATE)
    private Date oDate;
    private Integer oAmount;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn
    private List<String> sweetList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cId")
    private Customer customer;

}
