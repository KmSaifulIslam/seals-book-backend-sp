package org.example.sealsbookbackendsp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    // Ensure that Lombok generates this, but add manually in case of issues
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void updateTotalPrice() {
        this.totalPrice = (unitPrice != null && quantity != null)
                ? unitPrice.multiply(BigDecimal.valueOf(quantity))
                : BigDecimal.ZERO;
    }
}
