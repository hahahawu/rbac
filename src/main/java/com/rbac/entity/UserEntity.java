package com.rbac.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "user", schema = "rbac")
public class UserEntity {
    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;

    @Basic
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "uruserEntity",cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    private Set<User2RoleEntity> user2RoleEntitySet;

    @OneToMany(mappedBy = "uguserEntity",cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    private Set<User2GroupEntity> user2GroupEntitySet;

    public int getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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


    public Set<User2RoleEntity> getUser2RoleEntitySet() {
        return user2RoleEntitySet;
    }

    public void setUser2RoleEntitySet(Set<User2RoleEntity> user2RoleEntitySet) {
        this.user2RoleEntitySet = user2RoleEntitySet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userid != that.userid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
