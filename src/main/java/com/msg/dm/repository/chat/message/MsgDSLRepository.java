package com.msg.dm.repository.chat.message;

import com.msg.dm.domain.dto.message.StMessageDTO;

import java.util.List;

public interface MsgDSLRepository {

    public List<StMessageDTO> getRecentMessages(Long roomId);

}
