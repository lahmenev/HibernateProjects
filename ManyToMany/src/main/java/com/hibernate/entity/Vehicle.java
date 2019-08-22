package com.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
//@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String vehicleName;

    @ManyToMany
    private List<UserDetails> userList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public List<UserDetails> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDetails> userList) {
        this.userList = userList;
    }
}
