package com.enigma.api.inventory.models.items;

import com.enigma.api.inventory.models.PageSearch;


public class ItemSearch extends PageSearch {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ItemSearch{" +
                "name='" + name + '\'' +
                '}';
    }
}
