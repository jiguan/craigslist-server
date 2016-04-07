package com.guan.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.guan.Application;
import com.guan.domain.Post;

@WebAppConfiguration
@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class PostServiceTest {
   private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceTest.class);

//   @Mock
//   AddressDao addressDao;


}
