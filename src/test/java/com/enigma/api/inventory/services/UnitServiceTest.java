package com.enigma.api.inventory.services;


import com.enigma.api.inventory.entities.Unit;
import com.enigma.api.inventory.repository.UnitRepository;
import com.enigma.api.inventory.services.impl.UnitServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UnitServiceTest {

    @InjectMocks
    private UnitServiceImpl service;

    @Mock
    private UnitRepository repository;

    @Test
    public void shouldSave(){
        Unit input = new Unit();
        input.setCode("XYZ");
        input.setDescription("XYZ");

        Unit output = new Unit();
        output.setId(1);
        output.setCode("XYZ");
        output.setDescription("XYZ");

        when(repository.save(any()))
                .thenReturn(output);

        Unit result = service.save(input);

        assertEquals(output,result);

    }

}
