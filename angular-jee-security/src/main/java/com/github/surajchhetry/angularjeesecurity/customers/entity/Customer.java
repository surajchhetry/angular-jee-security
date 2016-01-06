package com.github.surajchhetry.angularjeesecurity.customers.entity;

import java.util.Objects;

/**
 *
 * @author surajchhetry
 */
public class Customer {

    private String cid;
    private String name;
    private String phone;

    public Customer() {
        cid = String.valueOf(System.nanoTime());
    }

    public Customer(String name, String phone) {
        this();
        this.name = name;
        this.phone = phone;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.cid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.cid, other.cid)) {
            return false;
        }
        return true;
    }

}
