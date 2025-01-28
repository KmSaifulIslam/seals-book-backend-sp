package org.example.sealsbookbackendsp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String role;
    private String imageUrl;
    private String token;
    private Timestamp updateTime;
    private Timestamp createAt;
}
