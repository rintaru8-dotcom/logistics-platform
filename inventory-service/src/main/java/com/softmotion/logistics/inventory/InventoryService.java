package com.softmotion.logistics.inventory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public List<InventoryItem> findAll() {
        return repository.findAll();
    }

    public InventoryItem findBySku(String sku) {
        return repository.findBySku(sku)
            .orElseThrow(() -> new RuntimeException("SKU not found: " + sku));
    }

    public InventoryItem save(InventoryItem item) {
        return repository.save(item);
    }

    public InventoryItem reserve(String sku, int quantity) {
        InventoryItem item = findBySku(sku);
        if (item.getQuantity() < quantity) {
            throw new RuntimeException("在庫不足: " + sku);
        }
        item.setQuantity(item.getQuantity() - quantity);
        return repository.save(item);
    }
}