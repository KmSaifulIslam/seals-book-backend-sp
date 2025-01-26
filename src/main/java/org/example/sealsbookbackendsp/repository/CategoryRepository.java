package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
