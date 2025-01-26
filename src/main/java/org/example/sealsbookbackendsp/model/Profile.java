package org.example.sealsbookbackendsp.model;

import jakarta.persistence.*;
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
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @OneToOne(mappedBy = "product")
    private String userName;

    private String userDesignation;
    private String phoneNumber;
    private String email;
    private String whatsAppNumber;
    private String facebookLink;
    private String presentAddress;
    private String permanentAddress;
    private String officePhoneNumber;
    private String officeAddress;
    private String bolodGroup;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
