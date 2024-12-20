package com.example.demo_app.controller;

import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.List;

public class InvalidEntityErrorDto {
    private final int statusCode;
    private final LocalDateTime localDateTime;
    private final String message;
    private final String description;
    private final BindingResult listeErreursGlobales;
    private final BindingResult listeErreursChamps;


    public InvalidEntityErrorDto(int statusCode, LocalDateTime localDateTime, String message, String description, BindingResult listeErreursGlobales, BindingResult listeErreursChamps) {
        this.statusCode = statusCode;
        this.localDateTime = localDateTime;
        this.message = message;
        this.description = description;
        this.listeErreursGlobales = listeErreursGlobales;
        this.listeErreursChamps = listeErreursChamps;

    }
}
