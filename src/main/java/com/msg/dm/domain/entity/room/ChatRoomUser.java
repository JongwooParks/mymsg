package com.msg.dm.domain.entity.room;


import com.msg.dm.domain.dto.room.ChatRoomUserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="CHAT_ROOM_USER")
@Entity
@Getter @Setter @NoArgsConstructor
public class ChatRoomUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="roomId", referencedColumnName = "roomId")
    private ChatRoom chatRoom;

    private String userId;

    public ChatRoomUserDTO build(){
        ChatRoomUserDTO chatRoomUserDTO = new ChatRoomUserDTO();
        chatRoomUserDTO.setId(this.id);
        chatRoomUserDTO.setUserId(this.userId);
        chatRoomUserDTO.setRoomName(this.chatRoom.getRoomName());
        chatRoomUserDTO.setRoomId(this.chatRoom.getRoomId());
        return chatRoomUserDTO;
    }
}
