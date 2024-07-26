package com.agendapro.agendapro.product.domain.ports.in;

import com.agendapro.agendapro.product.domain.model.Product;

import java.util.Optional;

public interface UpdateProductUseCase {
    Optional<Product> updateProduct(Long id, Product updatedProduct);
}
