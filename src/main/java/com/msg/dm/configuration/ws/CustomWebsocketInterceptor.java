package com.msg.dm.configuration.ws;

import com.msg.dm.configuration.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

@RequiredArgsConstructor
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 99)
public class CustomWebsocketInterceptor implements ChannelInterceptor {
    private final JwtTokenProvider jwtProvider;

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);

        if (accessor.getCommand() == StompCommand.CONNECT) {
            String authToken = accessor.getFirstNativeHeader("Authorization");

            if (authToken == null || !jwtProvider.validateToken(authToken)) {
                throw new IllegalArgumentException("Authentication failed!!");
            }

            // UsernamePasswordAuthenticationToken 발급
            UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) jwtProvider.getAuthentication(authToken);
            // accessor에 등록
            accessor.setUser(authentication);

        }

        return message;
    }

}
