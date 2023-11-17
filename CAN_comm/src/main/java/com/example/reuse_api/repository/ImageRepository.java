package com.example.reuse_api.repository;

import com.example.reuse_api.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageData, Long> {
    @Query("SELECT id FROM ImageData ")
    List<Long> findAllIds();
}
