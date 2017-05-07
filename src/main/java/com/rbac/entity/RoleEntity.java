package com.rbac.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "role", schema = "rbac")
public class RoleEntity {
    @Id
    @Column(name = "roleid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleid;
    @Basic
    @Column(name = "rolename",nullable = false)
    private String rolename;

    @OneToMany(mappedBy = "urroleEntity",cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    private Set<User2RoleEntity> user2RoleEntitySet;

    @OneToMany(mappedBy = "grroleEntity",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Usergroup2RoleEntity> usergroup2RoleEntitySet;

    @OneToMany(mappedBy = "rproleEntity",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Role2PrivilegeEntity> role2PrivilegeEntitySet;

    public int getRoleid() {
        return roleid;
    }
    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }
    public String getRolename() {
        return rolename;
    }
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (roleid != that.roleid) return false;
        if (rolename != null ? !rolename.equals(that.rolename) : that.rolename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleid;
        result = 31 * result + (rolename != null ? rolename.hashCode() : 0);
        return result;
    }
}
