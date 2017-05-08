package com.rbac.entity;

import javax.persistence.*;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "privilege2op", schema = "rbac")
public class Privilege2OpEntity {
    @Id
    @Column(name = "p2opid")
    private int p2Opid;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "pid",referencedColumnName = "privilegeid")
    private PrivilegeEntity poprivilegeEntity;

    public PrivilegeEntity getPoprivilegeEntity() {
        return poprivilegeEntity;
    }

    public void setPoprivilegeEntity(PrivilegeEntity poprivilegeEntity) {
        this.poprivilegeEntity = poprivilegeEntity;
    }

    public OperationEntity getPooperationEntity() {
        return pooperationEntity;
    }

    public void setPooperationEntity(OperationEntity pooperationEntity) {
        this.pooperationEntity = pooperationEntity;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "oid",referencedColumnName = "operationid")
    private OperationEntity pooperationEntity;

    public int getP2Opid() {
        return p2Opid;
    }

    public void setP2Opid(int p2Opid) {
        this.p2Opid = p2Opid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Privilege2OpEntity that = (Privilege2OpEntity) o;

        if (p2Opid != that.p2Opid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return p2Opid;
    }
}
