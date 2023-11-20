package com.exacto.cliAuthentication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "numbers_phone")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String uv;
    private String pv;

    public User() {
    }
    
    public Long getId() {   
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getname() { // Update the getter method name
        return name;
    }

    public void setname(String name) { // Update the setter method name
        this.name = name;
    }

    public String getpv() { // Update the getter method name
        return pv;
    }

    public void setpv(String pv) { // Update the setter method name
        this.pv = pv;
    }

    public String getuv() { // Update the getter method name
        return uv;
    }

    public void setuv(String uv) { // Update the setter method name
        this.uv = uv;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", pv=" + pv + ", uv=" + uv + "]";
    }

    public User(Long id, String name, String pv, String uv) {
        super();
        this.id = id;
        this.name = name;
        this.pv = pv;
        this.uv = uv;
    }
}
