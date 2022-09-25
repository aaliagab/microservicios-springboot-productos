package com.ms.springboot.app.productos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.springboot.app.productos.models.entities.Producto;
import com.ms.springboot.app.productos.models.repositories.IProductoRepository;

@Service
public class ProductoService implements IProductoService{
	@Autowired
	IProductoRepository productoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		// TODO Auto-generated method 
		return (List<Producto>)productoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto getById(Long id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return productoRepository.save(producto);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(id);
	}
}
