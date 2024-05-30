package com.example.demo.controller;

import lombok.Data;

@Data
public class PersonalFinancesGenericResponse {
    private Integer code;

    private String message;

    private Object data;
}
