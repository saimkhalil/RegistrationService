package com.example.RegistrationService.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserRequest
{
    private String firstName;

    private String lastName;

    private String emailId;

    private String password;

    private String phoneNo;
}
