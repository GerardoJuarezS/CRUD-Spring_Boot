package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.example.demo.models.ProductosModel;


public interface ProductosRepository extends CrudRepository<ProductosModel, Long> {
    public List<ProductosModel> findByNombre(String nombre);

    public List<ProductosModel> findByStock(String stock);

    public List<ProductosModel> findByPrecio(String precio);

    public List<ProductosModel> findByCategoria(String categoria);

}