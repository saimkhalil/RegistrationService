package com.example.RegistrationService.Controller;


import com.example.RegistrationService.Persistence.Model.User;
import com.example.RegistrationService.Persistence.Repository.UserRepository;
import com.example.RegistrationService.Request.UserRequest;
import com.example.RegistrationService.Response.ResponseModel;
import com.example.RegistrationService.Service.UserService;
import com.example.RegistrationService.Utils.SError;
import com.example.RegistrationService.Validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserRequest userRequest;

    //addUser
    //getUsers
    //getUserById
    //deleteUser

    @GetMapping(name = "/getUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseModel<List<User>> getUsers()
    {
        System.out.println("entered");
        return userService.getAllUsers();
    }

    @GetMapping(name = "/getUsers/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseModel<User> getUserById(@PathVariable(value = "id") String id)
    {
        ResponseModel<User> responseModel = new ResponseModel<>();

        if(id == null || "".equals(id.trim()))
        {
            responseModel.setMessage("Empty User id");
            responseModel.setHttpStatus(HttpStatus.BAD_REQUEST);
        }
        else
        {
            responseModel = userService.getUserById(id);
        }
        return responseModel;
    }

    @PostMapping(name = "/registerUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseModel<String> register(@RequestBody UserRequest userRequest)
    {
        ResponseModel<String> responseModel = new ResponseModel<>();
        try{
            userValidator.validateUserRequest(userRequest);
            responseModel = userService.createUser(userRequest);
        }
        catch (SError se)
        {
            responseModel.setMessage("Invalid input :" + se.getMessage());
            responseModel.setHttpStatus(se.getHttpStatus());
        }
        return responseModel;

    }









}
