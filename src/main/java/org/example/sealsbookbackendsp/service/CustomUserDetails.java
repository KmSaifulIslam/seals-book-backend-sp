package org.example.sealsbookbackendsp.service;

import org.example.sealsbookbackendsp.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // You can modify this to assign specific roles/permissions
        return null; // Add your logic for authorities
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Add your logic for account expiry
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Add your logic for account locking
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Add your logic for credential expiry
    }

    @Override
    public boolean isEnabled() {
        return true; // Add your logic for account enabling
    }

    public User getUser() {
        return user;
    }
}
