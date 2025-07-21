package com.berry.project.entity.qna;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCustomerIqFile is a Querydsl query type for CustomerIqFile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomerIqFile extends EntityPathBase<CustomerIqFile> {

    private static final long serialVersionUID = 845245117L;

    public static final QCustomerIqFile customerIqFile = new QCustomerIqFile("customerIqFile");

    public final NumberPath<Long> bno = createNumber("bno", Long.class);

    public final StringPath fileName = createString("fileName");

    public final NumberPath<Long> fileSize = createNumber("fileSize", Long.class);

    public final NumberPath<Integer> fileType = createNumber("fileType", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public final StringPath saveDir = createString("saveDir");

    public final StringPath uuid = createString("uuid");

    public QCustomerIqFile(String variable) {
        super(CustomerIqFile.class, forVariable(variable));
    }

    public QCustomerIqFile(Path<? extends CustomerIqFile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustomerIqFile(PathMetadata metadata) {
        super(CustomerIqFile.class, metadata);
    }

}

