package com.guan.controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.guan.service.FileService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/file")
public class FileController {
    private static Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService service;

    @RequestMapping(value = "/{postId}", method = RequestMethod.POST)
    @ApiOperation(value = "Pass in post id")
    public ResponseEntity<String> saveFile(@PathParam("postId") String postId, @RequestParam("file") MultipartFile file) throws Exception {
        LOGGER.debug("Upload file for {}", postId);
        if (!file.isEmpty()) {
            service.saveFile(postId, file);
        }
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{filename}", method = RequestMethod.GET)
    public FileSystemResource getFile(@PathParam("filename") String filename) throws Exception {
        return new FileSystemResource(service.getFile(filename));
    }

    @RequestMapping(value = "/{filename}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteImage(@PathParam("filename") String filename) {
        service.deleteFile(filename);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
}
