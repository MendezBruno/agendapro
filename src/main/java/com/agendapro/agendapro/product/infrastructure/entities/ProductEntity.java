package com.agendapro.agendapro.product.infrastructure.entities;

import com.agendapro.agendapro.product.domain.model.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="products")  // Nombre de la tabla en la base de datos
public class ProductEntity {


    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id
    @GeneratedValue Long id;
    private String name;
    private String category;
    private Integer stock;
    private double price;
    private String description;


    public ProductEntity() {
    }

    

    public ProductEntity(Long id, String name, String category,  Integer stock, double price, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.price = price;
        this.description = description;
    }

    public static ProductEntity fromDomainModel(Product product) {
        return new ProductEntity(product.getId(), product.getName(), product.getCategory(), product.getStock(), product.getPrice(), product.getDescription());
    }

    public Product toDomainModel() {
        return new Product(id, name, category, stock, price, description);
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
