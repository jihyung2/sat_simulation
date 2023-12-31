package com.example.reuse_api.controller;


import com.example.reuse_api.entity.*;
import com.example.reuse_api.service.AllService;
import com.example.reuse_api.service.ImageService;
import com.example.reuse_api.service.VoiceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 가정, 위성에서 보낸 데이터 $(시작) %(종료) 기호로 구분하기
// Map은 key와 value의 쌍으로 이루어진 데이터의 집합이다.
// Key 값을 String, value값을 Object형으로 put 메소드를 통해 입력가능


@RestController
public class restapi {
    @Autowired
    private AllService allService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private VoiceService voiceService;


    private Map<String, String> sensorTypeMap;

    @Autowired
    public restapi() { //
        //this.myDatabaseComponent = myDatabaseComponent;
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/sensor_rule.json");
        try {
            List<Map<String, String>> list = objectMapper.readValue(inputStream, List.class);
            sensorTypeMap = new HashMap<>();
            for (Map<String, String> item : list) {
                sensorTypeMap.put(item.get("sensorID"), item.get("sensorType"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @PostMapping("/sensor")
    public String sensorData(@RequestBody getsetdata data) throws IOException {

        String satelliteId = data.getSatname();
        String sensorid = data.getSensorname();
        String streamData = data.getData();

        AllStoreData allStoreData = new AllStoreData();
        ImageData imageData = new ImageData();
        VoiceData voiceData = new VoiceData();

        String sensorName = sensorTypeMap.get(sensorid); // json으로 id값을 문자열로 변환


        if (sensorName.equals("Image")){
            byte[] imageBytes = java.util.Base64.getDecoder().decode(streamData);
            imageData.setName("Image");
            imageData.setUserid(satelliteId);
            imageData.setData(imageBytes);
            imageService.saveimageDB(imageData);
            //messagingTemplate.convertAndSend("/topic/image-updates", imageData);

        }
        else if (sensorName.equals("Voice")){
            byte[] voiceBytes = java.util.Base64.getDecoder().decode(streamData);
            voiceData.setName("Voice");
            voiceData.setUserid(satelliteId);
            voiceData.setData(voiceBytes);
            voiceService.savevoiceDB(voiceData);
            //messagingTemplate.convertAndSend("/topic/db-updates", voiceData);
        }
        else { // 그외 나머지 센서
            allStoreData.setName(sensorName);
            allStoreData.setUserid(satelliteId);
            allStoreData.setData(streamData);
            allService.saveAllDB(allStoreData);
//            ObjectMapper objectMapper = new ObjectMapper();
//            String allStoreDataJson = objectMapper.writeValueAsString(allStoreData);
//            webSocketHandler.sendTextMessageToAll("77777New " + sensorName + " data received from " + satelliteId);
        }
        return "Sensor data processed successfully";
    }

}

