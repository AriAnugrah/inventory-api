package com.enigma.api.inventory.models;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
 class ImageUploadTest {
    @Test
    void imageTest(){
        ImageUploadRequest expected = new ImageUploadRequest();
        expected.setFile(expected.getFile());


        ImageUploadRequest actual = new ImageUploadRequest();
        actual.setFile(expected.getFile());

        Assertions.assertEquals(expected.getFile(),actual.getFile());
        Assertions.assertEquals(expected.getClass(),actual.getClass());


    }
}
