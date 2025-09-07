package com.example.Security.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double quantity;

    @ManyToOne
    private  Coin coin;

    private double buyPrice;

    private  double sellPrice;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
