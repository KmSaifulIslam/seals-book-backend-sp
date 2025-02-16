package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
