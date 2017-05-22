package com.marketplace.propertiesservice.backend;

import com.marketplace.propertiesservice.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User get(String userId) {
        return userRepository.findOne(userId);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(String userId) {
        userRepository.delete(userId);
    }
}
