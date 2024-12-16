package org.carlosramosdev.curso.springboot.products.repositories;

import org.carlosramosdev.curso.springboot.products.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product, Long> {

}
