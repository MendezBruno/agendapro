package com.agendapro.agendapro.product.application.usecases;

import com.agendapro.agendapro.product.domain.model.Product;
import com.agendapro.agendapro.product.domain.ports.in.RetrieveProductUseCase;
import com.agendapro.agendapro.product.domain.ports.out.ProductRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveProductUseCaseImpl implements RetrieveProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public RetrieveProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepositoryPort.findById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepositoryPort.findAll();
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepositoryPort.findByName(name);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepositoryPort.findByCategory(category);
    }

}
