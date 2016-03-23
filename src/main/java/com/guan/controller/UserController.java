package com.guan.controller;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends Controller {
   private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

   @RequestMapping({"/user", "/me"})
   public Map<String, String> user(Principal principal) {
      Map<String, String> map = new LinkedHashMap<>();
      map.put("name", principal.getName());
      return map;
   }
}
