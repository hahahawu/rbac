package com.rbac.entity;

import javax.persistence.*;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "privilege", schema = "rbac", catalog = "")
public class PrivilegeEntity {
    private int privilegeid;
    private String privilegename;

    @Id
    @Column(name = "privilegeid")
    public int getPrivilegeid() {
        return privilegeid;
    }

    public void setPrivilegeid(int privilegeid) {
        this.privilegeid = privilegeid;
    }

    @Basic
    @Column(name = "privilegename")
    public String getPrivilegename() {
        return privilegename;
    }

    public void setPrivilegename(String privilegename) {
        this.privilegename = privilegename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrivilegeEntity that = (PrivilegeEntity) o;

        if (privilegeid != that.privilegeid) return false;
        if (privilegename != null ? !privilegename.equals(that.privilegename) : that.privilegename != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = privilegeid;
        result = 31 * result + (privilegename != null ? privilegename.hashCode() : 0);
        return result;
    }
}
