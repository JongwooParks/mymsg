package com.msg.dm.domain.dto.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.msg.dm.domain.entity.message.StMessage;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Getter @Setter
@ToString @NoArgsConstructor @AllArgsConstructor
public class StMessageDTO {

    private Long stId;
    private String sender;
    private String content;
    private LocalDateTime dateTime;
    private Long roomId;

    public StMessage toEntity(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.convertValue(this, StMessage.class);
    }
}
