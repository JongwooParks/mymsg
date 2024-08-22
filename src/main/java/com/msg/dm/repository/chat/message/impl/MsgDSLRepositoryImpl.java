package com.msg.dm.repository.chat.message.impl;

import com.msg.dm.repository.chat.message.MsgDSLRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MsgDSLRepositoryImpl implements MsgDSLRepository {
    private final JPAQueryFactory factory;

}
