package com.cooksys.cookbook.entity;

import java.util.Objects;

public class Ingredient {

    private static int counter = 1;

    private Integer id;

    private String name;

    private double quantity;

    private MeasurementUnit unit;

    public Ingredient () {}

    public Ingredient (String name, double quantity, MeasurementUnit unit) {
        this.id = this.counter;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.counter++;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Double.compare(that.quantity, quantity) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                unit == that.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, unit);
    }
}
