package com.example.reuse_api.service;

import com.example.reuse_api.entity.ImageData;
import com.example.reuse_api.repository.ImageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class ImageService {

    private ImageRepository imageRepository;

    @Autowired
    public void ImageAllService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public ImageData saveimageDB(ImageData storedata) {
        return imageRepository.save(storedata);
    }

    public List<ImageData> getImageDB() {
        return imageRepository.findAll();
    }

    public ImageData getImageData(Long id) {
        Optional<ImageData> imageDataOptional = imageRepository.findById(id);
        return imageDataOptional.orElse(null);
    }

    public List<Long> getAllImageIds() {
        return imageRepository.findAllIds();
    }

}
