package com.nekromagus.github.controller.seller;

import com.nekromagus.github.dao.seller.exception.SellerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SellerExceptionController {

    @ExceptionHandler(value = SellerNotFoundException.class)
    public ResponseEntity<Object> notFound() {
        return new ResponseEntity<>("Seller not found", HttpStatus.NOT_FOUND);
    }
}
