package com.guan.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.guan.dto.UserDto;
import com.guan.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/user")
public class UserController extends Controller {
   private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
   
   @Autowired
   private UserService service;

   @RequestMapping(value = "/me", method = RequestMethod.GET)
   public Map<String, String> getCurrentUser(Principal principal) {
      Map<String, String> map = new LinkedHashMap<>();
      map.put("name", principal.getName());
      return map;
   }
   
   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public UserDto getUser(@PathVariable("id") String id) {
       return new UserDto(service.getUser(id));
   }
   
   @RequestMapping(value = "/", method = RequestMethod.POST)
   @ApiOperation(value = "Save a User")
   public UserDto createUser(@RequestBody UserDto dto) {
      User User = service.createUser(dto);
      return new UserDto(User);
   }
   
   
   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
   @ApiOperation(value = "Update a user's information")
   public UserDto updateUser(@PathVariable("id") String id, @RequestBody UserDto dto) {
      return new UserDto(service.updateUser(id, dto));
   }
   
   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   @ApiOperation(value = "Delete a user")
   public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
      service.deleteUser(id);
      return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
   }
   
   @RequestMapping(value = "/all", method = RequestMethod.GET)
   @ApiOperation(value = "Debug only, return all registered user")
   public List<UserDto> getUsers() {
       List<UserDto> users = new ArrayList<>();
       service.getAllUsers().stream().forEach(user -> users.add(new UserDto(user)));
       return users;
   }
   
        
}
