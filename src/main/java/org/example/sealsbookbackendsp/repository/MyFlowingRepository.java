package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.MyFlowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyFlowingRepository extends JpaRepository<MyFlowing, Long> {
    Optional<MyFlowing> findByUserIdAndStoreId(Long userId, Long storeId);
    List<MyFlowing> findAllByUserId(Long userId);
}
