//package com.msg.dm.configuration.ws;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.simp.SimpMessageType;
//import org.springframework.messaging.support.ChannelInterceptor;
//import org.springframework.security.authorization.AuthorizationManager;
//import org.springframework.security.config.annotation.web.socket.EnableWebSocketSecurity;
//import org.springframework.security.messaging.access.intercept.MessageMatcherDelegatingAuthorizationManager;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//
//@Configuration
//@RequiredArgsConstructor
//@EnableWebSocketSecurity
//@Order(Ordered.HIGHEST_PRECEDENCE + 99)
//public class WsSecurityConfig{
//
//    @Bean
//    public AuthorizationManager<Message<?>> messageAuthorizationManager(MessageMatcherDelegatingAuthorizationManager.Builder messages) {
//        messages
//                .nullDestMatcher().permitAll()
//                .simpTypeMatchers(SimpMessageType.CONNECT).permitAll()
//                .simpTypeMatchers(SimpMessageType.SUBSCRIBE).authenticated()
//                .simpTypeMatchers(SimpMessageType.MESSAGE).authenticated()
//                .anyMessage().denyAll();
//
//        return messages.build();
//
//    }
//
//    @Bean("csrfChannelInterceptor")
//    public ChannelInterceptor csrfChannelInterceptor() {
//        return new ChannelInterceptor() {
//        };
//    }
//
//}
