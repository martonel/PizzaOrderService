package hu.ulyssys.java.course.exam.entity;

import javax.persistence.*;


@NamedQuery(name = AppUser.FIND_BY_USERNAME, query = "select u from AppUser u where u.username=:username")
@Entity
@Table
public  class AppUser extends AbstractEntity{
    public static final String FIND_BY_USERNAME = "AppUser.findByUsername";
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private AppUserRole role;



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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppUser user = (AppUser) o;

        if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
        return username != null ? username.equals(user.username) : user.username == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
