package com.guan.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.guan.Application;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class FileServiceTest {
    
    @Autowired
    private FileService service;
    
    @Test
    public void testSaveFile() throws Exception {
        String postId = "123";
        MockMultipartFile uploadFile = new MockMultipartFile("file", "filename", null, "bar".getBytes());
        service.saveFile(postId, uploadFile);
        
    }

}
