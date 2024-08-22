package com.msg.dm.domain.entity.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.msg.dm.domain.dto.message.StMessageDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="ST_MESSAGE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stId;
    private String sender;
    private String content;
    private LocalDateTime dateTime;

    public StMessageDTO toDTO(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.convertValue(this, StMessageDTO.class);
    }

}