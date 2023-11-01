package com.tarun.productreview.service;

import com.tarun.productreview.entity.User;
import com.tarun.productreview.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
