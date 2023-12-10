package com.example.reuse_api.entity;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class EntityListener {
    private static SimpMessagingTemplate template;

    @Autowired
    public EntityListener(SimpMessagingTemplate template) {
        EntityListener.template = template;
    }

    @PostPersist
    @PostUpdate
    public void postPersist(AllStoreData entity) {
        template.convertAndSend("/topic/db-updates", entity);
    }
}