package com.msg.dm.message;

import com.msg.dm.repository.chat.message.MsgDSLRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageTest {
    @Autowired
    MsgDSLRepository dslRepository;

    @Test
    public void test(){
        System.out.println(dslRepository.getRecentMessages(123l));
    }
}
