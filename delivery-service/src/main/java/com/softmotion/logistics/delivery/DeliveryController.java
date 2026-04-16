package com.softmotion.logistics.delivery;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/deliveries")
public class DeliveryController {

    private final DeliveryService service;

    public DeliveryController(DeliveryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Delivery> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<Delivery> findByOrderId(@PathVariable String orderId) {
        return ResponseEntity.ok(service.findByOrderId(orderId));
    }

    @PostMapping
    public ResponseEntity<Delivery> create(@RequestBody Delivery delivery) {
        return ResponseEntity.ok(service.create(delivery));
    }

    @PutMapping("/{id}/transit")
    public ResponseEntity<Delivery> startTransit(@PathVariable String id) {
        return ResponseEntity.ok(service.startTransit(id));
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Delivery> complete(@PathVariable String id) {
        return ResponseEntity.ok(service.complete(id));
    }

    @PutMapping("/{id}/fail")
    public ResponseEntity<Delivery> fail(@PathVariable String id) {
        return ResponseEntity.ok(service.fail(id));
    }
}