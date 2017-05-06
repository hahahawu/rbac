package com.rbac.entity;

import javax.persistence.*;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "operation", schema = "rbac", catalog = "")
public class OperationEntity {
    private int operationid;
    private String operationname;

    @Id
    @Column(name = "operationid")
    public int getOperationid() {
        return operationid;
    }

    public void setOperationid(int operationid) {
        this.operationid = operationid;
    }

    @Basic
    @Column(name = "operationname")
    public String getOperationname() {
        return operationname;
    }

    public void setOperationname(String operationname) {
        this.operationname = operationname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperationEntity that = (OperationEntity) o;

        if (operationid != that.operationid) return false;
        if (operationname != null ? !operationname.equals(that.operationname) : that.operationname != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = operationid;
        result = 31 * result + (operationname != null ? operationname.hashCode() : 0);
        return result;
    }
}
