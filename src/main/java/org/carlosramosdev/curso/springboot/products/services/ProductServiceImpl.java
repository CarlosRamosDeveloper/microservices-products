package org.carlosramosdev.curso.springboot.products.services;

import org.carlosramosdev.curso.springboot.products.entities.Product;
import org.carlosramosdev.curso.springboot.products.repositories.IProductRepository;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService{

    final private IProductRepository repository;
    final private Environment env;

    public ProductServiceImpl(IProductRepository repository, Environment env) {
        this.repository = repository;
        this.env = env;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return ((List<Product>)repository.findAll()).stream().map(product -> {
                    product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
                    return product;
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return this.repository.save(product);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
