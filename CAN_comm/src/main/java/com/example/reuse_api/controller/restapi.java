package com.example.reuse_api.controller;

import com.example.reuse_api.component.MyDatabaseComponent;
import com.example.reuse_api.entity.AllStoreData;
import com.example.reuse_api.entity.ImageData;
import com.example.reuse_api.entity.getsetdata;
import com.example.reuse_api.entity.SatelliteData;
import com.example.reuse_api.service.AllService;
import com.example.reuse_api.service.DBService;
import com.example.reuse_api.service.ImageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 가정, 위성에서 보낸 데이터 $(시작) %(종료) 기호로 구분하기
// Map은 key와 value의 쌍으로 이루어진 데이터의 집합이다.
// Key 값을 String, value값을 Object형으로 put 메소드를 통해 입력가능
@RestController
public class restapi {

    private MyDatabaseComponent myDatabaseComponent;

    private Map<String, String> sensorTypeMap;

    @Autowired
    public restapi(MyDatabaseComponent myDatabaseComponent) { //Jdbc 템플릿 사용 의존성
        this.myDatabaseComponent = myDatabaseComponent;
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
        String satelliteId = "K"+data.getSatname();
        String sensorid = data.getSensorname();
        String streamData = data.getData();

        String sensorName = sensorTypeMap.get(sensorid); // json으로 id값을 문자열로 변환

        myDatabaseComponent.ensureTableExists(satelliteId);

        if (sensorName.equals("Image")){
            String satelliteIdimage = "K"+data.getSatname()+"Image";
            byte[] imageBytes = java.util.Base64.getDecoder().decode(streamData);
            myDatabaseComponent.insertImageSensorData(satelliteIdimage, sensorName, imageBytes);
        }
        else if (sensorName.equals("Voice")){
            String satelliteIdvoice = "K"+data.getSatname()+"Voice";
            byte[] imageBytes = java.util.Base64.getDecoder().decode(streamData);
            myDatabaseComponent.insertVoiceSensorData(satelliteIdvoice, sensorName, imageBytes);
        }
        else {
            myDatabaseComponent.insertSensorData(satelliteId, sensorName, streamData);
        }
        return "Sensor data processed successfully";
    }

}

