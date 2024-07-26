package com.agendapro.agendapro.shared.infrastructure.controllers;

import com.agendapro.agendapro.product.infrastructure.queue.ProductCreatedListener;
import com.agendapro.agendapro.shared.infrastructure.queue.Statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    @Autowired
    private ProductCreatedListener productCreatedListener;

    @GetMapping
    public Statistics getStatistics() {
        return productCreatedListener.getStatistics();
    }
}

