package com.murli.product.controller;

import com.murli.product.model.Product;
import com.murli.product.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping
  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    Product newProduct = productService.createProduct(product);
    return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
  }

  @GetMapping("/{productId}")
  public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId) {
    Product product = productService.getProductById(productId);
    return ResponseEntity.ok(product);
  }

  @GetMapping
  public ResponseEntity<List<Product>> getAllProducts() {
    List<Product> products = productService.getAllProducts();
    return ResponseEntity.ok(products);
  }

  @PutMapping("/{productId}")
  public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long productId,
      @RequestBody Product product) {
    Product updatedProduct = productService.updateProduct(productId, product);
    return ResponseEntity.ok(updatedProduct);
  }

  @DeleteMapping("/{productId}")
  public ResponseEntity<Void> deleteProduct(@PathVariable("orderId") Long productId) {
    productService.deleteProduct(productId);
    return ResponseEntity.noContent().build();
  }

}
