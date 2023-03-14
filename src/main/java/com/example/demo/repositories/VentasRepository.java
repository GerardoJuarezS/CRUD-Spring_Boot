package com.example.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.VentasModel;

@Repository
public interface VentasRepository extends CrudRepository<VentasModel, Long> {

	public List<VentasModel> findByFechaventa(Date fechaVenta);

	public List<VentasModel> findByCantidad(int cantidad);

}
