package org.carlosramosdev.curso.springboot.products.services;

import org.carlosramosdev.curso.springboot.products.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
}
