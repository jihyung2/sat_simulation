package com.example.reuse_api.controller;

import com.example.reuse_api.entity.AllStoreData;
import com.example.reuse_api.service.AllService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/getDataTable")
public class DataTableController {

    @Autowired
    private AllService allService;

    @GetMapping
    public List<Map<String, Object>> getDataTable() throws IOException {
        List<AllStoreData> allData = allService.getALLDB();
        List<Map<String, Object>> dataList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("src/main/resources/user.json");
        // JSON 파일을 AllStoreData 객체로 역직렬화
        AllStoreData userData = objectMapper.readValue(jsonFile, AllStoreData.class);

        String jsonUserid = userData.getUserid();

        // 데이터베이스에서 해당 userid로 조회
        List<AllStoreData> filteredData = allData.stream() // 리스트를 스트림으로 변환
                .filter(data -> jsonUserid.equals(data.getUserid())) // 조건을 만족하는 데이터만 걸러냄
                .collect(Collectors.toList()); //스트림의 데이터 수집, 스트림의 요소를 리스트로 수집

        for (AllStoreData data : filteredData) {
            Map<String, Object> mapData = new LinkedHashMap<>();
            mapData.put("Satid", data.getUserid());
            mapData.put("name", data.getName());
            mapData.put("data", data.getData());
            mapData.put("timestamp", data.getTimestamp());
            dataList.add(mapData);
        }

        return dataList;
    }

}
