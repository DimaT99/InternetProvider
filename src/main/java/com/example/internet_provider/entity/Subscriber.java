package com.example.internet_provider.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
public class Subscriber implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String firstname;
    private String lastname;
    @Email
    private String email;
    private String password;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "subscriber_role", joinColumns = @JoinColumn(name = "subscriber_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean isAdmin() {
        return getRoles().contains(Role.ADMIN);
    }

}
