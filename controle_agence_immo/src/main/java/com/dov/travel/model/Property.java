package com.dov.travel.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
@Table(name = "property")
public class Property {
    @Id
    @Column(name = "property_id")
    private String propertyId;
    // test
    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PropertyType propertyType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "sale_date")
    private Date saleDate;

    @Column(name = "sale_price")
    private BigDecimal salePrice;
}