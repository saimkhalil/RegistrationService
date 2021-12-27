package com.example.RegistrationService.Response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseModel<T>
{
    private String message;



    private T data;
    private HttpStatus httpStatus;




}
