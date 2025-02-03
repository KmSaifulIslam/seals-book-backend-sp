package org.example.sealsbookbackendsp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandingRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long boostId;
    private Boolean banner;

    //Many to One
    private Long brandingCostId;
    private Boolean promotion_video;
    private String paintingDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBoostId() {
        return boostId;
    }

    public void setBoostId(Long boostId) {
        this.boostId = boostId;
    }

    public Boolean getBanner() {
        return banner;
    }

    public void setBanner(Boolean banner) {
        this.banner = banner;
    }

    public Long getBrandingCostId() {
        return brandingCostId;
    }

    public void setBrandingCostId(Long brandingCostId) {
        this.brandingCostId = brandingCostId;
    }

    public Boolean getPromotion_video() {
        return promotion_video;
    }

    public void setPromotion_video(Boolean promotion_video) {
        this.promotion_video = promotion_video;
    }

    public String getPaintingDetails() {
        return paintingDetails;
    }

    public void setPaintingDetails(String paintingDetails) {
        this.paintingDetails = paintingDetails;
    }
}
