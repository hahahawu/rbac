package com.rbac.entity;

import javax.persistence.*;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "usergroup2role", schema = "rbac")
public class Usergroup2RoleEntity {

    @Id
    @Column(name = "u2rid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int u2Rid;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "gid",referencedColumnName = "usergroupid")
    private UsergroupEntity grusergroupEntity;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "rid",referencedColumnName = "roleid")
    private RoleEntity grroleEntity;

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

        Usergroup2RoleEntity that = (Usergroup2RoleEntity) o;

        if (u2Rid != that.u2Rid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return u2Rid;
    }

    public UsergroupEntity getGrusergroupEntity() {
        return grusergroupEntity;
    }

    public void setGrusergroupEntity(UsergroupEntity grusergroupEntity) {
        this.grusergroupEntity = grusergroupEntity;
    }

    public RoleEntity getGrroleEntity() {
        return grroleEntity;
    }

    public void setGrroleEntity(RoleEntity grroleEntity) {
        this.grroleEntity = grroleEntity;
    }
}
