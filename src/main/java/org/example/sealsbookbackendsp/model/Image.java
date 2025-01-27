package org.example.sealsbookbackendsp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] image;  // Use byte[] instead of Blob for better JPA compatibility

    private String downloadUrl;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product; // Assuming you have a Product entity with the necessary mapping
}
