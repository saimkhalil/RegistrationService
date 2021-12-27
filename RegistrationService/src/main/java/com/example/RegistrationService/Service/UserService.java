package com.example.RegistrationService.Service;

import com.example.RegistrationService.Mapper.UserMapper;
import com.example.RegistrationService.Persistence.Model.User;
import com.example.RegistrationService.Persistence.Repository.UserRepository;
import com.example.RegistrationService.Request.UserRequest;
import com.example.RegistrationService.Response.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;



    public ResponseModel<User> getUserById(String id)
    {
        Optional<User> optionalUser = userRepository.findById(id);
        ResponseModel<User> responseModel = new ResponseModel<>();

        if (optionalUser.isPresent())
        {
            responseModel.setData(optionalUser.get());
            responseModel.setMessage("User fetched Successfully");
            responseModel.setHttpStatus(HttpStatus.OK);
            return responseModel;
        }
        else
        {
            responseModel.setMessage("User with the given ID is not valid");
            responseModel.setHttpStatus(HttpStatus.BAD_REQUEST);
            return responseModel;
        }
    }

    public ResponseModel<List<User>> getAllUsers()
    {
        ResponseModel<List<User>> responseModel = new ResponseModel<>();
        List<User> usersList = userRepository.findAll();
        if (usersList.isEmpty())
        {
            responseModel.setMessage("There is no entry yet in the database");
            responseModel.setHttpStatus(HttpStatus.OK);
        }
        else
        {
            responseModel.setData(usersList);
            responseModel.setHttpStatus(HttpStatus.OK);
            responseModel.setMessage("Fetched all users successfully");
        }
        return responseModel;

    }

    public ResponseModel<String> createUser(UserRequest userRequest)
    {
        User user = userMapper.mapUserRequestToUser(userRequest);
        user = userRepository.save(user);
        ResponseModel<String> responseModel = new ResponseModel<>();
        responseModel.setData("Your register id is = " + user.getId());
        responseModel.setMessage("registered Successfully");
        responseModel.setHttpStatus(HttpStatus.OK);
        return responseModel;

    }


}
