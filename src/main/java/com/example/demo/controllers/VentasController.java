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

import com.example.demo.models.VentasModel;
import com.example.demo.services.VentasServices;

@RestController
@RequestMapping("/ventas")
public class VentasController {

	@Autowired
	VentasServices ventasServices;
	
	@GetMapping()
	public List<VentasModel> obtenerVentas(){
		return ventasServices.obtenerVentas();
	}
	
	@PostMapping()
	public VentasModel guardarVentas(@RequestBody VentasModel ventas) {
		return this.ventasServices.guardarVentas(ventas);
	}
		
	@DeleteMapping (path ="/{id}")
	public String eliminarPorId(@PathVariable ("id") Long id) {
		boolean ok = this.ventasServices.eliminarVenta(id);
		if (ok) {
			return "Se elimino la venta con id" + id;
		}else {
			return "no se elimino el usuario con id" + id;
		}
	}
}
