package org.carlosramosdev.curso.springboot.products.services;

import org.carlosramosdev.curso.springboot.products.entities.Product;
import org.carlosramosdev.curso.springboot.products.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{

    final private IProductRepository repository;

    public ProductServiceImpl(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>)repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
}
