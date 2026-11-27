package com.example.quick_commerce.catalogue.product;

import java.math.BigDecimal;
import java.util.Optional;

public record ProductRequest(String name, BigDecimal price, Integer stock, Long categoryId) { }
