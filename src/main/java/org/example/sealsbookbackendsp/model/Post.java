package org.example.sealsbookbackendsp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String title;
    private String bannerUrl;
    private String promoVideoUrl;
    private String productId;
    private String natureOfDiscount;
    private String natureOfDiscountType;
    private String discountDetails;
    private String facebookBoostingDetails;
    private Timestamp createAt;
    private Timestamp updatedAt;
}
