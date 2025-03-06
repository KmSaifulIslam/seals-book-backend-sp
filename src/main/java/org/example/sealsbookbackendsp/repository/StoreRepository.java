package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findByStoreOwnerId(Long storeOwnerId);
}
