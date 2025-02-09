package org.example.sealsbookbackendsp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandingCost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brandingType;
    private Integer cost;
    private Long createdUserId;

    private java.sql.Timestamp updatedAt = new java.sql.Timestamp(System.currentTimeMillis());
    private java.sql.Timestamp createdAt = new java.sql.Timestamp(System.currentTimeMillis());

    // One to Many (BrandingRequest)
}
