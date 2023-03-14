package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.ClientesModel;
import com.example.demo.services.ClientesServices;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> manejarException(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
				body("Error de validacion" + e.getMessage());
	}
	
    @Autowired
    ClientesServices clientesServices;

    @GetMapping()
    public List<ClientesModel> obtenerClientes() {
        return clientesServices.obtenerClientes();
    }

    @PostMapping()
    public ClientesModel guardarClientes(@RequestBody ClientesModel clientes) {
        return this.clientesServices.guardaClientes(clientes);
    }

    @GetMapping(path = "/{nombre}")
    public List<ClientesModel> obtenerClientesPorId(@PathVariable("nombre") String nombre) {
        return this.clientesServices.obtenerPorNombre(nombre);
    }

    @GetMapping("/query/{apellidopaterno}")
    public List<ClientesModel> obtenerClientesPorApellidoPaterno(@PathVariable ("apellidopaterno") String apellidopaterno) {
        return this.clientesServices.obtenerPorApellidoPaterno(apellidopaterno);
    }

    @DeleteMapping (path = "/{id}")
    public String eliminarPorId(@PathVariable("id") long id) {
        boolean ok = this.clientesServices.eliminarCliente(id);
        if (ok) {
            return "se elimino el usuario con id" + id;
        } else {
            return "no se puedo eliminar el usuario con id" + id;
        }
    }

}
