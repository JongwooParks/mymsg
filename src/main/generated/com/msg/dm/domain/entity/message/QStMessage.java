package com.msg.dm.domain.entity.message;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStMessage is a Querydsl query type for StMessage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStMessage extends EntityPathBase<StMessage> {

    private static final long serialVersionUID = -905388301L;

    public static final QStMessage stMessage = new QStMessage("stMessage");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> dateTime = createDateTime("dateTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> roomId = createNumber("roomId", Long.class);

    public final StringPath sender = createString("sender");

    public final NumberPath<Long> stId = createNumber("stId", Long.class);

    public QStMessage(String variable) {
        super(StMessage.class, forVariable(variable));
    }

    public QStMessage(Path<? extends StMessage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStMessage(PathMetadata metadata) {
        super(StMessage.class, metadata);
    }

}

