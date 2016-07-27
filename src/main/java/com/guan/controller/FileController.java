package com.guan.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.guan.service.FileService;

import io.swagger.annotations.ApiOperation;
import net.sf.jmimemagic.Magic;

@RestController
@RequestMapping("/api/file")
public class FileController {
    private static Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService service;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Pass in post id")
    public ResponseEntity<String> saveFile(@RequestParam("id") String postId, @RequestParam("file") MultipartFile file) throws Exception {
        LOGGER.debug("Upload file for {}", postId);
        if (!file.isEmpty()) {
            service.saveFile(postId, file);
        }
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

   
    
    @RequestMapping(value = "/{filename:.+}", method = RequestMethod.GET)
    public void loadAssetFile(@PathVariable("filename") String filename, HttpServletResponse response) throws Exception {
        LOGGER.debug("Get file {}", filename);
        File assetFile = service.getFile(filename);
        InputStream inputStream = new FileInputStream(assetFile);
        String mime = Magic.getMagicMatch(assetFile, true).getMimeType();
        LOGGER.debug("File {} mime type {}", filename, mime);
        response.setContentType(mime);
        response.setHeader("Content-Length", String.valueOf(assetFile.length()));
        int read = 0;
        byte[] buffer = new byte[1024];
        OutputStream outputSteam = response.getOutputStream();
        while ((read = inputStream.read(buffer)) != -1) {
            outputSteam.write(buffer, 0, read);
            outputSteam.flush();
        }
        outputSteam.close();
        inputStream.close();
    }
    
    
    @RequestMapping(value = "/{filename}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteImage(@RequestParam("id") String postId, @PathVariable("filename") String filename) {
        service.deleteFile(postId, filename);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
}
