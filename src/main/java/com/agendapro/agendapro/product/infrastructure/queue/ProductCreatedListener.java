package com.agendapro.agendapro.product.infrastructure.queue;

import com.agendapro.agendapro.product.domain.model.Product;
import com.agendapro.agendapro.shared.config.RabbitMQConfig;
import com.agendapro.agendapro.shared.infrastructure.queue.Statistics;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductCreatedListener {

    private final Statistics statistics = new Statistics();

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void handleProductCreated(Product product) {
        // Lógica para actualizar las estadísticas
        // Ejemplo: actualizar la cantidad de productos en una categoría
        statistics.update(product);
    }

    public Statistics getStatistics() {
        return statistics;
    }
}
