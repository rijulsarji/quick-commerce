package com.example.quick_commerce.catalogue.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest req) {
        ProductResponse productResponse = productService.create(req);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productResponse.id()).toUri();

        return ResponseEntity.created(location).body(productResponse);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> findProductById(@PathVariable Long productId) {
        ProductResponse productResponse = productService.findProductById(productId);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);

    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long productId, @RequestBody ProductRequest req) {
        ProductResponse productResponse = productService.update(req, productId);

        if (productResponse != null) {
            return new ResponseEntity<>(productResponse, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{productId}")
    public ResponseEntity deleteProductById(@PathVariable Long productId) {
        boolean isProductDeleted = productService.deleteProductById(productId);

        if (isProductDeleted)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}