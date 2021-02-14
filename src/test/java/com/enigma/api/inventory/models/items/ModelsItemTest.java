package com.enigma.api.inventory.models.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

@ExtendWith(MockitoExtension.class)
class ModelsItemTest {
    @Test
    void itemELementTest() {
        ItemElement expected = new ItemElement();
        expected.setName("coba");
        expected.setId(1);
        expected.setPrice(1);

        ItemElement actual = new ItemElement();
        actual.setName("coba");
        actual.setId(1);
        actual.setPrice(1);

        Assertions.assertEquals(expected.getName(),actual.getName());
        Assertions.assertEquals(expected.getId(),actual.getId());
        Assertions.assertEquals(expected.getPrice(),actual.getPrice());
        Assertions.assertEquals(expected.toString(),actual.toString());
    }

    @Test
    void itemRequestTest(){
        ItemRequest expected = new ItemRequest();
        expected.setName("coba");
        expected.setPrice(1);
        expected.setUnitId(expected.getUnitId());

        ItemRequest actual = new ItemRequest();
        actual.setName("coba");
        actual.setPrice(1);
        actual.setUnitId(expected.getUnitId());

        Assertions.assertEquals(expected.getName(),actual.getName());
        Assertions.assertEquals(expected.getPrice(),actual.getPrice());
        Assertions.assertEquals(expected.getUnitId(),actual.getUnitId());
        Assertions.assertEquals(expected.toString(),actual.toString());
    }
    @Test
    void itemResponseTest(){
        ItemResponse expected = new ItemResponse();
        expected.setId(1);
        expected.setName("name");
        expected.setPrice(1);
        expected.setUnit(expected.getUnit());


        ItemResponse actual = new ItemResponse();
        actual.setId(1);
        actual.setName("name");
        actual.setPrice(1);
        actual.setUnit(actual.getUnit());

        Assertions.assertEquals(expected.getName(),actual.getName());
        Assertions.assertEquals(expected.getPrice(),actual.getPrice());
        Assertions.assertEquals(expected.getUnit(),actual.getUnit());
        Assertions.assertEquals(expected.getId(),actual.getId());
        Assertions.assertEquals(expected.toString(),actual.toString());

    }

    @Test
    void itemSearchTest(){
        ItemSearch expected = new ItemSearch();
        expected.setName("coba");
        expected.setPage(1);
        expected.setSize(1);
        expected.setSort(Sort.Direction.ASC);

        ItemSearch actual = new ItemSearch();
        actual.setName("coba");
        actual.setPage(1);
        actual.setSize(1);
        actual.setSort(Sort.Direction.ASC);

        Assertions.assertEquals(expected.getName(),actual.getName());
        Assertions.assertEquals(expected.getPage(),actual.getPage());
        Assertions.assertEquals(expected.getSize(),actual.getSize());
        Assertions.assertEquals(expected.getSort(),actual.getSort());
        Assertions.assertEquals(expected.toString(),actual.toString());

    }


}
