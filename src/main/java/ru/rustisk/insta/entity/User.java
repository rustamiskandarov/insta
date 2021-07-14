package ru.rustisk.insta.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, updatable = false)
    private String username;
    @Column(nullable = true)
    private String lastname;
    @Column(nullable = true)
    private String firstname;
    @Column(unique = true)
    private String email;
    @Column(columnDefinition = "text")
    private String biography;
    @Column(length = 3000)
    private String password;
    @ElementCollection(targetClass = Role.class)
    @CollectionTable(
            name="user_role",
            joinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Role> role = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    @Column(updatable = false)
    private LocalDateTime createDate;

    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    @PrePersist
    protected void onCreated(){
        this.createDate = LocalDateTime.now();
    }

    @Override
    public String getPassword(){
        return this.password;
    }

    public User(Long id, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    /**
     * SECURITY
     */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
}
