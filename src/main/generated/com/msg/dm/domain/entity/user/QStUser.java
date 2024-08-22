package com.msg.dm.domain.entity.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStUser is a Querydsl query type for StUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStUser extends EntityPathBase<StUser> {

    private static final long serialVersionUID = -1922310589L;

    public static final QStUser stUser = new QStUser("stUser");

    public final com.msg.dm.domain.audit.QAuditingDate _super = new com.msg.dm.domain.audit.QAuditingDate(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath password = createString("password");

    public final EnumPath<com.msg.dm.domain.enumulation.user.RoleType> roleType = createEnum("roleType", com.msg.dm.domain.enumulation.user.RoleType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public final StringPath userId = createString("userId");

    public final EnumPath<com.msg.dm.domain.enumulation.user.UserStatus> userStatus = createEnum("userStatus", com.msg.dm.domain.enumulation.user.UserStatus.class);

    public QStUser(String variable) {
        super(StUser.class, forVariable(variable));
    }

    public QStUser(Path<? extends StUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStUser(PathMetadata metadata) {
        super(StUser.class, metadata);
    }

}

