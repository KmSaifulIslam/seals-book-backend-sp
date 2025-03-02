package org.example.sealsbookbackendsp.model;

import jakarta.persistence.*;
import org.example.sealsbookbackendsp.enums.Role;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    private String email;
    private String phone;
    private String role;  // Change role to an enum
    private String imageUrl;
    private String token;

    private Timestamp updateTime = new Timestamp(System.currentTimeMillis());
    private Timestamp createAt = new Timestamp(System.currentTimeMillis());

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;


//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Product> Product;


    public User() {
    }

//    public User(Long id, String name, String password, String email, String phone, String role, String imageUrl, String token, Timestamp updateTime, Timestamp createAt) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//        this.email = email;
//        this.phone = phone;
//        this.role = role;
//        this.imageUrl = imageUrl;
//        this.token = token;
//        this.updateTime = updateTime;
//        this.createAt = createAt;
//    }

    public User(Long id, String name, String password, String email, String phone, String role, String imageUrl, String token, Timestamp updateTime, Timestamp createAt, Cart cart, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.imageUrl = imageUrl;
        this.token = token;
        this.updateTime = updateTime;
        this.createAt = createAt;
        this.cart = cart;
        this.orders = orders;
//        Product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
