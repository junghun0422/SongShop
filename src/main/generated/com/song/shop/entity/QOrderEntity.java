package com.song.shop.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderEntity is a Querydsl query type for OrderEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrderEntity extends EntityPathBase<OrderEntity> {

    private static final long serialVersionUID = -480985966L;

    public static final QOrderEntity orderEntity = new QOrderEntity("orderEntity");

    public final StringPath customerId = createString("customerId");

    public final DateTimePath<java.sql.Timestamp> orderDateTime = createDateTime("orderDateTime", java.sql.Timestamp.class);

    public final NumberPath<Long> orderSeq = createNumber("orderSeq", Long.class);

    public final ListPath<ProductEntity, QProductEntity> products = this.<ProductEntity, QProductEntity>createList("products", ProductEntity.class, QProductEntity.class, PathInits.DIRECT2);

    public final NumberPath<Integer> totalPrice = createNumber("totalPrice", Integer.class);

    public QOrderEntity(String variable) {
        super(OrderEntity.class, forVariable(variable));
    }

    public QOrderEntity(Path<? extends OrderEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderEntity(PathMetadata metadata) {
        super(OrderEntity.class, metadata);
    }

}

