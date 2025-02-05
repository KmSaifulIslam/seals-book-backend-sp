package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Long> {
    List<Color> findByProductId(Long productId);
}
