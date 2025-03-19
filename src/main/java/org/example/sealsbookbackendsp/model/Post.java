package org.example.sealsbookbackendsp.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private Long storeId;
    private String title;
    private String bannerUrl;
    private String promoVideoUrl;

    @ElementCollection
    private List<Long> productsId;

    private String natureOfDiscount;
    private String natureOfDiscountType;
    private String discountDetails;
    private String facebookBoostingDetails;

    @UpdateTimestamp
    private Timestamp updateTime;

    @CreationTimestamp
    private Timestamp createAt;

    public Post() {
    }

    public Post(Long storeId, String title, String bannerUrl, String promoVideoUrl, List<Long> productsId,
                String natureOfDiscount, String natureOfDiscountType, String discountDetails, String facebookBoostingDetails) {
        this.storeId = storeId;
        this.title = title;
        this.bannerUrl = bannerUrl;
        this.promoVideoUrl = promoVideoUrl;
        this.productsId = productsId;
        this.natureOfDiscount = natureOfDiscount;
        this.natureOfDiscountType = natureOfDiscountType;
        this.discountDetails = discountDetails;
        this.facebookBoostingDetails = facebookBoostingDetails;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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

    public List<Long> getProductsId() {
        return productsId;
    }

    public void setProductsId(List<Long> productsId) {
        this.productsId = productsId;
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
