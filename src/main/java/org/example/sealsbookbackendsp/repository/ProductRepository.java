package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
    Product findById(long id);
}
