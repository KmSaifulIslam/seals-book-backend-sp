package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    User findByUsername(String phone);
//    User findByUsername(String phone, String password);
}
