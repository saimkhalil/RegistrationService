package com.example.RegistrationService.Validator;


import com.example.RegistrationService.Request.UserRequest;
import com.example.RegistrationService.Utils.SError;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UserValidator
{
    public void validateUserRequest(UserRequest userRequest) throws SError
    {
        if(userRequest.getFirstName() == null || userRequest.getFirstName().trim().equals(""))
        {
            throw new SError("Not provided First Name", HttpStatus.BAD_REQUEST);
        }
        else if(userRequest.getLastName() == null || userRequest.getLastName().trim().equals(""))
        {
            throw new SError("Not provided Last Name", HttpStatus.BAD_REQUEST);
        }
        else if(userRequest.getEmailId() == null || userRequest.getEmailId().trim().equals(""))
        {
            throw new SError("Not provided Email id", HttpStatus.BAD_REQUEST);
        }
        else if(userRequest.getPassword() == null || userRequest.getPassword().trim().equals(""))
        {
            throw new SError("Not provided Password", HttpStatus.BAD_REQUEST);
        }
        else if(userRequest.getPhoneNo() == null || userRequest.getPhoneNo().trim().equals(""))
        {
            throw new SError("Not provided Phone Number", HttpStatus.BAD_REQUEST);
        }
    }


}
