package com.msg.dm.controller.chat;

import com.msg.dm.domain.dto.message.StMessageDTO;
import com.msg.dm.domain.dto.user.StUserDTO;
import com.msg.dm.domain.entity.user.StUser;
import com.msg.dm.service.chat.message.MsgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ChatMsgController {
    private final MsgService service;


    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public StMessageDTO sendMessages(StMessageDTO message,  SimpMessageHeaderAccessor headerAccessor){

        Authentication authentication = (Authentication) headerAccessor.getUser();
        StUserDTO user = null;
        if (authentication != null && authentication.isAuthenticated()) {
            // UserDetails를 StUser로 캐스팅
            Object principal = authentication.getPrincipal();
            if (principal instanceof StUser) {
                user = ((StUser) principal).build();
            }
        }

        if(user == null){
            throw new AccessDeniedException("no login");
        }
        message.setSender(user.getUserId());
        return  service.saveMsg(message);
    }
}
