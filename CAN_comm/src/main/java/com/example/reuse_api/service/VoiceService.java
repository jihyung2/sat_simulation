package com.example.reuse_api.service;

import com.example.reuse_api.entity.VoiceData;
import com.example.reuse_api.repository.VoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoiceService {

    private VoiceRepository voiceRepository;

    @Autowired
    public void voiceAllService(VoiceRepository voiceRepository) {
        this.voiceRepository = voiceRepository;
    }

    public VoiceData savevoiceDB(VoiceData storedata) {
        return voiceRepository.save(storedata);
    }

    public List<VoiceData> getVoiceDB() {
        return voiceRepository.findAll();
    }

    public VoiceData getVoiceData(Long id) {
        Optional<VoiceData> voiceDataOptional = voiceRepository.findById(id);
        return voiceDataOptional.orElse(null);
    }

    public List<Long> getAllVoiceIds() {
        return voiceRepository.findAllIds();
    }
}
