package com.enigma.api.inventory.models.units;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

@ExtendWith(MockitoExtension.class)

class ModelUnitTest {
    @Test
    void unitSearchTest(){
        UnitSearch expected = new UnitSearch();
        expected.setCode("coba");
        expected.setDescription("coba");
        expected.setPage(1);
        expected.setSize(1);
        expected.setSort(Sort.Direction.ASC);

        UnitSearch actual = new UnitSearch();
        actual.setCode("coba");
        actual.setDescription("coba");
        actual.setPage(1);
        actual.setSize(1);
        actual.setSort(Sort.Direction.ASC);

        Assertions.assertEquals(expected.getCode(),actual.getCode());
        Assertions.assertEquals(expected.getDescription(),actual.getDescription());
        Assertions.assertEquals(expected.getPage(),actual.getPage());
        Assertions.assertEquals(expected.getSize(),actual.getSize());
        Assertions.assertEquals(expected.getSort(),actual.getSort());



    }
}
