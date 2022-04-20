package com.charge.ecommerce.service;

import com.charge.ecommerce.entity.User;
import com.charge.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudService<User> {
    @Autowired
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }
}
