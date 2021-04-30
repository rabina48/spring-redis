package com.project.cacheimpl.service;

import com.project.cacheimpl.dto.UserDTO;
import com.project.cacheimpl.entities.User;

import java.util.List;

/**
 * @author Rabina Shrestha
 * @EmaiL rabina.shrestha@f1soft.com
 */

public interface UserService {
    List<User> getAllUser();

    User addUser(UserDTO userDTO);

    User updateUser(Integer userId, UserDTO userDTO) throws Exception;

    String deleteById(Integer userId);

    Object  getUserById(Integer userId) throws Exception;
}
