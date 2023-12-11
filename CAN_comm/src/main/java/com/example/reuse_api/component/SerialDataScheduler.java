package com.example.reuse_api.component;

import com.example.reuse_api.service.Serialdata;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

// ...

@Component
public class SerialDataScheduler {

    private Serialdata serialdata;

    public SerialDataScheduler(Serialdata serialdata) {
        this.serialdata = serialdata;
    }

    @PostConstruct
    public void init() {
        new Thread(() -> {
            while (true) {
                serialdata.readSerialData();
                try {
                    Thread.sleep(100);  // 100밀리초 대기
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
