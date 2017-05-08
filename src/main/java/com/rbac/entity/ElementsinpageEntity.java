package com.rbac.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "elementsinpage", schema = "rbac")
public class ElementsinpageEntity {
    @Id
    @Column(name = "elementid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int elementid;

    public Set<Privilege2ElementEntity> getPrivilege2ElementEntities() {
        return privilege2ElementEntities;
    }

    public void setPrivilege2ElementEntities(Set<Privilege2ElementEntity> privilege2ElementEntities) {
        this.privilege2ElementEntities = privilege2ElementEntities;
    }

    @Basic
    @Column(name = "elementname",nullable = false)
    private String elementname;

    @OneToMany(mappedBy = "peelementsinpageEntity",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Privilege2ElementEntity> privilege2ElementEntities;

    public int getElementid() {
        return elementid;
    }
    public void setElementid(int elementid) {
        this.elementid = elementid;
    }

    public String getElementname() {
        return elementname;
    }

    public void setElementname(String elementname) {
        this.elementname = elementname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElementsinpageEntity that = (ElementsinpageEntity) o;

        if (elementid != that.elementid) return false;
        if (elementname != null ? !elementname.equals(that.elementname) : that.elementname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = elementid;
        result = 31 * result + (elementname != null ? elementname.hashCode() : 0);
        return result;
    }
}
