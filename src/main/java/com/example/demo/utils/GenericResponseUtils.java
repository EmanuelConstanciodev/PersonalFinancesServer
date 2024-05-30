package com.example.demo.utils;

import com.example.demo.controller.PersonalFinancesGenericResponse;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

@UtilityClass
public class GenericResponseUtils {
    private static final String GENERIC_MESSAGE = "OK";

    public static PersonalFinancesGenericResponse personalFinancesGenericResponse(Object data) {
        var response = new PersonalFinancesGenericResponse();
        response.setCode(HttpStatus.OK.value());
        response.setMessage(GENERIC_MESSAGE);
        response.setData(data);
        return response;
    }
}

