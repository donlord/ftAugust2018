package com.cooksys.cookbook.entity;

import java.util.Set;

public class Ingredient {

    private static int count = 1;

    private Integer id;

    private String name;

    private double quantity;

    private MeasurementUnit unit;

    public Ingredient () {}

    public Ingredient (String name, double quantity, MeasurementUnit unit) {
        this.id = count;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        count++;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public MeasurementUnit getUnit() {
        return unit;
    }

    public void setUnit(MeasurementUnit unit) {
        this.unit = unit;
    }
}
