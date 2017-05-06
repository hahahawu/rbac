package com.rbac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "privilege2op", schema = "rbac", catalog = "")
public class Privilege2OpEntity {
    private int p2Opid;

    @Id
    @Column(name = "p2opid")
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
