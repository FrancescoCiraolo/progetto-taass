package com.github.neocstaass.images.controllers;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@RestController
@RequestMapping("")
public class Images {

    private void saveFile(String uploadDir, String filename, MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(filename);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + filename, ioe);
        }
    }

    @PostMapping("/upload")
    public void upload(@RequestParam String userID, @RequestParam("image") MultipartFile multipartFile) {

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        String uploadDir = "user-photos/" + userID;

        try {
            saveFile(uploadDir, fileName, multipartFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "get/{userID}/{imageName}", method = RequestMethod.GET)
    public ResponseEntity<Resource> getImage(@PathVariable String userID, @PathVariable String imageName) {

        File file = new File(String.format("user-photos/%s/%s", userID, imageName));

        HttpHeaders header = new HttpHeaders();
//        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=img.jpg");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource;
        try {
            resource = new ByteArrayResource(Files.readAllBytes(path));
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.length())
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }
}
