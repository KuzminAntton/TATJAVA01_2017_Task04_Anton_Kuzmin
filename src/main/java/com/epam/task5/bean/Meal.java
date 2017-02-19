package com.epam.task5.bean;

import java.io.Serializable;

public class Meal implements Serializable {
    private int id;
    private String category;
    private String name;
    private String discription;
    private String portion;
    private int price;

    public Meal(int id, String category, String name, String discription, String portion, int price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.discription = discription;
        this.portion = portion;
        this.price = price;
    }

    public Meal() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meal meal = (Meal) o;

        if (id != meal.id) return false;
        if (price != meal.price) return false;
        if (name != null ? !name.equals(meal.name) : meal.name != null) return false;
        if (discription != null ? !discription.equals(meal.discription) : meal.discription != null) return false;
        return portion != null ? portion.equals(meal.portion) : meal.portion == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (discription != null ? discription.hashCode() : 0);
        result = 31 * result + (portion != null ? portion.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", discription='" + discription + '\'' +
                ", portion='" + portion + '\'' +
                ", price=" + price +
                '}';
    }
}
