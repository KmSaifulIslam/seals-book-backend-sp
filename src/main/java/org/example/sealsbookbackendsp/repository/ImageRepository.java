package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}

