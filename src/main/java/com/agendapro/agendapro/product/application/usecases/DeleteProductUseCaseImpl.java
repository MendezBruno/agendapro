package com.agendapro.agendapro.product.application.usecases;

import com.agendapro.agendapro.product.domain.ports.in.DeleteProductUseCase;
import com.agendapro.agendapro.product.domain.ports.out.ProductRepositoryPort;

public class DeleteProductUseCaseImpl implements DeleteProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public DeleteProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return productRepositoryPort.deleteById(id);
    }
}
