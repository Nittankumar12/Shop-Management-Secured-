package com.Railworld.Shop.Management.Spring.Boot.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
public class Sweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sId;
    private String sName;
    private Integer sQuantity;

    @NonNull
    private Integer sCost;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Order order;

}
