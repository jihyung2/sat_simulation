package com.example.reuse_api.controller;

import com.example.reuse_api.entity.AllStoreData;
import com.example.reuse_api.service.AllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/getDataTable")
public class DataTableController {

    @Autowired
    private AllService allService;

    @GetMapping
    public List<Map<String, Object>> getDataTable() {
        List<AllStoreData> allData = allService.getALLDB();
        List<Map<String, Object>> dataList = new ArrayList<>();

        for (AllStoreData data : allData) {
            Map<String, Object> mapData = new LinkedHashMap<>();
            mapData.put("id", data.getId());
            mapData.put("name", data.getName());
            mapData.put("data", data.getData());
            mapData.put("timestamp", data.getTimestamp());
            dataList.add(mapData);
        }

        return dataList;
    }
}