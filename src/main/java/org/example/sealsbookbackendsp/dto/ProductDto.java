package org.example.sealsbookbackendsp.dto;


import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.example.sealsbookbackendsp.model.Category;
import org.example.sealsbookbackendsp.model.User;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;
    private Category category;
//    private User user;
    private List<ImageDto> images;
}
