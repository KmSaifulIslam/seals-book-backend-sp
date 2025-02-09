package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {
    List<Size> findByProductId(Long productId);
}
