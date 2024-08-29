package com.msg.dm.repository.chat.message;

import com.msg.dm.domain.entity.message.StMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MsgRepository extends JpaRepository<StMessage,Long> {

    public List<StMessage> findTop7ByOrderByDateTimeDesc();
}
