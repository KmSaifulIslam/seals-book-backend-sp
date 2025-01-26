package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
