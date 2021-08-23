package hu.ulyssys.java.course.exam.rest.model;

import hu.ulyssys.java.course.exam.entity.AppUserRole;

import javax.persistence.*;
import java.util.Date;

public class AppUserModel {
    private Long id;
    private Date createDate;
    private String username;
    private String password;
    private AppUserRole role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppUserRole getRole() {
        return role;
    }

    public void setRole(AppUserRole role) {
        this.role = role;
    }
}
