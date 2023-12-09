package com.example.reuse_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/user-id")
    public ResponseEntity<String> saveUserId(@RequestBody Map<String, String> user) {
        String userId = user.get("userid");

        // Jackson ObjectMapper를 사용하여 JSON 파일에 쓰기
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> userData = new HashMap<>();
        userData.put("userid", userId);

        try {
            // user.json 파일 경로를 적절하게 수정해주세요.
            objectMapper.writeValue(new File("src/main/resources/user.json"), userData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok("User ID received: " + userId);
    }
}
