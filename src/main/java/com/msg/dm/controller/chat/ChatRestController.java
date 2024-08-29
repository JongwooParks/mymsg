package com.msg.dm.controller.chat;

import com.msg.dm.domain.dto.message.StMessageDTO;
import com.msg.dm.domain.dto.user.StUserDTO;
import com.msg.dm.domain.entity.user.StUser;
import com.msg.dm.service.chat.message.MsgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.messaging.SessionConnectEvent;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/msg")
@Slf4j
public class ChatRestController {
    private final MsgService service;

    @PostMapping("/getRecentMessages")
    public List<StMessageDTO> getMessage(@RequestBody StMessageDTO dto){
        return service.getRecentMessages(dto.getRoomId());
    }


}
