package com.isatimur.spring.angular.dao;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tisachenko on 15.10.15.
 */
@Entity
public class CustomGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String description;

    private boolean deleted;

    private Date deletedTimeStamp;

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


    public CustomRole getRole() {
        return role;
    }

    public void setRole(CustomRole role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getDeletedTimeStamp() {
        return deletedTimeStamp;
    }

    public void setDeletedTimeStamp(Date deletedTimeStamp) {
        this.deletedTimeStamp = deletedTimeStamp;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public GrantedAuthority asGrantedAuthority() {
        return new SimpleGrantedAuthority("group_" + this.name);
    }
}