package com.rbac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "user2group", schema = "rbac", catalog = "")
public class User2GroupEntity {
    private int u2Gid;

    @Id
    @Column(name = "u2gid")
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
