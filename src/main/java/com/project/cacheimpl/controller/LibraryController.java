package com.project.cacheimpl.controller;

import com.project.cacheimpl.constant.MsgConstant;
import com.project.cacheimpl.dto.UserDTO;
import com.project.cacheimpl.repository.UserRepository;
import com.project.cacheimpl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.project.cacheimpl.constant.MsgConstant.url.FETCH_ALL;
import static com.project.cacheimpl.constant.MsgConstant.url.USER_ID;

/**
 * @author Rabina Shrestha
 * @EmaiL rabina.shrestha@f1soft.com
 */

@RestController
@RequestMapping(MsgConstant.url.LIBRARY)
public class LibraryController {

    @Autowired
    private UserService userService;


//    @GetMapping(FETCH_ALL)

//    @Cacheable(cacheNames = "user", key = "#userId", cacheManager = "redisManager")
//    public ResponseEntity<?> getAllUserData(){
//        return ResponseEntity.ok(userService.getAllUser());
//    }


    @GetMapping(FETCH_ALL)
    @Cacheable(cacheNames = "redisTest", key = "#userId", cacheManager = "redisManager")
    public ResponseEntity<?>  getAllUserByIdRedis(@PathVariable Integer userId)
            throws Exception {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PostMapping(MsgConstant.url.ADD_USER)
    public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.addUser(userDTO));
    }

    @PutMapping(MsgConstant.url.UPDATE+"/"+USER_ID)
    public ResponseEntity<?> updateUser(@PathVariable Integer userId,@RequestBody UserDTO userDTO) throws Exception {
        return ResponseEntity.ok(userService.updateUser(userId, userDTO));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteById(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.deleteById(userId));
    }


    @GetMapping("{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Integer userId) throws Exception {
            return ResponseEntity.ok(userService.getUserById(userId));
        }








}
