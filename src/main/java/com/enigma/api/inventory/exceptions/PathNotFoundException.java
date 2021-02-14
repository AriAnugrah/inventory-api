package com.enigma.api.inventory.exceptions;

import com.enigma.api.inventory.exceptions.ApplicationException;
import org.springframework.http.HttpStatus;

public class PathNotFoundException extends ApplicationException {

    public PathNotFoundException() {
        super(HttpStatus.NOT_FOUND, "error." + HttpStatus.NOT_FOUND.value() + ".path");
    }
}
