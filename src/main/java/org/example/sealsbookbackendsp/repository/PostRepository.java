package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
