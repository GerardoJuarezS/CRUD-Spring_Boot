package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class ClientesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id", length = 25, columnDefinition = "serial")
    private Long id;
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;
    @Column(name = "apellidopaterno", length = 150)
    private String apellidopaterno;
    @Column(name = "apellidomaterno", length = 150)
    private String apellidomaterno;
    @Column(name = "direccion", length = 150)
    private String direccion;
    @Column(name = "telefono", length = 150)
    private String telefono;
    @Column(name = "correo", length = 150)
    private String correo;
    
}
