package com.agendapro.agendapro.product.domain.ports.out;

import com.agendapro.agendapro.product.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {
    Product save(Product product);
    List<Product> createAllProduct(List<Product> product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    Optional<Product> update(Long id, Product product);
    boolean deleteById(Long id);
    List<Product> findByName(String name);
    List<Product> findByCategory(String category);
}
