package com.guan.auth;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.guan.Application;

// http://docs.spring.io/spring-security/site/docs/current/reference/html/test-mockmvc.html
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class WebSecurityTest {

    private static Logger LOGGER = LoggerFactory.getLogger(WebSecurityTest.class);

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }


    @Test
    public void test() throws Exception {
        JSONObject response = getAccessToken();
        String accessToken = response.getString("access_token");
        String tokenType =  response.getString("token_type");
        String categoryBaseUrl = "/api/category/";
        mvc.perform(get(categoryBaseUrl).header("Authorization", tokenType+" "+accessToken))
            .andDo(print())
            .andExpect(status().isOk());

    }


    private JSONObject getAccessToken() throws Exception {
        String oauthTokenUrl = "http://localhost:8080/oauth/token";
        //@formatter:off
        MvcResult result = mvc.perform(post(oauthTokenUrl)
                .with(httpBasic("clientapp","123456"))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("grant_type","password")
                .param("username", "user1")
                .param("password", "123456"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
      //@formatter:on
        return new JSONObject(result.getResponse().getContentAsString());
    }


}
