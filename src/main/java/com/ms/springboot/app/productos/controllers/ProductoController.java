package com.ms.springboot.app.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.springboot.app.productos.models.entities.Producto;
import com.ms.springboot.app.productos.services.IProductoService;

@RestController
@RequestMapping("/microservicio/productos")
public class ProductoController {

	@Autowired
	IProductoService productoService;
	
	@GetMapping({"/","list"})
	public List<Producto> listadoProducto(){
		return productoService.findAll();
	}
	
	@GetMapping({"/{id}"})
	public Producto obtenerProducto(@PathVariable Long id){
		return productoService.getById(id);
	}
	
	@PostMapping("/")
	public Producto guardarProducto(@RequestBody Producto producto) {
		return productoService.save(producto);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarProducto(@PathVariable Long id) {
		productoService.delete(id);
	}
}
