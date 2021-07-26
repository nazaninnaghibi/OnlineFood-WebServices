/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 14168
 */
public class OrderModel {
    private int order_id;
    private Date orderTime;
    private String status;//vazeyat sefaresh
    private double foodPrice;
    private double total_price;
    private Date deliverTime;
    private int count;
    private String foodName;
    private String fullName;
    private String phone;
    private String address;
    private int customerId;
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public String toString() {
        return "OrderModel{" + "order_id=" + order_id + ", orderTime=" + orderTime + ", status=" + status + ", foodPrice=" + foodPrice + ", total_price=" + total_price + ", deliverTime=" + deliverTime + ", count=" + count + ", foodName=" + foodName + ", fullName=" + fullName + ", phone=" + phone + ", address=" + address + ", customerId=" + customerId + '}';
    }

   

    

   

   
   
    
    
 

    
}
