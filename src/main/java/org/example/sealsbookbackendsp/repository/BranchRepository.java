package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
