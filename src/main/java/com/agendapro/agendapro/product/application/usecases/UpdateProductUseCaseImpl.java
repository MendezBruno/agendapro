package com.agendapro.agendapro.product.application.usecases;

import com.agendapro.agendapro.product.domain.model.Product;
import com.agendapro.agendapro.product.domain.ports.in.UpdateProductUseCase;
import com.agendapro.agendapro.product.domain.ports.out.ProductRepositoryPort;

import java.util.Optional;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public UpdateProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        return productRepositoryPort.update(id, updatedProduct);
    }
}
