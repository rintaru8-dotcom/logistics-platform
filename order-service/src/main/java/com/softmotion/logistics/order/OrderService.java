package com.softmotion.logistics.order;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(String id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found: " + id));
    }

    public List<Order> findByCustomerId(String customerId) {
        return repository.findByCustomerId(customerId);
    }

    public Order create(Order order) {
        return repository.save(order);
    }

    public Order confirm(String id) {
        Order order = findById(id);
        order.setStatus("CONFIRMED");
        return repository.save(order);
    }

    public Order cancel(String id) {
        Order order = findById(id);
        order.setStatus("CANCELLED");
        return repository.save(order);
    }
}