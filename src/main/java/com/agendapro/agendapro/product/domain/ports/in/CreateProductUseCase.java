package com.agendapro.agendapro.product.domain.ports.in;

import java.util.List;

import com.agendapro.agendapro.product.domain.model.Product;

public interface CreateProductUseCase {
    Product createProduct(Product product);
    List<Product> createAllProduct(List<Product> product);
}
