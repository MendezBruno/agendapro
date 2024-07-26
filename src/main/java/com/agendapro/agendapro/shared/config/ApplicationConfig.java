package com.agendapro.agendapro.shared.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.agendapro.agendapro.product.application.services.ProductService;
import com.agendapro.agendapro.product.application.usecases.CreateProductUseCaseImpl;
import com.agendapro.agendapro.product.application.usecases.DeleteProductUseCaseImpl;
import com.agendapro.agendapro.product.application.usecases.RetrieveProductUseCaseImpl;
import com.agendapro.agendapro.product.application.usecases.UpdateProductUseCaseImpl;
import com.agendapro.agendapro.product.domain.ports.out.ProductRepositoryPort;
import com.agendapro.agendapro.product.infrastructure.repositories.JpaProductRepositoryAdapter;

@Configuration
public class ApplicationConfig {

    @Bean
    public ProductRepositoryPort productRepositoryPort(JpaProductRepositoryAdapter jpaProductRepositoryAdapter) {
        return jpaProductRepositoryAdapter;
    }

    @Bean
    public ProductService productService(ProductRepositoryPort productRepositoryPort) {
        return new ProductService(
                new CreateProductUseCaseImpl(productRepositoryPort),
                new RetrieveProductUseCaseImpl(productRepositoryPort),
                new UpdateProductUseCaseImpl(productRepositoryPort),
                new DeleteProductUseCaseImpl(productRepositoryPort)
        );
    }




}
