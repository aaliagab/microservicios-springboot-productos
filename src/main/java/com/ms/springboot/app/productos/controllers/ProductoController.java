package com.ms.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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
	private Environment ambiente;
	
	@Value("${server.port}")
	private Integer port;

	@Autowired
	IProductoService productoService;
	
	@GetMapping({"/","list"})
	public List<Producto> listadoProducto(){
		return productoService.findAll().stream().map(p->{
			//p.setPort(Integer.parseInt(ambiente.getProperty("local.server.port")));
			p.setPort(port);
			return p;
		}).collect(Collectors.toList());
	}
	
	@GetMapping({"/{id}"})
	public Producto obtenerProducto(@PathVariable Long id){
		Producto p = productoService.getById(id);
		//p.setPort(Integer.parseInt(ambiente.getProperty("local.server.port")));
		p.setPort(port);
		return p;
	}
	
	@PostMapping("/")
	public Producto guardarProducto(@RequestBody Producto producto) {
		Producto p = productoService.save(producto);
		//p.setPort(Integer.parseInt(ambiente.getProperty("local.server.port")));
		p.setPort(port);
		return p;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarProducto(@PathVariable Long id) {
		productoService.delete(id);
	}
}
