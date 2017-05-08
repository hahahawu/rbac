package com.rbac.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "privilege", schema = "rbac")
public class PrivilegeEntity {
    @Id
    @Column(name = "privilegeid")
    private int privilegeid;

    public Set<Role2PrivilegeEntity> getRole2PrivilegeEntitySet() {
        return role2PrivilegeEntitySet;
    }

    public void setRole2PrivilegeEntitySet(Set<Role2PrivilegeEntity> role2PrivilegeEntitySet) {
        this.role2PrivilegeEntitySet = role2PrivilegeEntitySet;
    }

    public Set<Privilege2OpEntity> getPrivilege2OpEntitySet() {
        return privilege2OpEntitySet;
    }

    public void setPrivilege2OpEntitySet(Set<Privilege2OpEntity> privilege2OpEntitySet) {
        this.privilege2OpEntitySet = privilege2OpEntitySet;
    }

    public Set<Privilege2ElementEntity> getPrivilege2ElementEntitySet() {
        return privilege2ElementEntitySet;
    }

    public void setPrivilege2ElementEntitySet(Set<Privilege2ElementEntity> privilege2ElementEntitySet) {
        this.privilege2ElementEntitySet = privilege2ElementEntitySet;
    }

    @Basic
    @Column(name = "privilegename",nullable = false)
    private String privilegename;

    @OneToMany(mappedBy = "rpprivilegeEntity",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Role2PrivilegeEntity> role2PrivilegeEntitySet;

    @OneToMany(mappedBy = "poprivilegeEntity",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Privilege2OpEntity> privilege2OpEntitySet;

    @OneToMany(mappedBy = "peprivilegeEntity",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Privilege2ElementEntity> privilege2ElementEntitySet;

    public int getPrivilegeid() {
        return privilegeid;
    }

    public void setPrivilegeid(int privilegeid) {
        this.privilegeid = privilegeid;
    }

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
