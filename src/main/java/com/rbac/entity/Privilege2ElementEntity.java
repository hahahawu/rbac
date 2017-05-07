package com.rbac.entity;

import javax.persistence.*;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "privilege2element", schema = "rbac", catalog = "")
public class Privilege2ElementEntity {
    @Id
    @Column(name = "p2eid")
    private int p2Eid;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "pid",referencedColumnName = "privilegeid")
    private PrivilegeEntity peprivilegeEntity;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "eid",referencedColumnName = "elementid")
    private ElementsinpageEntity peelementsinpageEntity;

    public int getP2Eid() {
        return p2Eid;
    }

    public void setP2Eid(int p2Eid) {
        this.p2Eid = p2Eid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Privilege2ElementEntity that = (Privilege2ElementEntity) o;

        if (p2Eid != that.p2Eid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return p2Eid;
    }
}
