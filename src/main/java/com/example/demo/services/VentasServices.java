package com.example.demo.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.VentasModel;
import com.example.demo.repositories.VentasRepository;

@Service
public class VentasServices {
	@Autowired
	VentasRepository ventasRepository;
	
	public List<VentasModel> obtenerVentas() {
		return (List<VentasModel>)
				ventasRepository.findAll();
	}
	
	public VentasModel guardarVentas(VentasModel ventas) {
		return ventasRepository.save(ventas);
	}

	public List<VentasModel> obtenerPorCantidad(int cantidad) {
		return (List<VentasModel>)
				ventasRepository.findByCantidad(cantidad);
	}

	public List<VentasModel> obtenerPorFechaVenta(Date fechaventa) {
		return (List<VentasModel>)
				ventasRepository.findByFechaventa(fechaventa);
	}
	
	public boolean eliminarVenta(Long id) {
		try {
			ventasRepository.deleteById(id);
			return true;
		} catch (Exception error) {
			return false;
		}
	}

}
