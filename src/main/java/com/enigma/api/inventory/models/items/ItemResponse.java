package com.enigma.api.inventory.models.items;

import com.enigma.api.inventory.models.units.UnitModel;


public class ItemResponse {
    private Integer id;
    private String name;
    private Integer price;
    private UnitModel unit;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public UnitModel getUnit() {
        return unit;
    }

    public void setUnit(UnitModel unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "ItemResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", unit=" + unit +
                '}';
    }
}
