package com.song.shop.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGroupEntity is a Querydsl query type for GroupEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGroupEntity extends EntityPathBase<GroupEntity> {

    private static final long serialVersionUID = -1352252669L;

    public static final QGroupEntity groupEntity = new QGroupEntity("groupEntity");

    public final NumberPath<Integer> dispOrdr = createNumber("dispOrdr", Integer.class);

    public final StringPath groupNm = createString("groupNm");

    public final NumberPath<Long> groupSeq = createNumber("groupSeq", Long.class);

    public final NumberPath<Long> pGroupSeq = createNumber("pGroupSeq", Long.class);

    public QGroupEntity(String variable) {
        super(GroupEntity.class, forVariable(variable));
    }

    public QGroupEntity(Path<? extends GroupEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGroupEntity(PathMetadata metadata) {
        super(GroupEntity.class, metadata);
    }

}

