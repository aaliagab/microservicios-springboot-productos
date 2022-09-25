package com.ms.springboot.app.productos.services;

import java.util.List;

import com.ms.springboot.app.productos.models.entities.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	public Producto getById(Long id);
	public Producto save(Producto producto);
	public void delete(Long id);
}
