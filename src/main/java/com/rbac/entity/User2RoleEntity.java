package com.rbac.entity;

import javax.persistence.*;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "user2role", schema = "rbac")
public class User2RoleEntity {
    @Id
    @Column(name = "u2rid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int u2Rid;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "uid", referencedColumnName = "userid")
    private UserEntity uruserEntity;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "rid", referencedColumnName = "roleid")
    private RoleEntity urroleEntity;

    public UserEntity getUserEntity() {
        return uruserEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.uruserEntity = userEntity;
    }

    public RoleEntity getRoleEntity() {
        return urroleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.urroleEntity = roleEntity;
    }


    public int getU2Rid() {
        return u2Rid;
    }

    public void setU2Rid(int u2Rid) {
        this.u2Rid = u2Rid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User2RoleEntity that = (User2RoleEntity) o;

        if (u2Rid != that.u2Rid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return u2Rid;
    }
}
