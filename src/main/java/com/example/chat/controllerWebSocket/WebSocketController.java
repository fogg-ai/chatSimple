package com.example.chat.controllerWebSocket;


import com.example.chat.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @MessageMapping("/send")
    @SendTo("/back/free")
    public Message sendMessage(@Payload Message message) {
        return message;
    }

    @MessageMapping("/add")
    @SendTo("/back/free")
    public Message newPerson(@Payload Message message,
                               SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }

}
