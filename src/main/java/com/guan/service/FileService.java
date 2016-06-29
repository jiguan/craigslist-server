package com.guan.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileService.class);

    @Value("${post.file.directory}")
    private String directory;

    @Autowired
    private PostService service;

    public void saveFile(String postId, MultipartFile uploadFile) throws Exception {
        LOGGER.debug("Save file for {}", postId);
        String filename = postId + "_" + uploadFile.getOriginalFilename() + "_" + new Date().getTime();
        LOGGER.debug("File path: {}", filename);
        String filepath = Paths.get(directory, filename).toString();

        File file = new File(filepath);
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs())
            throw new IOException("Could not create directory " + file.getParent());

        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
        stream.write(uploadFile.getBytes());
        stream.close();
    }

    public File getFile(String filename) throws Exception {
        String filepath = directory + "/" + filename;
        File file = new File(filepath);
        if (file.exists()) {
            return file;
        } else {
            throw new IOException(String.format("File with path %s doesn't exist", filepath));
        }
    }

    public void deleteFile(String filename) {
        String filepath = Paths.get(directory, filename).toString();
        File file = new File(filepath);

        if (file.delete()) {
            LOGGER.debug("File {} is deleted", filepath);
        } else {
            LOGGER.debug("File {} doesn't exist", filepath);
        }
    }

}
