package com.softmotion.logistics.inventory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<InventoryItem> findAll() {
        return service.findAll();
    }

    @GetMapping("/{sku}")
    public ResponseEntity<InventoryItem> findBySku(@PathVariable String sku) {
        return ResponseEntity.ok(service.findBySku(sku));
    }

    @PostMapping
    public ResponseEntity<InventoryItem> create(@RequestBody InventoryItem item) {
        return ResponseEntity.ok(service.save(item));
    }

    @PostMapping("/{sku}/reserve")
    public ResponseEntity<InventoryItem> reserve(
            @PathVariable String sku,
            @RequestParam int quantity) {
        return ResponseEntity.ok(service.reserve(sku, quantity));
    }
}