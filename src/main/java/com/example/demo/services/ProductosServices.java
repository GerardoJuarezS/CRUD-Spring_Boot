package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.ProductosModel;
import com.example.demo.repositories.ProductosRepository;

@Service
public class ProductosServices {
	@Autowired
    ProductosRepository productosRepository;

    public List<ProductosModel> obtenerProductos() {
        return (List<ProductosModel>) productosRepository.findAll();
    }

    public ProductosModel guardaProductos(ProductosModel productos) {
        return productosRepository.save(productos);
    }

    public List<ProductosModel> obtenerPorNombre(String nombre) {
        return productosRepository.findByNombre(nombre);
    }

    public List<ProductosModel> obtenerPorStock(String stock) {
       return productosRepository.findByStock(stock);
    }
    public boolean eliminarProducto(Long id) {
        try {
            productosRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
