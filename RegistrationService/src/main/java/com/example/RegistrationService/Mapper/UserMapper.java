package com.example.RegistrationService.Mapper;


import com.example.RegistrationService.Persistence.Model.User;
import com.example.RegistrationService.Request.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper
{
    public User mapUserRequestToUser(UserRequest userRequest)
    {
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmailId(userRequest.getEmailId());
        user.setPassword(userRequest.getPassword());
        user.setPhoneNo(userRequest.getPhoneNo());
        return user;

    }
}
