package com.isatimur.spring.angular.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by tisachenko on 15.10.15.
 */
@Entity
public class CustomRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    private String role;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
    )
    private Set<CustomUser> userRoles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<CustomUser> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<CustomUser> userRoles) {
        this.userRoles = userRoles;
    }

}
