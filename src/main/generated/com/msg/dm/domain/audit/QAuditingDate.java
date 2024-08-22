package com.msg.dm.domain.audit;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuditingDate is a Querydsl query type for AuditingDate
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QAuditingDate extends EntityPathBase<AuditingDate> {

    private static final long serialVersionUID = 2002890791L;

    public static final QAuditingDate auditingDate = new QAuditingDate("auditingDate");

    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updateDate = createDateTime("updateDate", java.time.LocalDateTime.class);

    public QAuditingDate(String variable) {
        super(AuditingDate.class, forVariable(variable));
    }

    public QAuditingDate(Path<? extends AuditingDate> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuditingDate(PathMetadata metadata) {
        super(AuditingDate.class, metadata);
    }

}

