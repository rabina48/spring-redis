package com.project.cacheimpl.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Rabina Shrestha
 * @EmaiL rabina.shrestha@f1soft.com
 */

@Getter
@Setter

public class UserDTO implements Serializable {
    private String username;

    private String password;

    private String address;

    private String dob;

    private String email;
}
