package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
