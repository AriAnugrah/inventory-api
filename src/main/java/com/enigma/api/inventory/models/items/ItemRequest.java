package com.enigma.api.inventory.models.items;





import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ItemRequest {
    @Size(min = 1, max = 100)
    private String name;
    private Integer price;
    @NotNull
    private Integer unitId;

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

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    @Override
    public String toString() {
        return "ItemRequest{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", unitId=" + unitId +
                '}';
    }
}