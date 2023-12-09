package com.example.reuse_api.service;

import com.example.reuse_api.entity.AllStoreData;
import com.example.reuse_api.repository.AllRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class AllService {

    private final AllRepository allRepository;

    @Autowired
    public AllService(AllRepository allRepository) {
        this.allRepository = allRepository;
    }

    public AllStoreData saveAllDB(AllStoreData storedata) {
        return allRepository.save(storedata);
    }

    public List<AllStoreData> getALLDB() {
        return allRepository.findAll();
    }
    private Map<String, String> useridTypeMap;
    public List<String> getSelDB() {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/user.json");
        try {
            List<Map<String, String>> list = objectMapper.readValue(inputStream, List.class);
            List<String> useridList = new ArrayList<>();

            for (Map<String, String> map : list) {
                String userid = map.get("userid");
                // userid 값을 사용하여 작업 수행
                // 예시: userid 값을 출력해보기
                System.out.println(userid);
                useridList.add(userid);
            }

            return useridList;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }


    public AllStoreData getDBByUserid(String userid) {
        return allRepository.findByUserid(userid);
    }



//    public List<AllStoreData> getDeleteDB(String name) { //Request에서 받은 삭제할 문제 이름을
//        // 문제 이름에 해당하는 문제를 찾습니다.
//        List<AllStoreData> deleteProblems = allRepository.findByName(name); // Repository에서 name을 찾기
//        //List<Problem> deleteProblems = problemRepository.findAll(); 이렇게하면 모든 문제를 다 지우는 내용임
//        // 찾은 문제를 삭제합니다.
//        allRepository.deleteAll(deleteProblems); // 찾은 이름과 연결된 정보를 다 지운다.
//
//        return deleteProblems;
    //}
}
