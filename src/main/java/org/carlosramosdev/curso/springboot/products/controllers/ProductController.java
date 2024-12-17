package org.carlosramosdev.curso.springboot.products.controllers;

import org.carlosramosdev.curso.springboot.products.entities.Product;
import org.carlosramosdev.curso.springboot.products.services.IProductService;
import org.carlosramosdev.curso.springboot.products.services.ProductServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
//TODO: Encontrar la forma de recuperar el request mapping manteniendo el LoadBalancer
//@RequestMapping("/api/products")
public class ProductController {
    final IProductService service;

    public ProductController(ProductServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> list(){
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Optional<Product> productOptional = service.findById(id);
        if(productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
