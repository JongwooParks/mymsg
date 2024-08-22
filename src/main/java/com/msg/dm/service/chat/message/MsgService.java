package com.msg.dm.service.chat.message;

import com.msg.dm.domain.dto.message.StMessageDTO;

import java.util.List;

public interface MsgService {

    public StMessageDTO saveMsg(StMessageDTO message);

    public List<StMessageDTO> getRecentMessages();


}
