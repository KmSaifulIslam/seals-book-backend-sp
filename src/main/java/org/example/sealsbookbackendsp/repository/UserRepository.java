package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
//    User findByEmailAndPassword(String email, String password);
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findFirstByEmailAndPassword(String email, String password);
}
