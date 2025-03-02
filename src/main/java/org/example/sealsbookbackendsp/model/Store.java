package org.example.sealsbookbackendsp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "store")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    private String storeName;
    private String storeDescription;
    private String storeEmail;
    private String storePhoneNumber;
    private String storeAddress;
    private String city;
    private String state;
    private String country;
    private String storeLogo;
    private String bannerUrl;
    private String openingHours;
    private String storeStatus;
    private String storeType;
    private String storeCategory;
    private String facebookPageLink;
    private String websiteUrl;
    private String whatsappNumber;

    private String storeOwnerType;
    private Long storeOwnerId;

//    @ManyToOne
//    @JoinColumn(name = "seller_id", nullable = true)
//    private User storeOwner;
}