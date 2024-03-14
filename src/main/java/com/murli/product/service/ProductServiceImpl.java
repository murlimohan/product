package com.murli.product.service;

import com.murli.product.model.Product;
import com.murli.product.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;


  @Override
  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Product getProductById(Long productId) {
    return productRepository.findById(productId)
        .orElseThrow(() -> new RuntimeException("Product not found with id : " + productId));
  }

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product updateProduct(Long productId, Product product) {
    Product existingProduct = getProductById(productId);
    existingProduct.setName(product.getName());
    existingProduct.setPrice(product.getPrice());
    return productRepository.save(existingProduct);
  }

  @Override
  public void deleteProduct(Long productId) {
    Product existingProduct = getProductById(productId);
    productRepository.delete(existingProduct);
  }
}
