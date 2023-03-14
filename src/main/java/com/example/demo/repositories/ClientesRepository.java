package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.ClientesModel;

public interface ClientesRepository extends CrudRepository<ClientesModel, Long> {
    public  List<ClientesModel> findByNombre(String nombre);
    public  List<ClientesModel> findByApellidopaterno(String apellidopaterno);

}
