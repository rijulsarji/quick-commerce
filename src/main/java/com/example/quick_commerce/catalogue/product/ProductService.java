package com.example.quick_commerce.catalogue.product;

import com.example.quick_commerce.catalogue.category.Category;
import com.example.quick_commerce.catalogue.category.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryReposity) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryReposity;
    }

    public ProductResponse findProductById(Long id) {
        Product p = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product " + id + "was not found"));

        return ProductResponse.from(p);
    }

    public ProductResponse create(ProductRequest req) {
        Category c = categoryRepository.findById(req.categoryId()).orElseThrow(() -> new IllegalArgumentException("Category" + req.categoryId() + "was not found"));

        Product p = new Product();
        p.setName(req.name());
        p.setPrice(req.price());
        p.setStock(req.stock());
        p.setCategory(c);

        return ProductResponse.from(productRepository.save(p));
    }

    public ProductResponse update(ProductRequest req, Long id) {
        boolean isValid = productRepository.existsById(id);

        if(!isValid) {
            return null;
        }

        Category c = categoryRepository.findById(req.categoryId()).orElseThrow(() -> new IllegalArgumentException("Category" + req.categoryId() + "was not found"));

        Product p = new Product();

        p.setId(id);
        p.setName(req.name());
        p.setPrice(req.price());
        p.setStock(req.stock());
        p.setCategory(c);

        return ProductResponse.from(productRepository.save(p));
    }

    public boolean deleteProductById(Long id) {
        boolean isValid = productRepository.existsById(id);

        if(!isValid) {
            return false;
        } else {
            productRepository.deleteById(id);
            return true;
        }
    }
}
