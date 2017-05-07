package com.rbac.entity;

import javax.persistence.*;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "user2group", schema = "rbac")
public class User2GroupEntity {
    @Id
    @Column(name = "u2gid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int u2Gid;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "uid",referencedColumnName = "userid")
    private UserEntity uguserEntity;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "gid",referencedColumnName = "usergroupid")
    private UsergroupEntity ugusergroupEntity;

    public int getU2Gid() {
        return u2Gid;
    }

    public void setU2Gid(int u2Gid) {
        this.u2Gid = u2Gid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User2GroupEntity that = (User2GroupEntity) o;

        if (u2Gid != that.u2Gid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return u2Gid;
    }
}
