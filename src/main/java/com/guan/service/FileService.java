package com.guan.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.guan.domain.Post;
import com.guan.util.URLUtil;


@Service
public class FileService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileService.class);

    @Value("${post.file.directory}")
    private String directory;

    @Autowired
    private PostService service;

    public void saveFile(String postId, MultipartFile uploadFile) throws Exception {
        LOGGER.warn("Save file for {}", postId);
        String ext = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
        String name =  FilenameUtils.getBaseName(uploadFile.getOriginalFilename());
        String filename = postId + "_" + name + "_" + new Date().getTime()+"."+ext;
        
        LOGGER.debug("Filename: {}", filename);
        String filepath = Paths.get(directory, filename).toString();

        File file = new File(filepath);
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs())
            throw new IOException("Could not create directory " + file.getParent());

        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
        stream.write(uploadFile.getBytes());
        stream.close();
        
        Post post = service.getPost(postId);
        post.getFiles().add(filename);
        service.savePost(post);
    }

    public File getFile(String filename) throws Exception {
        filename = URLUtil.decode(filename);
        String filepath = directory + "/" + filename;
        LOGGER.debug("Get file under path {}", filepath);
        File file = new File(filepath);
        if (file.exists()) {
            return file;
        } else {
            throw new IOException(String.format("File with path %s doesn't exist", filepath));
        }
    }

    public void deleteFile(String id, String filename) {
        Post post = service.getPost(id);
        post.getFiles().remove(filename);
        
        String filepath = Paths.get(directory, filename).toString();
        
        File file = new File(filepath);

        if (file.delete()) {
            LOGGER.debug("File {} is deleted", filepath);
        } else {
            LOGGER.debug("File {} doesn't exist", filepath);
        }
    }

}
