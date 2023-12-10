package com.example.reuse_api.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/my-websocket-endpoint")
    @SendTo("/topic/messages")
    public String handle(String message) {
        return message + " received";
    }
}
