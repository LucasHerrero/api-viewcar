package com.concesionario.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.concesionario.entity.UploadResponse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ImageController {

    private static final String UPLOADED_FOLDER = "uploads/";

    @PostMapping("/upload")
    public UploadResponse singleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new RuntimeException("Please select a file to upload");
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.createDirectories(path.getParent());
            Files.write(path, bytes);

            return new UploadResponse(file.getOriginalFilename(), LocalDateTime.now(ZoneId.of("Europe/Madrid")));

        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file", e);
        }
    }

    @GetMapping("/images/{imageName}")
    public ResponseEntity<Resource> serveImage(@PathVariable String imageName) {
        Path imagePath = Paths.get(UPLOADED_FOLDER + imageName);
        Resource image;
        try {
            image = new UrlResource(imagePath.toUri());
            if (image.exists() || image.isReadable()) {
                return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + image.getFilename() + "\"").body(image);
            } else {
                throw new RuntimeException("Could not read image!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}