package com.example.reuse_api.controller;

import com.example.reuse_api.entity.AllStoreData;
import com.example.reuse_api.entity.ImageData;
import com.example.reuse_api.service.ImageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
public class ImageDataController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/image-ids")
    public @ResponseBody List<Long> getImageIds() {
        List<Long> imageIds = imageService.getAllImageIds();
        List<Long> validImageIds = new ArrayList<>();

        try {
            String jsonUserId = getUserIdFromJson();

            for (Long id : imageIds) {
                ImageData imageData = imageService.getImageData(id);
                if (imageData != null && jsonUserId.equals(imageData.getUserid())) {
                    validImageIds.add(id);
                }
            }
        } catch (IOException e) {
            // 예외 처리
            e.printStackTrace();
        }

        return validImageIds;
    }

    private String getUserIdFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("src/main/resources/user.json");
        // JSON 파일을 AllStoreData 객체로 역직렬화
        ImageData userData = objectMapper.readValue(jsonFile, ImageData.class);

        String jsonUserid = userData.getUserid();

        return jsonUserid;
    }
    @GetMapping(value = "/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody String getImageData(@PathVariable Long id) {
        ImageData imageData = imageService.getImageData(id);
        if (imageData != null) {
            byte[] imageBytes = imageData.getData();
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            return base64Image;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Image not found");
        }
    }

}


