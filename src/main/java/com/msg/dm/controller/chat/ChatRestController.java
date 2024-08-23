package com.msg.dm.controller.chat;

import com.msg.dm.domain.dto.message.StMessageDTO;
import com.msg.dm.domain.entity.user.StUser;
import com.msg.dm.service.chat.message.MsgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/msg")
@Slf4j
public class ChatRestController {
    private final MsgService service;

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public StMessageDTO sendMessages(StMessageDTO message, @AuthenticationPrincipal StUser userDetails){
        log.info(userDetails.getUserId());
        return  service.saveMsg(message);
    }

    @PostMapping("/getRecentMessages")
    public List<StMessageDTO> getMessage(){
        return service.getRecentMessages();
    }
}
