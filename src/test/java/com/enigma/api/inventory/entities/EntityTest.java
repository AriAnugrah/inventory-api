package com.enigma.api.inventory.entities;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class EntityTest {
    @Test
    void itemSetGetTest() {
        Item expected = new Item();
        expected.setId(1);
        expected.setName("coba");
        expected.setStatus(true);
        expected.setPrice(1);
        expected.setUnit(expected.getUnit());
        expected.setCreatedDate(LocalDateTime.MIN);
        expected.setModifiedDate(LocalDateTime.MIN);

        Item actual = new Item();
        actual.setId(1);
        actual.setName("coba");
        actual.setStatus(true);
        actual.setPrice(1);
        actual.setUnit(actual.getUnit());
        actual.setCreatedDate(LocalDateTime.MIN);
        actual.setModifiedDate(LocalDateTime.MIN);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.isStatus(), actual.isStatus());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getPrice(), actual.getPrice());
        assertEquals(expected.getUnit(), actual.getUnit());
        assertEquals(expected.toString(), actual.toString());
        assertEquals(expected.getCreatedDate(), actual.getCreatedDate());
        assertEquals(expected.getModifiedDate(), actual.getModifiedDate());
    }

    @Test
    void unitSetGetTest() {
        Unit expected = new Unit();
        expected.setId(1);
        expected.setCreatedDate(LocalDateTime.MIN);
        expected.setModifiedDate(LocalDateTime.MIN);
        expected.setCode("coba");
        expected.setDescription("A");
        expected.setStatus(true);

        Unit actual = new Unit();
        actual.setId(1);
        actual.setCreatedDate(LocalDateTime.MIN);
        actual.setModifiedDate(LocalDateTime.MIN);
        actual.setCode("coba");
        actual.setDescription("A");
        actual.setStatus(true);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getCreatedDate(), actual.getCreatedDate());
        assertEquals(expected.getModifiedDate(), actual.getModifiedDate());
        assertEquals(expected.getCode(), actual.getCode());
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.isStatus(), actual.isStatus());
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void stockSetGetTest() {
        Stock expected = new Stock();
        expected.setId(1);
        expected.setModifiedDate(LocalDateTime.MIN);
        expected.setCreatedDate(LocalDateTime.MIN);
        expected.setQuantity(2);
        expected.setStatus(true);
        expected.setItem(expected.getItem());

        Stock actual = new Stock();
        actual.setId(1);
        actual.setModifiedDate(LocalDateTime.MIN);
        actual.setCreatedDate(LocalDateTime.MIN);
        actual.setQuantity(2);
        actual.setStatus(true);
        actual.setItem(actual.getItem());

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getCreatedDate(), actual.getCreatedDate());
        assertEquals(expected.getModifiedDate(), actual.getModifiedDate());
        assertEquals(expected.getQuantity(), actual.getQuantity());
        assertEquals(expected.getItem(), actual.getItem());
        assertEquals(expected.isStatus(), actual.isStatus());
        assertEquals(expected.toString(), actual.toString());

    }


}

