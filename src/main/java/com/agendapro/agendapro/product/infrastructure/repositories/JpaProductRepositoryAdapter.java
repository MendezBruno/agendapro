package com.agendapro.agendapro.product.infrastructure.repositories;

import com.agendapro.agendapro.shared.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agendapro.agendapro.product.domain.model.Product;
import com.agendapro.agendapro.product.domain.ports.out.ProductRepositoryPort;
import com.agendapro.agendapro.product.infrastructure.entities.ProductEntity;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaProductRepositoryAdapter implements ProductRepositoryPort {

    private final JpaProductRepository jpaProductRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public JpaProductRepositoryAdapter(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = ProductEntity.fromDomainModel(product);
        ProductEntity savedProductEntity = jpaProductRepository.save(productEntity);
        Product createdProduct = savedProductEntity.toDomainModel();
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "product.created", createdProduct);
        return createdProduct;
    }

    @Override
    public List<Product> createAllProduct(List<Product> product) {
        List<ProductEntity> productEntities = product.stream()
                .map(ProductEntity::fromDomainModel)
                .collect(Collectors.toList());
        List<ProductEntity> savedProductEntities = jpaProductRepository.saveAll(productEntities);
        return savedProductEntities.stream()
                .map(ProductEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaProductRepository.findById(id).map(ProductEntity::toDomainModel);
    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll().stream()
                .map(ProductEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> update(Long id, Product product) {
        if (jpaProductRepository.existsById(id)) {
            ProductEntity productEntity = ProductEntity.fromDomainModel(product);
            productEntity.setId(id);
            ProductEntity updatedProductEntity = jpaProductRepository.save(productEntity);
            return Optional.of(updatedProductEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaProductRepository.existsById(id)) {
            jpaProductRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> findByName(String name) {
        return jpaProductRepository.findByName(name).stream()
                .map(ProductEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByCategory(String category) {
        return jpaProductRepository.findByCategory(category).stream()
                .map(ProductEntity::toDomainModel)
                .collect(Collectors.toList());
    }
}
