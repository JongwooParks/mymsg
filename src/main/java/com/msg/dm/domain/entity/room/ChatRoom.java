package com.msg.dm.domain.entity.room;

import com.msg.dm.domain.dto.room.ChatRoomDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="CHAT_ROOM")
@Entity
@Getter
@Setter @NoArgsConstructor
public class ChatRoom {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    private String roomOwner;
    private String roomName;

    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChatRoomUser> chatRoomUserList;

    public ChatRoomDTO build(){
        ChatRoomDTO chatRoomDTO = new ChatRoomDTO();
        chatRoomDTO.setRoomId(this.roomId);
        chatRoomDTO.setRoomName(this.roomName);
        chatRoomDTO.setRoomOwner(this.roomOwner);
        chatRoomDTO.setChatRoomUserList(chatRoomUserList.stream().map(ChatRoomUser::build).toList());
        return chatRoomDTO;
    }

}
