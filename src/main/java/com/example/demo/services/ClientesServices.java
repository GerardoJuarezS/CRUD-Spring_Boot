package com.example.demo.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.*;
import com.example.demo.repositories.*;

@Service
public class ClientesServices {
    @Autowired
    ClientesRepository clientesRepository;

    public List<ClientesModel> obtenerClientes() {
        return (ArrayList<ClientesModel>) clientesRepository.findAll();
    }

    public ClientesModel guardaClientes(ClientesModel clientes) {
        return clientesRepository.save(clientes);
    }

    public List<ClientesModel> obtenerPorNombre(String nombre) {
        return clientesRepository.findByNombre(nombre);
    }

    public List<ClientesModel> obtenerPorApellidoPaterno(String apellidopaterno) {
       return clientesRepository.findByApellidopaterno(apellidopaterno);
    }
    
    public boolean eliminarCliente(Long id) {
        try {
            clientesRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
