package com.rbac.entity;

import javax.persistence.*;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "usergroup", schema = "rbac", catalog = "")
public class UsergroupEntity {
    private int usergroupid;
    private String usergroupname;
    private int parentusergroupid;

    @Id
    @Column(name = "usergroupid")
    public int getUsergroupid() {
        return usergroupid;
    }

    public void setUsergroupid(int usergroupid) {
        this.usergroupid = usergroupid;
    }

    @Basic
    @Column(name = "usergroupname")
    public String getUsergroupname() {
        return usergroupname;
    }

    public void setUsergroupname(String usergroupname) {
        this.usergroupname = usergroupname;
    }

    @Basic
    @Column(name = "parentusergroupid")
    public int getParentusergroupid() {
        return parentusergroupid;
    }

    public void setParentusergroupid(int parentusergroupid) {
        this.parentusergroupid = parentusergroupid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsergroupEntity that = (UsergroupEntity) o;

        if (usergroupid != that.usergroupid) return false;
        if (parentusergroupid != that.parentusergroupid) return false;
        if (usergroupname != null ? !usergroupname.equals(that.usergroupname) : that.usergroupname != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = usergroupid;
        result = 31 * result + (usergroupname != null ? usergroupname.hashCode() : 0);
        result = 31 * result + parentusergroupid;
        return result;
    }
}
