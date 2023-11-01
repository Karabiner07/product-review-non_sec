package com.tarun.productreview.controller;

import com.tarun.productreview.entity.User;
import com.tarun.productreview.repository.UserRepository;
import com.tarun.productreview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/api/hello")
    public String helloUser(){
        return "hello user";
    }

    @PostMapping("/api/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user){

        Map<String, Object> map = new HashMap<>();

        if(userRepository.existsUserByUserName(user.getUserName())){
            map.put("message", "User Already Exists !!");
            return new ResponseEntity<>(map, HttpStatus.NOT_ACCEPTABLE);
        }

        userService.registerUser(user);
        map.put("message", "Saved Successfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/api/login")
    public ResponseEntity<Object> loginUser(@RequestBody User user){

        Map<String, Object> map = new HashMap<>();

        if(userRepository.existsUserByUserName(user.getUserName())&&userRepository.existsUserByUserPass(user.getUserPass())){

            User u = userRepository.findUserByUserName(user.getUserName());

            map.put("message", "you are authorized");

            map.put("userId", u.getUserId());
            map.put("userName", u.getUserName());
            map.put("userPass", u.getUserPass());

            return new ResponseEntity<>(map, HttpStatus.OK);
        }
        map.put("message", "You are not authorized");
        return new ResponseEntity<>(map, HttpStatus.METHOD_NOT_ALLOWED);
    }

}
