package com.msg.dm.domain.dto.room;

import com.msg.dm.domain.entity.room.ChatRoomUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter @Setter @NoArgsConstructor
public class ChatRoomDTO {

    private Long roomId;
    private String roomOwner;
    private String roomName;

    private List<ChatRoomUserDTO> chatRoomUserList;
}
