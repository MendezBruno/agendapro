package com.agendapro.agendapro.product.infrastructure.repositories;

import com.agendapro.agendapro.product.infrastructure.entities.ProductEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByName(String name);
    List<ProductEntity> findByCategory(String category);
}
