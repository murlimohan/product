package com.murli.product.service;

import com.murli.product.model.Product;

public interface ProductService {

  Product createProduct(Product product);

  Product getProductById(Long productId);

}
