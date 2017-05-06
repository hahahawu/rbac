package com.rbac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "role2privilege", schema = "rbac", catalog = "")
public class Role2PrivilegeEntity {
    private int r2Pid;

    @Id
    @Column(name = "r2pid")
    public int getR2Pid() {
        return r2Pid;
    }

    public void setR2Pid(int r2Pid) {
        this.r2Pid = r2Pid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role2PrivilegeEntity that = (Role2PrivilegeEntity) o;

        if (r2Pid != that.r2Pid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return r2Pid;
    }
}
