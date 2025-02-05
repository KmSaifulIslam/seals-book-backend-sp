package org.example.sealsbookbackendsp.controller;

import org.example.sealsbookbackendsp.model.Image;
import org.example.sealsbookbackendsp.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/images")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            Image image = imageService.saveImage(file);
            return ResponseEntity.ok("Image uploaded successfully with ID: " + image.getId());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Optional<Image> image = imageService.getImage(id);
        return image.map(img -> ResponseEntity.ok()
                        .header("Content-Type", img.getFileType())
                        .body(img.getImage()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
