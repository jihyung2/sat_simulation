package com.example.reuse_api.repository;

import com.example.reuse_api.entity.VoiceData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoiceRepository extends JpaRepository<VoiceData, Long> {
    @Query("SELECT id FROM VoiceData ")
    List<Long> findAllIds();
}
