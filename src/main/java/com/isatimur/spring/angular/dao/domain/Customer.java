package com.isatimur.spring.angular.dao.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by tisachenko on 15.10.15.
 */
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private boolean enabled;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoggedIn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return false;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(Date lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


}