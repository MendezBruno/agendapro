package com.agendapro.agendapro.product.infrastructure.controllers;

import com.agendapro.agendapro.product.application.services.ProductService;
import com.agendapro.agendapro.product.domain.model.Product;
import com.agendapro.agendapro.product.infrastructure.exception.ProductNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateProduct() {
        Product product = new Product();
        when(productService.createProduct(any(Product.class))).thenReturn(product);

        ResponseEntity<Product> response = productController.createProduct(product);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(product, response.getBody());
        verify(productService, times(1)).createProduct(product);
    }

    @Test
    public void testGetProductById() {
        Product product = new Product();
        when(productService.getProductById(anyLong())).thenReturn(Optional.of(product));

        ResponseEntity<Product> response = productController.getProductById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
        verify(productService, times(1)).getProductById(1L);
    }

    @Test
    public void testGetProductById_NotFound() {
        when(productService.getProductById(anyLong())).thenThrow(new ProductNotFoundException("Product with ID 1 not found"));

        try {
            productController.getProductById(1L);
        } catch (ProductNotFoundException ex) {
            assertEquals("Product with ID 1 not found", ex.getMessage());
        }

        verify(productService, times(1)).getProductById(1L);
    }

    @Test
    public void testGetAllProducts() {
        Product product1 = new Product();
        Product product2 = new Product();
        List<Product> products = Arrays.asList(product1, product2);
        when(productService.getAllProducts()).thenReturn(products);

        ResponseEntity<List<Product>> response = productController.getAllProducts();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(products, response.getBody());
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        when(productService.updateProduct(anyLong(), any(Product.class))).thenReturn(Optional.of(product));

        ResponseEntity<Product> response = productController.updateProduct(1L, product);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
        verify(productService, times(1)).updateProduct(1L, product);
    }

    @Test
    public void testUpdateProduct_NotFound() {
        when(productService.updateProduct(anyLong(), any(Product.class))).thenThrow(new ProductNotFoundException("Product with ID 1 not found"));

        Product product = new Product();
        try {
            productController.updateProduct(1L, product);
        } catch (ProductNotFoundException ex) {
            assertEquals("Product with ID 1 not found", ex.getMessage());
        }

        verify(productService, times(1)).updateProduct(1L, product);
    }

    @Test
    public void testDeleteProductById() {
        when(productService.deleteProduct(anyLong())).thenReturn(true);

        ResponseEntity<Void> response = productController.deleteProductById(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(productService, times(1)).deleteProduct(1L);
    }

    @Test
    public void testDeleteProductById_NotFound() {
        when(productService.deleteProduct(anyLong())).thenThrow(new ProductNotFoundException("Product with ID 1 not found"));

        try {
            productController.deleteProductById(1L);
        } catch (ProductNotFoundException ex) {
            assertEquals("Product with ID 1 not found", ex.getMessage());
        }

        verify(productService, times(1)).deleteProduct(1L);
    }

    @Test
    public void testGetProductsByName() {
        Product product1 = new Product();
        Product product2 = new Product();
        List<Product> products = Arrays.asList(product1, product2);
        when(productService.getProductsByName(anyString())).thenReturn(products);

        ResponseEntity<List<Product>> response = productController.getProductsByName("test");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(products, response.getBody());
        verify(productService, times(1)).getProductsByName("test");
    }

    @Test
    public void testGetProductsByCategory() {
        Product product1 = new Product();
        Product product2 = new Product();
        List<Product> products = Arrays.asList(product1, product2);
        when(productService.getProductsByCategory(anyString())).thenReturn(products);

        ResponseEntity<List<Product>> response = productController.getProductsByCategory("category");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(products, response.getBody());
        verify(productService, times(1)).getProductsByCategory("category");
    }
}
