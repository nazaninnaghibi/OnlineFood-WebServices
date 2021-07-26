/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author 14168
 */
public class CustomerModel {
    private  int cutomer_id;
    private String fullName;
    private String username;
    private String password;
    private String address;
    private String phone;

    public int getCutomer_id() {
        return cutomer_id;
    }

    public void setCutomer_id(int cutomer_id) {
        this.cutomer_id = cutomer_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CustomerModel{" + "cutomer_id=" + cutomer_id + ", fullName=" + fullName + ", username=" + username + ", password=" + password + ", address=" + address + ", phone=" + phone + '}';
    }
 
   
    
    
}
