package com.softmotion.logistics.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<Order> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> findByCustomerId(@PathVariable String customerId) {
        return service.findByCustomerId(customerId);
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        return ResponseEntity.ok(service.create(order));
    }

    @PutMapping("/{id}/confirm")
    public ResponseEntity<Order> confirm(@PathVariable String id) {
        return ResponseEntity.ok(service.confirm(id));
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Order> cancel(@PathVariable String id) {
        return ResponseEntity.ok(service.cancel(id));
    }
}