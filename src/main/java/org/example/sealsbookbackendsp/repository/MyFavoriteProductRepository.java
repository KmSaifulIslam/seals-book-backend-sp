package org.example.sealsbookbackendsp.repository;


import org.example.sealsbookbackendsp.model.MyFevaritProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyFavoriteProductRepository extends JpaRepository<MyFevaritProduct, Long> {
    Optional<MyFevaritProduct> findByUserIdAndProductId(Long userId, Long productId);
    List<MyFevaritProduct> findAllByUserId(Long userId);
}
