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

    public List<String> getselImageDB() {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/user.json");
        try {
            List<Map<String, String>> list = objectMapper.readValue(inputStream, List.class);
            List<String> useridList = new ArrayList<>();

            for (Map<String, String> map : list) {
                String userid = map.get("userid");
                // userid 값을 사용하여 작업 수행
                // 예시: userid 값을 출력해보기
                System.out.println(userid);
                useridList.add(userid);
            }

            return useridList;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
    public List<ImageData> getDBByUserid(String userid) {
        return imageRepository.findByUserid(userid);
    }


}
