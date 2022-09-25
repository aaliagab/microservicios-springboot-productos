package com.ms.springboot.app.productos.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ms.springboot.app.productos.models.entities.Producto;

@Repository
public interface IProductoRepository extends CrudRepository<Producto, Long>{

}
