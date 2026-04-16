package com.softmotion.logistics.delivery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class DeliveryService {

    private final DeliveryRepository repository;

    public DeliveryService(DeliveryRepository repository) {
        this.repository = repository;
    }

    public List<Delivery> findAll() {
        return repository.findAll();
    }

    public Delivery findById(String id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Delivery not found: " + id));
    }

    public Delivery findByOrderId(String orderId) {
        return repository.findByOrderId(orderId)
            .orElseThrow(() -> new RuntimeException("Delivery not found for order: " + orderId));
    }

    public Delivery create(Delivery delivery) {
        return repository.save(delivery);
    }

    public Delivery startTransit(String id) {
        Delivery delivery = findById(id);
        delivery.setStatus("IN_TRANSIT");
        return repository.save(delivery);
    }

    public Delivery complete(String id) {
        Delivery delivery = findById(id);
        delivery.setStatus("DELIVERED");
        delivery.setDeliveredAt(LocalDateTime.now());
        return repository.save(delivery);
    }

    public Delivery fail(String id) {
        Delivery delivery = findById(id);
        delivery.setStatus("FAILED");
        return repository.save(delivery);
    }
}