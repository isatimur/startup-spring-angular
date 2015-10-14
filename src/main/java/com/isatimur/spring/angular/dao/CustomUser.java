package com.isatimur.spring.angular.dao;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.security.acl.Group;
import java.util.*;

/**
 * Created by tisachenko on 15.10.15.
 */
@Entity
public class CustomUser implements Serializable,UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    private String login;

    private String password;

    private boolean enabled;

    private Date lastLoggedIn;

    private List<Group> groups = new ArrayList();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private CustomRole role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList grantedAuthorities = new ArrayList();
        Iterator i = this.groups.iterator();

        while(i.hasNext()){
            CustomGroup group = (CustomGroup) i.next();
            grantedAuthorities.add(group.asGrantedAuthority());
        }
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
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
        return false;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CustomRole getRole() {
        return role;
    }

    public void setRole(CustomRole role) {
        this.role = role;
    }
}