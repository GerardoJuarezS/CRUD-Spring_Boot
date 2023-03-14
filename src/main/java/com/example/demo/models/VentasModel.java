package com.example.demo.models;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ventas")
public class VentasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id", length = 25, columnDefinition = "serial")
    private Long id;
    @Column(name = "fechaventa")
    private Date fechaventa;
    @Column(name = "cantidad", length = 25, nullable = false)
    private int cantidad;
    @Column(name = "precio", length = 25, nullable = false)
    private BigDecimal precio;
    @Column(name = "total", length = 25, nullable = false)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "clientes_id")
    private ClientesModel clientesmodel;

    @ManyToOne
    @JoinColumn(name = "productos_id")
    private ProductosModel productos;
}
