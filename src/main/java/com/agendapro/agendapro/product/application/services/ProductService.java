package com.agendapro.agendapro.product.application.services;

import java.util.List;
import java.util.Optional;

import com.agendapro.agendapro.product.domain.model.Product;
import com.agendapro.agendapro.product.domain.ports.in.CreateProductUseCase;
import com.agendapro.agendapro.product.domain.ports.in.DeleteProductUseCase;
import com.agendapro.agendapro.product.domain.ports.in.RetrieveProductUseCase;
import com.agendapro.agendapro.product.domain.ports.in.UpdateProductUseCase;

public class ProductService implements CreateProductUseCase, RetrieveProductUseCase, UpdateProductUseCase, DeleteProductUseCase  {

    private final CreateProductUseCase createProductUseCase;
    private final RetrieveProductUseCase retrieveProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;


    public ProductService(CreateProductUseCase createProductUseCase, RetrieveProductUseCase retrieveProductUseCase,
                       UpdateProductUseCase updateProductUseCase, DeleteProductUseCase deleteProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.retrieveProductUseCase = retrieveProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
    }

    @Override
    public Product createProduct(Product product) {
        return createProductUseCase.createProduct(product);
    }

    @Override
    public List<Product> createAllProduct(List<Product> product) {
        return createProductUseCase.createAllProduct(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return retrieveProductUseCase.getProductById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return retrieveProductUseCase.getAllProducts();
    }

    @Override
    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        return updateProductUseCase.updateProduct(id, updatedProduct);
    }

    @Override
    public boolean deleteProduct(Long id) {
        return deleteProductUseCase.deleteProduct(id);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return retrieveProductUseCase.getProductsByName(name);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return retrieveProductUseCase.getProductsByCategory(category);

    }

}
