package com.project.cacheimpl.repository;

import com.project.cacheimpl.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Rabina Shrestha
 * @EmaiL rabina.shrestha@f1soft.com
 */

@Repository
public interface UserRepository extends JpaRepository<User,Integer > {

    Optional<User> findById(Integer userId);
}
