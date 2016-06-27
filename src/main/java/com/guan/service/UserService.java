package com.guan.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.guan.domain.User;
import com.guan.dto.UserDto;
import com.guan.exceptions.ResourceNotFoundException;
import com.guan.repo.UserRepository;

@Service
public class UserService {
    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepo;

    public String getCurrentUsername() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null)
            return null;
        return authentication.getName();
    }

    public User getUser(String id) {
        User user = userRepo.findOne(id);
        if(user==null) {
            throw new ResourceNotFoundException(String.format("User %s is not found", id));
        }
        return user;
    }

    public User getUserByUsername(String username) {
        LOGGER.info("Find user by username {}", username);
        return userRepo.findByUsername(username);
    }


    public User createUser(UserDto dto) {
        return saveUser(new User(dto));
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(String id, UserDto dto) {
        User user = getUser(id);
        user.setPhone(dto.getPhone());
        user.setUsername(dto.getUsername());
        user.setWechat(dto.getWechat());
        return saveUser(user);
    }

    public void deleteUser(String id) {
        LOGGER.warn("Delete User {}", id);
        if (getUser(id) != null) {
            userRepo.delete(id);
        } else {
            throw new ResourceNotFoundException(String.format("User %s is not found", id));
        }
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User upgradeRole(String id, String role) {
        LOGGER.info("Change user {} role to {}", id, role);
        User user = getUser(id);
        user.getRoles().add(role);
        return saveUser(user);
    }

    public User removeRole(String id, String role) {
        LOGGER.info("Remove user {} role {}", id, role);
        User user = getUser(id);
        user.getRoles().remove(role);
        return saveUser(user);
    }
    
    public boolean hasRole(String id, String role) {
        return getUser(id).getRoles().contains(role);
    }

}
