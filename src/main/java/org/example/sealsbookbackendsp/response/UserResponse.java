package org.example.sealsbookbackendsp.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

@Getter
@Setter
//@NoArgsConstructor // Lombok generates no-argument constructor
//@AllArgsConstructor // Lombok generates constructor with all fields
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String role;
    private String password;
    private String imageUrl;
    private String token;
    private Timestamp createAt;
    private Timestamp updateTime;

    public UserResponse() {
    }

    public UserResponse(Long id, String name, String email, String phone, String role, String password, String imageUrl, String token, Timestamp createAt, Timestamp updateTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.password = password;
        this.imageUrl = imageUrl;
        this.token = token;
        this.createAt = createAt;
        this.updateTime = updateTime;
    }

    // Optional: you can add @JsonProperty if you want to change field names in JSON
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("createAt")
    public Timestamp getCreateAt() {
        return createAt;
    }

    @JsonProperty("updateTime")
    public Timestamp getUpdateTime() {
        return updateTime;
    }
}
