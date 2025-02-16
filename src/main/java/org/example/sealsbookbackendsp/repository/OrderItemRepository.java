package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
