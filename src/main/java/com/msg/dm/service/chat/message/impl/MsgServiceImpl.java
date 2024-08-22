package com.msg.dm.service.chat.message.impl;

import com.msg.dm.domain.dto.message.StMessageDTO;
import com.msg.dm.domain.entity.message.StMessage;
import com.msg.dm.repository.chat.message.MsgDSLRepository;
import com.msg.dm.repository.chat.message.MsgRepository;
import com.msg.dm.service.chat.message.MsgService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MsgServiceImpl implements MsgService {
    private final MsgRepository repository;
    private final MsgDSLRepository dslRepository;

    @Override
    public StMessageDTO saveMsg(StMessageDTO message) {
        message.setDateTime(LocalDateTime.now());
        return repository.save(message.toEntity()).toDTO();
    }

    @Override
    public List<StMessageDTO> getRecentMessages() {
        List<StMessageDTO> list = new java.util.ArrayList<>(repository.findTop10ByOrderByDateTimeDesc().stream().map(StMessage::toDTO).toList());
        Collections.reverse(list);
        return list;
    }
}
