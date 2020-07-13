package com.song.shop.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserEntity is a Querydsl query type for UserEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserEntity extends EntityPathBase<UserEntity> {

    private static final long serialVersionUID = -393190483L;

    public static final QUserEntity userEntity = new QUserEntity("userEntity");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> auth_level = createNumber("auth_level", Integer.class);

    public final ListPath<CategoryEntity, QCategoryEntity> categories = this.<CategoryEntity, QCategoryEntity>createList("categories", CategoryEntity.class, QCategoryEntity.class, PathInits.DIRECT2);

    public final StringPath detail_address = createString("detail_address");

    public final StringPath email = createString("email");

    public final StringPath password = createString("password");

    public final StringPath phone_num = createString("phone_num");

    public final DateTimePath<java.sql.Timestamp> regist_dt = createDateTime("regist_dt", java.sql.Timestamp.class);

    public final StringPath user_id = createString("user_id");

    public final StringPath user_nm = createString("user_nm");

    public final StringPath zip_code = createString("zip_code");

    public QUserEntity(String variable) {
        super(UserEntity.class, forVariable(variable));
    }

    public QUserEntity(Path<? extends UserEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserEntity(PathMetadata metadata) {
        super(UserEntity.class, metadata);
    }

}

