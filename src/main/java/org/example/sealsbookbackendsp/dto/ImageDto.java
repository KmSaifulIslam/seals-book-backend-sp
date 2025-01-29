package org.example.sealsbookbackendsp.dto;

import lombok.Data;

@Data
public class ImageDto {
    private Long id;
    private String fileName;
    private String fileType;
    private String downloadUrl;
    private String base64Image;

    public ImageDto(Long id, String fileName, String fileType, String downloadUrl, String base64Image) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.downloadUrl = downloadUrl;
        this.base64Image = base64Image;
    }

    // Getters and Setters
}
