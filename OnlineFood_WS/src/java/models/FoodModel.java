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
public class FoodModel {
    private int food_id;
    private String foodName;
    private double foodPrice;
    private int isAvailable;
    private String foodPicPath;
    private String type;

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getFoodPicPath() {
        return foodPicPath;
    }

    public void setFoodPicPath(String foodPicPath) {
        this.foodPicPath = foodPicPath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FoodModel{" + "food_id=" + food_id + ", foodName=" + foodName + ", foodPrice=" + foodPrice + ", isAvailable=" + isAvailable + ", foodPicPath=" + foodPicPath + ", type=" + type + '}';
    }

    
}

  

   

