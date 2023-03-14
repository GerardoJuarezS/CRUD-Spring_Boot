package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ProductosModel;
import com.example.demo.services.ProductosServices;

@RestController
@RequestMapping("/productos")
public class ProductosController {
	 @Autowired
	    ProductosServices productosServices;

	    @GetMapping()
	    public List<ProductosModel> obtenerProdutos() {
	        return productosServices.obtenerProductos();
	    }

	    @PostMapping()
	    public ProductosModel guardarProducto(@RequestBody ProductosModel productos) {
	        return this.productosServices.guardaProductos(productos);
	    }

	    @GetMapping(path = "/{nombre}")
	    public List<ProductosModel> obtenerProductosPorNombre(@PathVariable("nombre") String nombre) {
	        return this.productosServices.obtenerPorNombre(nombre);
	    }

	    @GetMapping("/query/{stock}")
	    public List<ProductosModel> obtenerProductosPorStock(@PathVariable ("stock") String stock) {
	        return this.productosServices.obtenerPorStock(stock);
	    }

	    @DeleteMapping (path = "/{id}")
	    public String eliminarPorId(@PathVariable("id") long id) {
	        boolean ok = this.productosServices.eliminarProducto(id);
	        if (ok) {
	            return "se elimino el producto con id" + id;
	        } else {
	            return "no se puedo eliminar el producto con id" + id;
	        }
	    }

}
