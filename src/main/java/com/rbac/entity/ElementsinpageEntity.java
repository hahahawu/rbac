package com.rbac.entity;

import javax.persistence.*;

/**
 * Created by hahah on 2017/5/5.
 */
@Entity
@Table(name = "elementsinpage", schema = "rbac", catalog = "")
public class ElementsinpageEntity {
    private int elementid;
    private String elementname;

    @Id
    @Column(name = "elementid")
    public int getElementid() {
        return elementid;
    }

    public void setElementid(int elementid) {
        this.elementid = elementid;
    }

    @Basic
    @Column(name = "elementname")
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
