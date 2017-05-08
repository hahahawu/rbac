package com.rbac.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "usergroup", schema = "rbac")
public class UsergroupEntity {
    @Id
    @Column(name = "usergroupid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int usergroupid;

    @Basic
    @Column(name = "usergroupname")
    private String usergroupname;

    public Set<User2GroupEntity> getUser2GroupEntitySet() {
        return user2GroupEntitySet;
    }

    public void setUser2GroupEntitySet(Set<User2GroupEntity> user2GroupEntitySet) {
        this.user2GroupEntitySet = user2GroupEntitySet;
    }

    public Set<Usergroup2RoleEntity> getUsergroup2RoleEntitySet() {
        return usergroup2RoleEntitySet;
    }

    public void setUsergroup2RoleEntitySet(Set<Usergroup2RoleEntity> usergroup2RoleEntitySet) {
        this.usergroup2RoleEntitySet = usergroup2RoleEntitySet;
    }

    @OneToMany(mappedBy = "ugusergroupEntity",cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    private Set<User2GroupEntity> user2GroupEntitySet;

    @OneToMany(mappedBy = "grusergroupEntity",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Usergroup2RoleEntity> usergroup2RoleEntitySet;

    public int getUsergroupid() {
        return usergroupid;
    }

    public void setUsergroupid(int usergroupid) {
        this.usergroupid = usergroupid;
    }

    public String getUsergroupname() {
        return usergroupname;
    }

    public void setUsergroupname(String usergroupname) {
        this.usergroupname = usergroupname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsergroupEntity that = (UsergroupEntity) o;

        if (usergroupid != that.usergroupid) return false;
        if (usergroupname != null ? !usergroupname.equals(that.usergroupname) : that.usergroupname != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = usergroupid;
        result = 31 * result + (usergroupname != null ? usergroupname.hashCode() : 0);
        return result;
    }
}
