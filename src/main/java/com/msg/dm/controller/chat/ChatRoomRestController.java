package com.msg.dm.controller.chat;

import com.msg.dm.domain.dto.room.ChatRoomDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class ChatRoomRestController {

//    @PostMapping("/create")
//    public ResponseEntity<?> createRoom(@RequestBody ChatRoomDTO room){
//
//        try{
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}
