package com.agendapro.agendapro.product.application.usecases;

import java.util.List;

import com.agendapro.agendapro.product.domain.model.Product;
import com.agendapro.agendapro.product.domain.ports.in.CreateProductUseCase;
import com.agendapro.agendapro.product.domain.ports.out.ProductRepositoryPort;

public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public CreateProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepositoryPort.save(product);
    }

   @Override
    public List<Product> createAllProduct(List<Product> product) {
        return productRepositoryPort.createAllProduct(product);
    }
}
