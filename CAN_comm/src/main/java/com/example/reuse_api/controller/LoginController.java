package com.example.reuse_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

        return ResponseEntity.ok("User ID received: " + userId);
    }
}
