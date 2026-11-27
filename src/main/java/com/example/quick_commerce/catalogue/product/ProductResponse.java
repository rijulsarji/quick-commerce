package com.example.quick_commerce.catalogue.product;

import java.math.BigDecimal;

public record ProductResponse(Long id, String name, BigDecimal price, Integer stock, Long categoryId) {
    static ProductResponse from(Product p) {
        return new ProductResponse(p.getId(), p.getName(), p.getPrice(), p.getStock(), p.getCategory().getId());
    }
}
