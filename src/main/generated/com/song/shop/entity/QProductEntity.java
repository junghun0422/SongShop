package com.song.shop.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductEntity is a Querydsl query type for ProductEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductEntity extends EntityPathBase<ProductEntity> {

    private static final long serialVersionUID = -1748133581L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductEntity productEntity = new QProductEntity("productEntity");

    public final QCategoryEntity category;

    public final StringPath productDes = createString("productDes");

    public final StringPath productImgPath = createString("productImgPath");

    public final StringPath productNm = createString("productNm");

    public final StringPath productPrice = createString("productPrice");

    public final NumberPath<Integer> productSeq = createNumber("productSeq", Integer.class);

    public final StringPath registerId = createString("registerId");

    public QProductEntity(String variable) {
        this(ProductEntity.class, forVariable(variable), INITS);
    }

    public QProductEntity(Path<? extends ProductEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductEntity(PathMetadata metadata, PathInits inits) {
        this(ProductEntity.class, metadata, inits);
    }

    public QProductEntity(Class<? extends ProductEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QCategoryEntity(forProperty("category")) : null;
    }

}

