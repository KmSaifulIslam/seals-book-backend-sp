package org.example.sealsbookbackendsp.controller;

import org.example.sealsbookbackendsp.dto.ImageDto;
import org.example.sealsbookbackendsp.model.Image;
import org.example.sealsbookbackendsp.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    // Create a new image
    @PostMapping
    public ResponseEntity<Image> createImage(@RequestParam("file") MultipartFile file,
                                             @RequestParam("downloadUrl") String downloadUrl) throws IOException, SQLException {
        Image image = imageService.createImage(file, downloadUrl, null); // Pass product ID if necessary
        return ResponseEntity.ok(image);
    }

    // Update an image
    @PutMapping("/{id}")
    public ResponseEntity<Image> updateImage(@PathVariable Long id,
                                             @RequestParam("file") MultipartFile file,
                                             @RequestParam("downloadUrl") String downloadUrl) throws IOException, SQLException {
        Image updatedImage = imageService.updateImage(id, file, downloadUrl);
        return ResponseEntity.ok(updatedImage);
    }

//    // Get image by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Image> getImageById(@PathVariable Long id) {
//        Image image = imageService.getImageById(id);
//        return ResponseEntity.ok(image);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageDto> getImageById(@PathVariable Long id) throws SQLException, IOException {
        Image image = imageService.getImageById(id);

        // Convert Blob to Base64 (optional, only if you need to send the binary data)
        String base64Image = null;
        if (image.getImage() != null) {
            base64Image = new String(image.getImage().getBinaryStream().readAllBytes());
        }

        // Map to DTO
        ImageDto imageDto = new ImageDto(
                image.getId(),
                image.getFileName(),
                image.getFileType(),
                image.getDownloadUrl(),
                base64Image
        );

        return ResponseEntity.ok(imageDto);
    }


    // Get all images
    @GetMapping("/all")
    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> images = imageService.getAllImages();
        return ResponseEntity.ok(images);
    }

    // Delete an image
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}

