package com.example.demo.models;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class ProductosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id", length = 25, columnDefinition = "serial")
    private Long id;
    @Column(name = "name", length = 150, nullable = false)
    private String nombre;
    @Column(name = "description", length = 250)
    private String descripcion;
    @Column(name = "category", length = 150)
    private String categoria;
    @Column(name = "price", length = 25)
    private BigDecimal precio;
    @Column(name = "stock", length = 25)
    private int stock;
}
