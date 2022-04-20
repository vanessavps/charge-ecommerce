package com.charge.ecommerce.service;

import com.charge.ecommerce.entity.Product;
import com.charge.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends CrudService<Product> {
    @Autowired
    public ProductService(ProductRepository productRepository) {
        super(productRepository);
    }
}
