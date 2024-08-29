package com.msg.dm.repository.chat.message.impl;

import com.msg.dm.domain.dto.message.StMessageDTO;
import com.msg.dm.domain.entity.message.QStMessage;
import com.msg.dm.domain.entity.message.StMessage;
import com.msg.dm.repository.chat.message.MsgDSLRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.msg.dm.domain.entity.message.QStMessage.stMessage;

@Repository
@RequiredArgsConstructor
public class MsgDSLRepositoryImpl implements MsgDSLRepository {
    private final JPAQueryFactory factory;


    @Override
    public List<StMessageDTO> getRecentMessages(Long roomId) {
        List<StMessage> list =
        factory.selectFrom(stMessage)
                .where(stMessage.roomId.eq(roomId))
                .orderBy(stMessage.dateTime.desc())
                .limit(7).fetch();

        return list.stream().map(StMessage::toDTO).toList();
    }
}
