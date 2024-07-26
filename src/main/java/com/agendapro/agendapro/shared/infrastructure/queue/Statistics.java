package com.agendapro.agendapro.shared.infrastructure.queue;

import com.agendapro.agendapro.product.domain.model.Product;

import java.util.Map;
import java.util.HashMap;


public class Statistics {

    private Map<String, Integer> categoryProductCount = new HashMap<>();

    public void update(Product product) {
        String category = product.getCategory();
        categoryProductCount.put(category, categoryProductCount.getOrDefault(category, 0) + 1);
    }

    public Map<String, Integer> getCategoryProductCount() {
        return categoryProductCount;
    }
}