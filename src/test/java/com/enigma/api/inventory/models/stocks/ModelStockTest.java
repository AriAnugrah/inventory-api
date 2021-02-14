package com.enigma.api.inventory.models.stocks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

@ExtendWith(MockitoExtension.class)
 class ModelStockTest {

    @Test
    void stockElementTest(){
        StockElement expected = new StockElement();
        expected.setId(1);
        expected.setQuantity(2);

        StockElement actual = new StockElement();
        actual.setId(1);
        actual.setQuantity(2);

        Assertions.assertEquals(expected.getId(),actual.getId());
        Assertions.assertEquals(expected.getQuantity(),actual.getQuantity());


    }

    @Test
    void stockRequestTest(){
        StockRequest expected = new StockRequest();
        expected.setItemId(1);
        expected.setQuantity(1);

        StockRequest actual = new StockRequest();
        actual.setItemId(1);
        actual.setQuantity(1);

        Assertions.assertEquals(expected.getItemId(),actual.getItemId());
        Assertions.assertEquals(expected.getQuantity(),actual.getQuantity());


    }

    @Test
    void stockSearch(){
        StockSearch expected = new StockSearch();
        expected.setQuantity(1);
        expected.setPage(1);
        expected.setSize(1);
        expected.setSort(Sort.Direction.ASC);

        StockSearch actual = new StockSearch();
        actual.setQuantity(1);
        actual.setPage(1);
        actual.setSize(1);
        actual.setSort(Sort.Direction.ASC);

        Assertions.assertEquals(expected.getQuantity(),actual.getQuantity());
        Assertions.assertEquals(expected.getPage(),actual.getPage());
        Assertions.assertEquals(expected.getSize(),actual.getSize());
        Assertions.assertEquals(expected.getSort(),actual.getSort());

    }


}
