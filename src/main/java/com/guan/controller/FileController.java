package com.guan.controller;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/file")
public class FileController {
    
    @RequestMapping(value = "/{postId}", method = RequestMethod.POST)
    @ApiOperation(value = "Pass in post id")
    public ResponseEntity<String> saveFile(@PathParam("postId") String postId, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
        }
        return new ResponseEntity<String>(HttpStatus.CREATED); 
    }
    
    @RequestMapping(value = "{postId}/{imageId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> getImage(@PathParam("postId") String postId, @PathParam("imageId") String imageId) {
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT); 
    }
}
