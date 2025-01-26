package org.example.sealsbookbackendsp.repository;

import org.example.sealsbookbackendsp.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
