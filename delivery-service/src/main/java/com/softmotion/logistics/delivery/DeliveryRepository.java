package com.softmotion.logistics.delivery;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, String> {
    Optional<Delivery> findByOrderId(String orderId);
    List<Delivery> findByStatus(String status);
}