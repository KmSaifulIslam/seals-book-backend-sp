package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
