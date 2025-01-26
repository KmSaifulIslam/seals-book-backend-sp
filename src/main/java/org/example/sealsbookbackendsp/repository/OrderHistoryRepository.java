package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
}
