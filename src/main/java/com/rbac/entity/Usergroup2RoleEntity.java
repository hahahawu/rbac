package com.rbac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "usergroup2role", schema = "rbac", catalog = "")
public class Usergroup2RoleEntity {
    private int u2Rid;

    @Id
    @Column(name = "u2rid")
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
}
