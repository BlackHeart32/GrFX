package com.bs32.GrFX.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Item {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long itemId;
    private String name;
    private String brand;
    private String imageUrl;
    private String color;
    private double quantity;
    private double cost;
    private double price;

}
