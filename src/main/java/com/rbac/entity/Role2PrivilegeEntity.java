package com.rbac.entity;

import javax.persistence.*;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "role2privilege", schema = "rbac")
public class Role2PrivilegeEntity {
    @Id
    @Column(name = "r2pid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int r2Pid;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "rid",referencedColumnName = "roleid")
    private RoleEntity rproleEntity;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "pid",referencedColumnName = "privilegeid")
    private PrivilegeEntity rpprivilegeEntity;

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
