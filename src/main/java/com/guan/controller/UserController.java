package com.guan.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guan.domain.User;
import com.guan.dto.PostDto;
import com.guan.dto.UserDto;
import com.guan.service.PostService;
import com.guan.service.UserService;
import com.guan.util.RoleUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public UserDto getCurrentUser(Principal principal) {
        UserDto dto = new UserDto();
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            dto = new UserDto(user);
        }
        return dto;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Save a User")
    public UserDto createUser(@RequestBody UserDto dto) {
        User User = userService.createUser(dto);
        return new UserDto(User);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDto getUser(@PathVariable("id") String id) {
        return new UserDto(userService.getUser(id));
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update a user's information")
    public UserDto updateUser(@PathVariable("id") String id, @RequestBody UserDto dto) {
        return new UserDto(userService.updateUser(id, dto));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete a user")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "Debug only, return all registered user")
    public List<UserDto> getUsers() {
        List<UserDto> users = new ArrayList<>();
        userService.getAllUsers().stream().forEach(user -> users.add(new UserDto(user)));
        return users;
    }
    
    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
    @ApiOperation(value = "Get all posts under this user")
    public List<PostDto> getPostsUnder(@PathVariable("id") String username) {
        return postService.getPostsOfUser(username).stream().map(p -> new PostDto(p)).collect(Collectors.toList());
    }
    
    @RequestMapping(value = "/{id}/poster", method = RequestMethod.PUT)
    @ApiOperation(value = "Update a user's role")
    public UserDto updateUserRole(@PathVariable("id") String id) {
        return new UserDto(userService.upgradeRole(id, RoleUtil.POSTER));
    }


}
