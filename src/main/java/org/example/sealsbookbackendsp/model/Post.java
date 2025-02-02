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
//@NoArgsConstructor
//@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private Long userId;
    private String title;
    private String bannerUrl;
    private String promoVideoUrl;

    private String productId;

    private String natureOfDiscount;
    private String natureOfDiscountType;
    private String discountDetails;
    private String facebookBoostingDetails;
    private Timestamp updateTime = new Timestamp(System.currentTimeMillis());
    private Timestamp createAt = new Timestamp(System.currentTimeMillis());

    public Post() {
    }

    public Post(Long postId, Long userId, String title, String bannerUrl, String promoVideoUrl, String productId, String natureOfDiscount, String natureOfDiscountType, String discountDetails, String facebookBoostingDetails, Timestamp updateTime, Timestamp createAt) {
        this.postId = postId;
        this.userId = userId;
        this.title = title;
        this.bannerUrl = bannerUrl;
        this.promoVideoUrl = promoVideoUrl;
        this.productId = productId;
        this.natureOfDiscount = natureOfDiscount;
        this.natureOfDiscountType = natureOfDiscountType;
        this.discountDetails = discountDetails;
        this.facebookBoostingDetails = facebookBoostingDetails;
        this.updateTime = updateTime;
        this.createAt = createAt;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getPromoVideoUrl() {
        return promoVideoUrl;
    }

    public void setPromoVideoUrl(String promoVideoUrl) {
        this.promoVideoUrl = promoVideoUrl;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getNatureOfDiscount() {
        return natureOfDiscount;
    }

    public void setNatureOfDiscount(String natureOfDiscount) {
        this.natureOfDiscount = natureOfDiscount;
    }

    public String getNatureOfDiscountType() {
        return natureOfDiscountType;
    }

    public void setNatureOfDiscountType(String natureOfDiscountType) {
        this.natureOfDiscountType = natureOfDiscountType;
    }

    public String getDiscountDetails() {
        return discountDetails;
    }

    public void setDiscountDetails(String discountDetails) {
        this.discountDetails = discountDetails;
    }

    public String getFacebookBoostingDetails() {
        return facebookBoostingDetails;
    }

    public void setFacebookBoostingDetails(String facebookBoostingDetails) {
        this.facebookBoostingDetails = facebookBoostingDetails;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }
}
