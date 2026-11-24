package com.example.quick_commerce.store;

import org.springframework.stereotype.Service;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public String greeting() {
        return "Welcome to " + storeRepository.getStoreName();
    }
}
