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

    @PostPersist // PostPersist와 PostUpdate 어노테이션은 JPA에서 엔티티의 생성 및 업데이트 이벤트를 처리하기 위해 사용
    @PostUpdate // allstoredata 엔티티가 생성 또는 업데이트 될 때 호출됨,
    public void postPersist(AllStoreData entity) {
        template.convertAndSend("/topic/db-updates", entity);
    }
}
