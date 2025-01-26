package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.Bio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BioRepository extends JpaRepository<Bio, Long> {
}
