package com.guan.repo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guan.Application;
import com.guan.domain.User;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class UserRepoTest {

    private static Logger LOGGER = LoggerFactory.getLogger(UserRepoTest.class);
    ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private UserRepository repo;

    @Test
    public void testGetUserByUsername() throws Exception {
        User user = repo.findByUsername("user2");
        LOGGER.debug(mapper.writeValueAsString(user));
        assertNotNull(user);
    }

}
