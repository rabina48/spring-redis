package com.project.cacheimpl.service.impl;

import com.project.cacheimpl.dto.UserDTO;
import com.project.cacheimpl.entities.User;
import com.project.cacheimpl.repository.UserRepository;
import com.project.cacheimpl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Rabina Shrestha
 * @EmaiL rabina.shrestha@f1soft.com
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Cacheable(cacheNames = "redisTest")
    public List<User> getAllUser() {

        List<User> user = userRepository.findAll();
        return user;
    }

    @Override
    public User addUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setAddress(userDTO.getAddress());
        user.setDob(userDTO.getDob());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user);
    }


    @Override
   @CachePut(cacheNames = "user", key = "#user.id")
    public User updateUser(Integer userId, UserDTO userDTO) throws Exception {

        Optional<User> data = userRepository.findById(userId);

        if (data.isPresent()) {
            User user = data.get();
            user.setUsername(userDTO.getUsername());
            user.setAddress(userDTO.getAddress());
            user.setDob(userDTO.getDob());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());

            return userRepository.save(user);
        } else {
            throw new Exception("not found");

        }

    }

    @Override
    @CacheEvict(cacheNames = "user", allEntries = true)
    public String deleteById(Integer userId) {

        Optional<User> userDb = userRepository.findById(userId);
        if (userDb.isPresent()) {
            userRepository.deleteById(userId);

            return "success";
        } else {
            return "failure";
        }

    }

    @Override
    public User getUserById(Integer userId) throws Exception {

        System.out.println("from database");

        Optional<User> productDb = this.userRepository.findById(userId);
        if (productDb.isPresent()) {

            User userdata = productDb.get();
            return userdata;
        } else {

            throw new Exception("not found");
        }

    }
}
