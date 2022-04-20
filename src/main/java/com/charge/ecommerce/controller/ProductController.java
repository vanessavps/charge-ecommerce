package com.charge.ecommerce.controller;

import com.charge.ecommerce.entity.Product;
import com.charge.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/admin/product")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product newProduct = productService.save(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/product/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/admin/product/{id}")
    public ResponseEntity<Product> update(@PathVariable Integer id, @RequestBody Product product) {
        Product updatedProduct = productService.update(id, product);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAll(@RequestParam(required = false) Integer page,
                                                @RequestParam(required = false) Integer elements) {
        List<Product> products = productService.findAll(page, elements);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id) {
        Product product = productService.findById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
