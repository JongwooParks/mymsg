package com.msg.dm.controller.chat;

import com.msg.dm.domain.dto.message.StMessageDTO;
import com.msg.dm.service.chat.message.MsgService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/msg")
public class ChatRestController {
    private final MsgService service;

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public StMessageDTO sendMessages(StMessageDTO message){
        return  service.saveMsg(message);
    }

    @PostMapping("/getRecentMessages")
    public List<StMessageDTO> getMessage(){
        return service.getRecentMessages();
    }
}
