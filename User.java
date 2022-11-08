

package com.example.inclass04;

import java.io.Serializable;

public class User implements Serializable {

    public String name;
    public String email;
    public String ID;
    public String department;

    public User(String name, String email, String ID, String department){
        this.name = name;
        this.email = email;
        this.ID = ID;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
