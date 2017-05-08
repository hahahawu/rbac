package com.rbac.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "operation", schema = "rbac")
public class OperationEntity {
    @Id
    @Column(name = "operationid")
    private int operationid;

    @Basic
    @Column(name = "operationname",nullable = false)
    private String operationname;

    public Set<Privilege2OpEntity> getPrivilege2OpEntitySet() {
        return privilege2OpEntitySet;
    }

    public void setPrivilege2OpEntitySet(Set<Privilege2OpEntity> privilege2OpEntitySet) {
        this.privilege2OpEntitySet = privilege2OpEntitySet;
    }

    @OneToMany(mappedBy = "pooperationEntity",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Privilege2OpEntity> privilege2OpEntitySet;


    public int getOperationid() {
        return operationid;
    }

    public void setOperationid(int operationid) {
        this.operationid = operationid;
    }

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
