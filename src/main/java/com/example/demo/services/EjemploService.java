package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.ProductosModel;
import com.example.demo.repositories.ProductosRepository;

@Service
public class EjemploService {
	@Autowired
	ProductosRepository productosRepository;
	public List<ProductosModel> findAll(){
		return (List<ProductosModel>) productosRepository.findAll();
		}
	}
