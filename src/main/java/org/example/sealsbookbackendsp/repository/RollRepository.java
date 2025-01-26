package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.Roll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RollRepository extends JpaRepository<Roll, Integer> {
//    String findById(Integer rollId);
}
