package org.example.sealsbookbackendsp.service;

import org.example.sealsbookbackendsp.model.Image;
import org.example.sealsbookbackendsp.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialBlob;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    // Create a new Image
    public Image createImage(MultipartFile file, String downloadUrl, Long productId) throws IOException, SQLException {
        Blob blob = new SerialBlob(file.getBytes());
        Image image = new Image();
        image.setFileName(file.getOriginalFilename());
        image.setFileType(file.getContentType());
        image.setImage(blob);
        image.setDownloadUrl(downloadUrl);
        // If you want to link to a Product, you can set the product by its ID here
        return imageRepository.save(image);
    }

    // Update an existing Image
    public Image updateImage(Long id, MultipartFile file, String downloadUrl) throws IOException, SQLException {
        Optional<Image> existingImageOpt = imageRepository.findById(id);
        if (existingImageOpt.isPresent()) {
            Image image = existingImageOpt.get();
            Blob blob = new SerialBlob(file.getBytes());
            image.setFileName(file.getOriginalFilename());
            image.setFileType(file.getContentType());
            image.setImage(blob);
            image.setDownloadUrl(downloadUrl);
            return imageRepository.save(image);
        } else {
            throw new RuntimeException("Image not found with id: " + id);
        }
    }

    // Get an Image by ID
    public Image getImageById(Long id) {
        return imageRepository.findById(id).orElseThrow(() -> new RuntimeException("Image not found with id: " + id));
    }

    // Get all Images
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    // Delete an Image
    public void deleteImage(Long id) {
        if (imageRepository.existsById(id)) {
            imageRepository.deleteById(id);
        } else {
            throw new RuntimeException("Image not found with id: " + id);
        }
    }
}
