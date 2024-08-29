package com.msg.dm.domain.dto.room;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @NoArgsConstructor
public class ChatRoomUserDTO {

    private Long id;
    private Long roomId;
    private String userId;
    private String roomName;

}
