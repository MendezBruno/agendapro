package com.agendapro.agendapro.product.domain.ports.in;

import com.agendapro.agendapro.product.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface RetrieveProductUseCase {
    Optional<Product> getProductById(Long id);
    List<Product> getAllProducts();
    List<Product> getProductsByName(String wheaterCondition);
    List<Product> getProductsByCategory(String category);

}
